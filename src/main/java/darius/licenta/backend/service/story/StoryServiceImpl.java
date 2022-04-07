package darius.licenta.backend.service.story;

import darius.licenta.backend.domain.sql.*;
import darius.licenta.backend.dto.normal.attachment.AttachmentResponseDto;
import darius.licenta.backend.dto.normal.comment.story.InsertStoryCommentDto;
import darius.licenta.backend.dto.normal.story.request.insert.InsertStoryDto;
import darius.licenta.backend.dto.normal.story.request.update.*;
import darius.licenta.backend.dto.normal.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.normal.story.response.notfulldetails.ResponseStoryDtoWithoutFullDetails;
import darius.licenta.backend.dto.normal.story.response.table.TableStoryDto;
import darius.licenta.backend.dto.normal.storytask.ChangeStoryTaskGeneralDetails;
import darius.licenta.backend.dto.normal.storytask.ChangeStoryTaskTitleAndDescription;
import darius.licenta.backend.mapper.normal.comment.CommentMapper;
import darius.licenta.backend.mapper.normal.story.StoryMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.jpa.*;
import darius.licenta.backend.service.attachment.CommentAttachmentOperationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
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
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StoryServiceImpl implements StoryService {
    Logger logger = LoggerFactory.getLogger(StoryServiceImpl.class);

    private final CommentAttachmentOperationsService commentAttachmentOperationsService;

    private final UserRepository userRepository;

    private final StoryRepository storyRepository;

    private final CategoryRepository categoryRepository;

    private final PriorityRepository priorityRepository;

    private final CommentRepository commentRepository;

    private final SoftwareApplicationRepository softwareApplicationRepository;

    private final StoryMapper storyMapper;

    private final CommentMapper commentMapper;

    @Value("${api.rest.base.uri}")
    private String restApiBaseUri;

    @Autowired
    public StoryServiceImpl(CommentAttachmentOperationsService commentAttachmentOperationsService, UserRepository userRepository, StoryRepository storyRepository, CategoryRepository categoryRepository, PriorityRepository priorityRepository, CommentRepository commentRepository, SoftwareApplicationRepository softwareApplicationRepository, StoryMapper storyMapper, CommentMapper commentMapper) {
        this.commentAttachmentOperationsService = commentAttachmentOperationsService;
        this.userRepository = userRepository;
        this.storyRepository = storyRepository;
        this.categoryRepository = categoryRepository;
        this.priorityRepository = priorityRepository;
        this.commentRepository = commentRepository;
        this.softwareApplicationRepository = softwareApplicationRepository;
        this.storyMapper = storyMapper;
        this.commentMapper = commentMapper;
    }

    @Transactional
    @Override
    public ApiResponse<FullDetailsResponseStoryDto> insert(InsertStoryDto insertStoryDto, String username) {
        Optional<User> user = userRepository.findByUsername(username);
        Story story = storyMapper.insertStoryDtoToStory(insertStoryDto);
        user.ifPresent(story::setCreatedBy);
        story = storyRepository.save(story);

        Set<Category> categories = categoryRepository.findByIdIn(insertStoryDto.getCategoryIds());
        Optional<Priority> priority = priorityRepository.findById(insertStoryDto.getPriorityId());
        Optional<SoftwareApplication> softwareApplication = softwareApplicationRepository.findById(insertStoryDto.getSoftwareApplicationId());

        if (CollectionUtils.isEmpty(categories) || !priority.isPresent() || !softwareApplication.isPresent()) {
            return new ApiResponse<>("One of the categories or the priority or software application is not found", null, HttpStatus.NOT_FOUND);
        }

        Story databaseStory = storyRepository.getById(story.getId());
        databaseStory.setCategories(categories);
        databaseStory.setPriority(priority.get());
        databaseStory.setSoftwareApplication(softwareApplication.get());
        databaseStory = storyRepository.saveAndFlush(story);

        FullDetailsResponseStoryDto responseStoryDto = storyMapper.storyToFullDetailsResponseStoryDto(databaseStory);
        return new ApiResponse<>(responseStoryDto, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ApiResponse<FullDetailsResponseStoryDto> insertStoryComment(InsertStoryCommentDto insertStoryCommentDto, String username) {
        Optional<User> user = userRepository.findByUsername(username);
        Comment comment = commentMapper.insertStoryCommentDtoToComment(insertStoryCommentDto);
        Optional<Story> story = storyRepository.findById(insertStoryCommentDto.getStoryId());
        if (!story.isPresent()) {
            return new ApiResponse<>("Story not found", null, HttpStatus.NOT_FOUND);
        }
        user.ifPresent(comment::setPostedBy);
        commentRepository.save(comment);
        if (!CollectionUtils.isEmpty(insertStoryCommentDto.getCommentAttachments()) && user.isPresent()) {
            for (MultipartFile multipartFile : insertStoryCommentDto.getCommentAttachments()) {
                commentAttachmentOperationsService.insertCommentAttachment(multipartFile, username, user.get(), comment, story.get());
            }
        }
        story.get().addStoryComment(comment);
        storyRepository.saveAndFlush(story.get());

        FullDetailsResponseStoryDto fullDetailsResponseStoryDto = populateDtoWithAttachmentInfo(story.get());
        return new ApiResponse<>(fullDetailsResponseStoryDto, HttpStatus.OK);
    }

    private FullDetailsResponseStoryDto populateDtoWithAttachmentInfo(Story story) {
        HashMap<Long, AttachmentResponseDto> attachmentResponseDtos = new HashMap<>();
        story.getComments().forEach(comment ->
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

        FullDetailsResponseStoryDto fullDetailsResponseStoryDto = storyMapper.storyToFullDetailsResponseStoryDto(story);
        fullDetailsResponseStoryDto.getComments().parallelStream().forEach(commentDto -> {
            commentDto.setAttachmentResponseDto(new ArrayList<>());
            if (!CollectionUtils.isEmpty(commentDto.getCommentAttachments())) {
                commentDto.getCommentAttachments().parallelStream().forEach(commentAttachmentDto ->
                {
                    commentDto.getAttachmentResponseDto().add(attachmentResponseDtos.get(commentAttachmentDto.getId()));
                });
            }
        });
        return fullDetailsResponseStoryDto;
    }

    @Override
    public ApiResponse<FullDetailsResponseStoryDto> findById(Long id) {
        Optional<Story> story = storyRepository.findById(id);
        if (story.isPresent()) {
            FullDetailsResponseStoryDto fullInformationStoryTaskDto = populateDtoWithAttachmentInfo(story.get());
            return new ApiResponse<>(fullInformationStoryTaskDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<FullDetailsResponseStoryDto> updateCategories(UpdateStoryCategories updateStoryCategories) {
        Optional<Story> story = storyRepository.findById(updateStoryCategories.getId());
        if (story.isPresent()) {
            List<Long> categoriesIds = updateStoryCategories.getCategories().stream().map(UpdateStoryCategories.CategoryDto::getId).collect(Collectors.toList());
            Set<Category> categories = new HashSet<>(categoryRepository.findAllById(categoriesIds));
            if (!CollectionUtils.isEmpty(categories)) {
                story.get().setCategories(categories);
                storyRepository.save(story.get());
                FullDetailsResponseStoryDto fullDetailsResponseStoryDto = storyMapper.storyToFullDetailsResponseStoryDto(story.get());
                return new ApiResponse<>(fullDetailsResponseStoryDto, HttpStatus.OK);
            } else {
                return new ApiResponse<>("Category not found", null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ApiResponse<>("Story not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<FullDetailsResponseStoryDto> updatePriority(UpdateStoryPriority updateStoryPriority) {
        Optional<Story> story = storyRepository.findById(updateStoryPriority.getId());
        if (story.isPresent()) {
            Optional<Priority> priority = priorityRepository.findById(updateStoryPriority.getPriority().getId());
            if (priority.isPresent()) {
                story.get().setPriority(priority.get());
                storyRepository.save(story.get());
                FullDetailsResponseStoryDto fullDetailsResponseStoryDto = storyMapper.storyToFullDetailsResponseStoryDto(story.get());
                return new ApiResponse<>(fullDetailsResponseStoryDto, HttpStatus.OK);
            } else {
                return new ApiResponse<>("Priority not found", null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ApiResponse<>("Story not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<FullDetailsResponseStoryDto> updateSoftwareApplication(UpdateStorySoftwareApplication updateStorySoftwareApplication) {
        Optional<Story> story = storyRepository.findById(updateStorySoftwareApplication.getId());
        if (story.isPresent()) {
            Optional<SoftwareApplication> softwareApplication = softwareApplicationRepository.findById(updateStorySoftwareApplication.getSoftwareApplication().getId());
            if (softwareApplication.isPresent()) {
                story.get().setSoftwareApplication(softwareApplication.get());
                storyRepository.save(story.get());
                FullDetailsResponseStoryDto fullDetailsResponseStoryDto = storyMapper.storyToFullDetailsResponseStoryDto(story.get());
                return new ApiResponse<>(fullDetailsResponseStoryDto, HttpStatus.OK);
            } else {
                return new ApiResponse<>("Software application not found", null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ApiResponse<>("Story not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<FullDetailsResponseStoryDto> deleteById(Long id) {
        Optional<Story> story = storyRepository.findById(id);
        if (story.isPresent()) {
            storyRepository.delete(story.get());
            FullDetailsResponseStoryDto responseStoryDto = storyMapper.storyToFullDetailsResponseStoryDto(story.get());
            return new ApiResponse<>(responseStoryDto, HttpStatus.ACCEPTED);
        } else {
            return new ApiResponse<>("Story id not found ... ", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<PaginatedResponse<ResponseStoryDtoWithoutFullDetails>> findByPriority(Long priorityId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> filteredStories = storyRepository.findByPriority_Id(priorityId, pageable);
        if (filteredStories.getNumberOfElements() == 0) {
            PaginatedResponse<ResponseStoryDtoWithoutFullDetails> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                    new ArrayList<>(), filteredStories.getTotalElements(), filteredStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<ResponseStoryDtoWithoutFullDetails> filteredStoriesDto = new ArrayList<>();

        filteredStories.getContent().forEach(story -> filteredStoriesDto.add(storyMapper.storyToResponseStoryDtoWithoutFullDetails(story)));

        PaginatedResponse<ResponseStoryDtoWithoutFullDetails> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                filteredStoriesDto, filteredStories.getTotalElements(), filteredStories.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PaginatedResponse<ResponseStoryDtoWithoutFullDetails>> findByCategory(Long categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> filteredStories = storyRepository.findByCategories_Id(categoryId, pageable);
        if (filteredStories.getNumberOfElements() == 0) {
            PaginatedResponse<ResponseStoryDtoWithoutFullDetails> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                    new ArrayList<>(), filteredStories.getTotalElements(), filteredStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<ResponseStoryDtoWithoutFullDetails> filteredStoriesDto = new ArrayList<>();

        filteredStories.getContent().forEach(story -> filteredStoriesDto.add(storyMapper.storyToResponseStoryDtoWithoutFullDetails(story)));

        PaginatedResponse<ResponseStoryDtoWithoutFullDetails> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                filteredStoriesDto, filteredStories.getTotalElements(), filteredStories.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PaginatedResponse<ResponseStoryDtoWithoutFullDetails>> findByDescription(String description, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> filteredStories = storyRepository.findByDescriptionLike(description, pageable);
        if (filteredStories.getNumberOfElements() == 0) {
            PaginatedResponse<ResponseStoryDtoWithoutFullDetails> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                    new ArrayList<>(), filteredStories.getTotalElements(), filteredStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<ResponseStoryDtoWithoutFullDetails> filteredStoriesDto = new ArrayList<>();

        filteredStories.getContent().forEach(story -> filteredStoriesDto.add(storyMapper.storyToResponseStoryDtoWithoutFullDetails(story)));

        PaginatedResponse<ResponseStoryDtoWithoutFullDetails> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                filteredStoriesDto, filteredStories.getTotalElements(), filteredStories.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PaginatedResponse<ResponseStoryDtoWithoutFullDetails>> findBySoftwareApplicationId(Long softwareApplicationId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> filteredStories = storyRepository.findBySoftwareApplication_Id(softwareApplicationId, pageable);
        if (filteredStories.getNumberOfElements() == 0) {
            PaginatedResponse<ResponseStoryDtoWithoutFullDetails> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                    new ArrayList<>(), filteredStories.getTotalElements(), filteredStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<ResponseStoryDtoWithoutFullDetails> filteredStoriesDto = new ArrayList<>();

        filteredStories.getContent().forEach(story -> filteredStoriesDto.add(storyMapper.storyToResponseStoryDtoWithoutFullDetails(story)));

        PaginatedResponse<ResponseStoryDtoWithoutFullDetails> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                filteredStoriesDto, filteredStories.getTotalElements(), filteredStories.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<ChangeStoryGeneralDetails> updateStoryGeneralDetails(ChangeStoryGeneralDetails changeStoryGeneralDetails) {
        Optional<Story> story = storyRepository.findById(changeStoryGeneralDetails.getId());
        if (story.isPresent()) {
            List<Category> categories = new ArrayList<>();
            for (Long categoryId: changeStoryGeneralDetails.getCategoryIds())
            {
                Optional<Category> category = categoryRepository.findById(categoryId);
                category.ifPresent(categories::add);
            }

            story.get().setCategories(new HashSet<>(categories));
            Priority priority = priorityRepository.findById(changeStoryGeneralDetails.getPriorityId()).orElseThrow(
                    () -> new ResourceNotFoundException("Priority not found")
            );
            story.get().setPriority(priority);

            storyRepository.save(story.get());
            ChangeStoryGeneralDetails changeStoryGeneralDetailsDto = storyMapper.storyToChangeStoryGeneralDetails(story.get());
            return new ApiResponse<>(changeStoryGeneralDetailsDto, HttpStatus.OK);
        } else {
            return new ApiResponse<>("Story not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<ChangeStoryTitleAndDescription> updateStoryTitleAndDescription(ChangeStoryTitleAndDescription changeStoryTitleAndDescription) {
        Optional<Story> story = storyRepository.findById(changeStoryTitleAndDescription.getId());
        if (story.isPresent()) {
            story.get().setTitle(changeStoryTitleAndDescription.getTitle());
            story.get().setDescription(changeStoryTitleAndDescription.getDescription());
            storyRepository.save(story.get());
            ChangeStoryTitleAndDescription changeStoryGeneralDetails = storyMapper.storyToChangeStoryTitleAndDescription(story.get());
            return new ApiResponse<>(changeStoryGeneralDetails, HttpStatus.OK);
        } else {
            return new ApiResponse<>("Story not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ApiResponse<PaginatedResponse<TableStoryDto>> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> allStories = storyRepository.findAll(pageable);
        if (allStories.getNumberOfElements() == 0) {
            PaginatedResponse<TableStoryDto> paginatedResponse = new PaginatedResponse<>(allStories.getNumber(), allStories.getSize(), allStories.getNumberOfElements(),
                    new ArrayList<>(), allStories.getTotalElements(), allStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        PaginatedResponse<TableStoryDto> paginatedResponse = null;
        try {
            List<TableStoryDto> allStoriesDto = allStories.getContent().stream()
                    .map(storyMapper::storyToTableStoryDto).collect(Collectors.toList());

            paginatedResponse = new PaginatedResponse<>(allStories.getNumber(), allStories.getSize(), allStories.getNumberOfElements(),
                    allStoriesDto, allStories.getTotalElements(), allStories.getTotalPages());
        } catch (Exception exception) {
            logger.error("Exception: {}", exception.getMessage());
        }
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<Long> countAll() {
        Long storyNumber = storyRepository.count();
        return new ApiResponse<>(storyNumber, HttpStatus.OK);
    }

}
