package darius.licenta.backend.service.storytask;

import darius.licenta.backend.domain.sql.Comment;
import darius.licenta.backend.domain.sql.Story;
import darius.licenta.backend.domain.sql.StoryTask;
import darius.licenta.backend.domain.sql.User;
import darius.licenta.backend.dto.normal.attachment.AttachmentResponseDto;
import darius.licenta.backend.dto.normal.comment.storytask.InsertStoryTaskCommentDto;
import darius.licenta.backend.dto.normal.storytask.*;
import darius.licenta.backend.dto.normal.storytask.fullinformation.FullInformationStoryTaskDto;
import darius.licenta.backend.exception.UserNotFoundException;
import darius.licenta.backend.mapper.normal.attachment.AttachmentMapper;
import darius.licenta.backend.mapper.normal.comment.CommentMapper;
import darius.licenta.backend.mapper.normal.storytask.StoryTaskMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.jpa.*;
import darius.licenta.backend.service.attachment.CommentAttachmentOperationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoryTaskServiceImpl implements StoryTaskService {
    Logger logger = LoggerFactory.getLogger(StoryTaskServiceImpl.class);


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

    private FullInformationStoryTaskDto populateDtoWithAttachmentInfo(StoryTask storyTask) {
        HashMap<Long, AttachmentResponseDto> attachmentResponseDtos = new HashMap<>();
        storyTask.getStoryComments().forEach(comment ->
        {
            if (!CollectionUtils.isEmpty(comment.getCommentAttachments()))
                comment.getCommentAttachments().forEach(attachment ->
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

        FullInformationStoryTaskDto fullInformationStoryTaskDto = storyTaskMapper.storyTaskToFullInformationStoryTaskDto(storyTask);
        fullInformationStoryTaskDto.getStoryComments().parallelStream().forEach(commentDto -> {
            commentDto.setAttachmentResponseDto(new ArrayList<>());
            if (!CollectionUtils.isEmpty(commentDto.getCommentAttachments())) {
                commentDto.getCommentAttachments().parallelStream().forEach(commentAttachmentDto ->
                {
                    commentDto.getAttachmentResponseDto().add(attachmentResponseDtos.get(commentAttachmentDto.getId()));
                });
            }
        });

        return fullInformationStoryTaskDto;
    }

    @Override
    @Transactional
    public ApiResponse<FullInformationStoryTaskDto> insertStoryTaskComment(InsertStoryTaskCommentDto storyTaskCommentDto, String username) {
        Optional<User> user = userRepository.findByUsername(username);
        Comment commentToBeInserted = commentMapper.insertStoryTaskCommentDtoToComment(storyTaskCommentDto);
        Optional<StoryTask> storyTask = storyTaskRepository.findById(storyTaskCommentDto.getStoryTaskId());
        if (!storyTask.isPresent()) {
            return new ApiResponse<>("Story task not found", null, HttpStatus.NOT_FOUND);
        }
        user.ifPresent(commentToBeInserted::setPostedBy);
        commentRepository.save(commentToBeInserted);
        if (!CollectionUtils.isEmpty(storyTaskCommentDto.getCommentAttachments()) && user.isPresent()) {
            for (MultipartFile multipartFile : storyTaskCommentDto.getCommentAttachments()) {
                commentAttachmentOperationsService.insertCommentAttachment(multipartFile, username, user.get(), commentToBeInserted, storyTask.get());
            }
        }
        storyTask.get().addStoryTaskComment(commentToBeInserted);
        storyTaskRepository.saveAndFlush(storyTask.get());

        FullInformationStoryTaskDto fullInformationStoryTaskDto = populateDtoWithAttachmentInfo(storyTask.get());

        return new ApiResponse<>(fullInformationStoryTaskDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<ChangeStoryTaskGeneralDetails> updateStoryTaskGeneralDetails(ChangeStoryTaskGeneralDetails changeStoryTaskGeneralDetails) {
        Optional<StoryTask> storyTask = storyTaskRepository.findById(changeStoryTaskGeneralDetails.getId());
        if (storyTask.isPresent()) {
            Optional<User> assignedToUser = userRepository.findByUsername(changeStoryTaskGeneralDetails.getAssignedToUsername());
            if (assignedToUser.isPresent()) {
                storyTask.get().setAssignedTo(assignedToUser.get());
            } else {
                return new ApiResponse<>("Provided user is not found", null, HttpStatus.NOT_FOUND);
            }
            storyTask.get().setStoryPoints(changeStoryTaskGeneralDetails.getStoryPoints());
            storyTask.get().setStatus(changeStoryTaskGeneralDetails.getStatus());
            if (changeStoryTaskGeneralDetails.getFinishedAt() != null) {
                storyTask.get().setFinishedAt(LocalDateTime.now());
            } else {
                storyTask.get().setFinishedAt(null);
            }
            storyTaskRepository.save(storyTask.get());
            ChangeStoryTaskGeneralDetails changeStoryTaskGeneralDetails1 = storyTaskMapper.storyTaskToChangeStoryTaskGeneralDetails(storyTask.get());
            return new ApiResponse<>(changeStoryTaskGeneralDetails1, HttpStatus.OK);
        } else {
            return new ApiResponse<>("Story task not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<ChangeStoryTaskTitleAndDescription> updateStoryTaskTitleAndDescription(ChangeStoryTaskTitleAndDescription changeStoryTaskTitleAndDescription) {
        Optional<StoryTask> storyTask = storyTaskRepository.findById(changeStoryTaskTitleAndDescription.getId());
        if (storyTask.isPresent()) {
            storyTask.get().setTitle(changeStoryTaskTitleAndDescription.getTitle());
            storyTask.get().setDescription(changeStoryTaskTitleAndDescription.getDescription());
            storyTaskRepository.save(storyTask.get());
            ChangeStoryTaskTitleAndDescription changeStoryTaskGeneralDetails = storyTaskMapper.storyTaskToChangeStoryTaskTitleAndDescription(storyTask.get());
            return new ApiResponse<>(changeStoryTaskGeneralDetails, HttpStatus.OK);
        } else {
            return new ApiResponse<>("Story task not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<FullInformationStoryTaskDto> findStoryTaskById(Long storyTaskId) {
        Optional<StoryTask> storyTask = storyTaskRepository.findById(storyTaskId);
        if (storyTask.isPresent()) {
            FullInformationStoryTaskDto fullInformationStoryTaskDto = populateDtoWithAttachmentInfo(storyTask.get());
            return new ApiResponse<>(fullInformationStoryTaskDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Transactional(readOnly = true)
    @Override
    public ApiResponse<PaginatedResponse<ResponseStoryTaskDto>> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<StoryTask> allStoryTasks = storyTaskRepository.findAll(pageable);
        if (allStoryTasks.getNumberOfElements() == 0) {
            PaginatedResponse<ResponseStoryTaskDto> paginatedResponse = new PaginatedResponse<>(allStoryTasks.getNumber(), allStoryTasks.getSize(), allStoryTasks.getNumberOfElements(),
                    new ArrayList<>(), allStoryTasks.getTotalElements(), allStoryTasks.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        PaginatedResponse<ResponseStoryTaskDto> paginatedResponse = null;
        try {
            List<ResponseStoryTaskDto> allStoriesDto = allStoryTasks.getContent().stream()
                    .map(storyTaskMapper::storyTaskToResponseStoryTaskDto).collect(Collectors.toList());

            paginatedResponse = new PaginatedResponse<>(allStoryTasks.getNumber(), allStoryTasks.getSize(), allStoryTasks.getNumberOfElements(),
                    allStoriesDto, allStoryTasks.getTotalElements(), allStoryTasks.getTotalPages());
        } catch (Exception exception) {
            logger.error("Exception: {}", exception.getMessage());
        }
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
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
