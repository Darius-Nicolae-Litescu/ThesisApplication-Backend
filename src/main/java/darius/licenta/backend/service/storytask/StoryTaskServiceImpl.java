package darius.licenta.backend.service.storytask;

import darius.licenta.backend.domain.sql.*;
import darius.licenta.backend.dto.normal.attachment.AttachmentResponseDto;
import darius.licenta.backend.dto.normal.comment.storytask.InsertStoryTaskCommentDto;
import darius.licenta.backend.dto.normal.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.normal.storytask.InsertStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.ResponseStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.UpdateStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.fullinformation.FullInformationStoryTaskDto;
import darius.licenta.backend.exception.UserNotFoundException;
import darius.licenta.backend.mapper.normal.attachment.AttachmentMapper;
import darius.licenta.backend.mapper.normal.comment.CommentMapper;
import darius.licenta.backend.mapper.normal.storytask.StoryTaskMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.jpa.*;
import darius.licenta.backend.service.attachment.CommentAttachmentOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class StoryTaskServiceImpl implements StoryTaskService {

    private final CommentAttachmentOperationsService commentAttachmentOperationsService;

    private final StoryTaskRepository storyTaskRepository;

    private final AttachmentRepository attachmentRepository;

    private final StoryRepository storyRepository;

    private final UserRepository userRepository;

    private final CommentRepository commentRepository;

    private final StoryTaskMapper storyTaskMapper;

    private final CommentMapper commentMapper;

    private final AttachmentMapper attachmentMapper;

    @Value("${api.rest.base.uri}")
    private String restApiBaseUri;

    @Autowired
    public StoryTaskServiceImpl(CommentAttachmentOperationsService commentAttachmentOperationsService, StoryTaskRepository storyTaskRepository,
                                AttachmentRepository attachmentRepository, StoryRepository storyRepository, UserRepository userRepository,
                                CommentRepository commentRepository, StoryTaskMapper storyTaskMapper, CommentMapper commentMapper,
                                AttachmentMapper attachmentMapper) {
        this.commentAttachmentOperationsService = commentAttachmentOperationsService;
        this.storyTaskRepository = storyTaskRepository;
        this.attachmentRepository = attachmentRepository;
        this.storyRepository = storyRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.storyTaskMapper = storyTaskMapper;
        this.commentMapper = commentMapper;
        this.attachmentMapper = attachmentMapper;
    }


    @Override
    public ApiResponse<ResponseStoryTaskDto> insert(InsertStoryTaskDto storyTaskDto, String username) {
        StoryTask storyTask = storyTaskMapper.insertStoryTaskDtoToStoryTask(storyTaskDto);
        Optional<User> createdBy = userRepository.findByUsername(username);
        if (storyTaskDto.getCreatedAt() == null) {
            storyTask.setCreatedAt(LocalDateTime.now());
        }
        createdBy.ifPresent(storyTask::setCreatedBy);
        if (storyTaskDto.getAssignedToId() == null) {
            storyTask.setAssignedTo(storyTask.getCreatedBy());
        } else {
            User assignedTo = userRepository.getById(storyTask.getAssignedTo().getId());
            storyTask.setAssignedTo(assignedTo);
        }
        storyTaskRepository.save(storyTask);

        ResponseStoryTaskDto responseStoryTaskDto = storyTaskMapper.storyTaskToResponseStoryTaskDto(storyTask);
        return new ApiResponse<>(responseStoryTaskDto, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ApiResponse<FullInformationStoryTaskDto> insertStoryTaskComment(InsertStoryTaskCommentDto storyTaskCommentDto, String username) {
        Optional<User> user = userRepository.findByUsername(username);
        Comment comment = commentMapper.insertStoryTaskCommentDtoToComment(storyTaskCommentDto);
        StoryTask storyTask = storyTaskRepository.getById(storyTaskCommentDto.getStoryTaskId());

        user.ifPresent(comment::setPostedBy);
        commentRepository.save(comment);
        if (!CollectionUtils.isEmpty(storyTaskCommentDto.getCommentAttachments()) && user.isPresent()) {
            Set<Attachment> savedAttachments = new HashSet<>();
            for (MultipartFile multipartFile : storyTaskCommentDto.getCommentAttachments()) {
                commentAttachmentOperationsService.insertCommentAttachment(multipartFile, username, user.get(), comment, storyTask);
            }
            comment.setCommentAttachments(savedAttachments);
        }
        storyTask.addStoryTaskComment(comment);
        storyTaskRepository.save(storyTask);

        FullInformationStoryTaskDto fullDetailsResponseStoryDto = storyTaskMapper.storyTaskToFullInformationStoryTaskDto(storyTask);
        return new ApiResponse<>(fullDetailsResponseStoryDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<FullInformationStoryTaskDto> findStoryTaskById(Long storyTaskId) {
        Optional<StoryTask> storyTask = storyTaskRepository.findById(storyTaskId);
        if (storyTask.isPresent()) {
            HashMap<Long, AttachmentResponseDto> attachmentResponseDtos = new HashMap<>();
            storyTask.get().getStoryComments().parallelStream().forEach(comment ->
            {
                comment.getCommentAttachments().parallelStream().forEach(attachment ->
                {
                    AttachmentResponseDto attachmentResponseDto = new AttachmentResponseDto();
                    String uri = restApiBaseUri + "api/attachment/" + attachment.getId();
                    attachmentResponseDto.setId(attachment.getId());
                    attachmentResponseDto.setPostedAt(attachment.getPostedAt());
                    attachmentResponseDto.setName(attachment.getName());
                    attachmentResponseDto.setSize(attachment.getContent().length);
                    attachmentResponseDto.setContentType(attachment.getContentType());
                    attachmentResponseDto.setUrl(uri);
                    attachmentResponseDtos.put(attachment.getId(), attachmentResponseDto);
                });
            });

            FullInformationStoryTaskDto fullInformationStoryTaskDto = storyTaskMapper.storyTaskToFullInformationStoryTaskDto(storyTask.get());
            fullInformationStoryTaskDto.getStoryComments().parallelStream().forEach(commentDto -> {
                commentDto.setAttachmentResponseDto(new ArrayList<>());
                commentDto.getCommentAttachments().parallelStream().forEach(commentAttachmentDto ->
                        commentDto.getAttachmentResponseDto().add(attachmentResponseDtos.get(commentAttachmentDto.getId())));
            });
            return new ApiResponse<>(fullInformationStoryTaskDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<ResponseStoryTaskDto> update(UpdateStoryTaskDto storyTaskDto) {
        Optional<StoryTask> storyTask = storyTaskRepository.findById(storyTaskDto.getId());
        if (storyTask.isPresent()) {
            storyTask.get().setTitle(storyTaskDto.getTitle());
            storyTask.get().setStoryPoints(storyTaskDto.getStoryPoints());
            storyTask.get().setDescription(storyTaskDto.getDescription());
            storyTask.get().setStatus(storyTaskDto.getStatus());
            User assignedToUser;
            if (storyTaskDto.getAssignedToId() != 0) {
                assignedToUser = userRepository.findById(storyTaskDto.getAssignedToId()).orElseThrow(ResourceNotFoundException::new);
            } else if (!storyTaskDto.getAssignedToUsername().isEmpty()) {
                assignedToUser = userRepository.findByUsername(storyTaskDto.getAssignedToUsername()).orElseThrow(ResourceNotFoundException::new);
            } else {
                throw new UserNotFoundException("AssignedTo user not found");
            }
            storyTask.get().setAssignedTo(assignedToUser);
            storyTaskRepository.save(storyTask.get());
            ResponseStoryTaskDto responseStoryTaskDto = storyTaskMapper.storyTaskToResponseStoryTaskDto(storyTask.get());
            return new ApiResponse<>(responseStoryTaskDto, HttpStatus.OK);
        } else {
            return new ApiResponse<>("Story task not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<List<FullInformationStoryTaskDto>> findStoryTasksByCreatedBy(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            List<StoryTask> storyTaskList = storyTaskRepository.findByCreatedBy_Username(username);
            if (CollectionUtils.isEmpty(storyTaskList)) {
                return new ApiResponse<>(new ArrayList<>(), HttpStatus.OK);
            }
            List<FullInformationStoryTaskDto> fullInformationStoryTaskDtos = new ArrayList<>();

            storyTaskList.forEach(storyTask -> fullInformationStoryTaskDtos.add(storyTaskMapper.storyTaskToFullInformationStoryTaskDto(storyTask)));
            return new ApiResponse<>(fullInformationStoryTaskDtos, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Username " + username + " cannot be found in database");
        }
    }

    @Override
    public ApiResponse<List<FullInformationStoryTaskDto>> findStoryTasksByAssignedTo(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            List<StoryTask> storyTaskList = storyTaskRepository.findByAssignedTo_Username(username);
            if (CollectionUtils.isEmpty(storyTaskList)) {
                return new ApiResponse<>(new ArrayList<>(), HttpStatus.OK);
            }
            List<FullInformationStoryTaskDto> fullInformationStoryTaskDtos = new ArrayList<>();

            storyTaskList.forEach(storyTask -> fullInformationStoryTaskDtos.add(storyTaskMapper.storyTaskToFullInformationStoryTaskDto(storyTask)));
            return new ApiResponse<>(fullInformationStoryTaskDtos, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Username " + username + " cannot be found in database");
        }
    }

    @Override
    public ApiResponse<List<FullInformationStoryTaskDto>> findAllStoryTasksByStoryId(Long storyId) {
        Optional<Story> story = storyRepository.findById(storyId);
        if (story.isPresent()) {
            List<StoryTask> storyTaskList = storyTaskRepository.findByStory_Id(storyId);
            if (CollectionUtils.isEmpty(storyTaskList)) {
                return new ApiResponse<>(new ArrayList<>(), HttpStatus.OK);
            }
            List<FullInformationStoryTaskDto> fullInformationStoryTaskDtos = new ArrayList<>();

            storyTaskList.forEach(storyTask -> fullInformationStoryTaskDtos.add(storyTaskMapper.storyTaskToFullInformationStoryTaskDto(storyTask)));
            return new ApiResponse<>(fullInformationStoryTaskDtos, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("StoryId " + storyId + " cannot be found in database");
        }
    }


    @Override
    public ApiResponse<ResponseStoryTaskDto> deleteStoryTask(Long id) {
        Optional<StoryTask> storyTask = storyTaskRepository.findById(id);
        if (storyTask.isPresent()) {
            storyTaskRepository.delete(storyTask.get());
            ResponseStoryTaskDto responseStoryTaskDto = storyTaskMapper.storyTaskToResponseStoryTaskDto(storyTask.get());
            return new ApiResponse<>(responseStoryTaskDto, HttpStatus.ACCEPTED);
        } else {
            return new ApiResponse<>("Story task id not found ... ", null, HttpStatus.NOT_FOUND);
        }
    }
}
