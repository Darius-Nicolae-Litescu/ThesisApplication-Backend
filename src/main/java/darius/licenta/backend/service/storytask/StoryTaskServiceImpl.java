package darius.licenta.backend.service.storytask;

import darius.licenta.backend.domain.sql.Comment;
import darius.licenta.backend.domain.sql.Story;
import darius.licenta.backend.domain.sql.StoryTask;
import darius.licenta.backend.domain.sql.User;
import darius.licenta.backend.dto.normal.comment.storytask.InsertStoryTaskCommentDto;
import darius.licenta.backend.dto.normal.storytask.InsertStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.ResponseStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.UpdateStoryTaskDto;
import darius.licenta.backend.dto.normal.storytask.fullinformation.FullInformationStoryTaskDto;
import darius.licenta.backend.exception.UserNotFoundException;
import darius.licenta.backend.mapper.normal.comment.CommentMapper;
import darius.licenta.backend.mapper.normal.storytask.StoryTaskMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.jpa.CommentRepository;
import darius.licenta.backend.persistence.jpa.StoryRepository;
import darius.licenta.backend.persistence.jpa.StoryTaskRepository;
import darius.licenta.backend.persistence.jpa.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoryTaskServiceImpl implements StoryTaskService {

    private final StoryTaskRepository storyTaskRepository;

    private final StoryRepository storyRepository;

    private final UserRepository userRepository;

    private final CommentRepository commentRepository;

    private final StoryTaskMapper storyTaskMapper;

    private final CommentMapper commentMapper;

    public StoryTaskServiceImpl(StoryTaskRepository storyTaskRepository, StoryRepository storyRepository, UserRepository userRepository, CommentRepository commentRepository, StoryTaskMapper storyTaskMapper, CommentMapper commentMapper) {
        this.storyTaskRepository = storyTaskRepository;
        this.storyRepository = storyRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.storyTaskMapper = storyTaskMapper;
        this.commentMapper = commentMapper;
    }


    @Override
    public ApiResponse<ResponseStoryTaskDto> insert(InsertStoryTaskDto storyTaskDto) {
        StoryTask storyTask = storyTaskMapper.insertStoryTaskDtoToStoryTask(storyTaskDto);
        User createdBy = userRepository.getById(storyTask.getCreatedBy().getId());
        if (storyTaskDto.getCreatedAt() == null) {
            storyTask.setCreatedAt(LocalDateTime.now());
        }
        storyTask.setCreatedBy(createdBy);
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
    public ApiResponse<ResponseStoryTaskDto> insertStoryTaskComment(InsertStoryTaskCommentDto storyTaskCommentDto) {
        Comment comment = commentMapper.insertStoryTaskCommentDtoToComment(storyTaskCommentDto);
        commentRepository.save(comment);
        StoryTask storyTask = storyTaskRepository.getById(comment.getStoryTask().getId());
        storyTask.addStoryTaskComment(comment);
        storyTaskRepository.save(storyTask);

        ResponseStoryTaskDto fullDetailsResponseStoryDto = storyTaskMapper.storyTaskToResponseStoryTaskDto(storyTask);
        return new ApiResponse<>(fullDetailsResponseStoryDto, HttpStatus.OK);
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
    public ApiResponse<FullInformationStoryTaskDto> findStoryTaskById(Long storyTaskId) {
        Optional<StoryTask> storyTask = storyTaskRepository.findById(storyTaskId);
        if (storyTask.isPresent()) {
            FullInformationStoryTaskDto fullInformationStoryTaskDto = storyTaskMapper.storyTaskToFullInformationStoryTaskDto(storyTask.get());
            return new ApiResponse<>(fullInformationStoryTaskDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
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
