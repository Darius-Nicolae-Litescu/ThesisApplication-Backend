package darius.licenta.backend.service.story;

import darius.licenta.backend.domain.*;
import darius.licenta.backend.dto.comment.story.InsertStoryCommentDto;
import darius.licenta.backend.dto.story.request.insert.InsertStoryDto;
import darius.licenta.backend.dto.story.request.update.UpdateStoryCategories;
import darius.licenta.backend.dto.story.request.update.UpdateStoryPriority;
import darius.licenta.backend.dto.story.request.update.UpdateStorySoftwareApplication;
import darius.licenta.backend.dto.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.story.response.table.ResponseStoryDtoWithoutFullDetails;
import darius.licenta.backend.mapper.comment.CommentMapper;
import darius.licenta.backend.mapper.story.StoryMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StoryServiceImpl implements StoryService {
    Logger logger = LoggerFactory.getLogger(StoryServiceImpl.class);

    private final StoryRepository storyRepository;

    private final CategoryRepository categoryRepository;

    private final PriorityRepository priorityRepository;

    private final CommentRepository commentRepository;

    private final SoftwareApplicationRepository softwareApplicationRepository;

    private final StoryMapper storyMapper;

    private final CommentMapper commentMapper;

    @Autowired
    public StoryServiceImpl(StoryRepository storyRepository, CategoryRepository categoryRepository, PriorityRepository priorityRepository, CommentRepository commentRepository, SoftwareApplicationRepository softwareApplicationRepository, StoryMapper storyMapper, CommentMapper commentMapper) {
        this.storyRepository = storyRepository;
        this.categoryRepository = categoryRepository;
        this.priorityRepository = priorityRepository;
        this.commentRepository = commentRepository;
        this.softwareApplicationRepository = softwareApplicationRepository;
        this.storyMapper = storyMapper;
        this.commentMapper = commentMapper;
    }

    @Override
    public ApiResponse<FullDetailsResponseStoryDto> insert(InsertStoryDto insertStoryDto) {
        Story story = storyMapper.insertStoryDtoToStory(insertStoryDto);
        story = storyRepository.save(story);

        List<Long> categoriesIds = story.getCategories().stream().map(category -> category.getId()).collect(Collectors.toList());
        Set<Category> categories = categoryRepository.findByIdIn(categoriesIds);
        Optional<Priority> priority = priorityRepository.findById(story.getPriority().getId());
        if (CollectionUtils.isEmpty(categories) || !priority.isPresent()) {
            return new ApiResponse<>("One of the categories or the priority is not found", null, HttpStatus.NOT_FOUND);
        }

        Story databaseStory = storyRepository.getById(story.getId());
        databaseStory.setCategories(categories);
        databaseStory.setPriority(priority.get());
        databaseStory = storyRepository.saveAndFlush(story);

        FullDetailsResponseStoryDto responseStoryDto = storyMapper.storyToStoryDto(databaseStory);
        return new ApiResponse<>(responseStoryDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<FullDetailsResponseStoryDto> insertStoryComment(InsertStoryCommentDto insertStoryCommentDto) {
        Comment comment = commentMapper.insertStoryCommentDtoToComment(insertStoryCommentDto);
        commentRepository.save(comment);
        Story story = storyRepository.getById(comment.getStory().getId());
        story.addStoryComment(comment);
        storyRepository.save(story);

        FullDetailsResponseStoryDto fullDetailsResponseStoryDto = storyMapper.storyToStoryDto(story);
        return new ApiResponse<>(fullDetailsResponseStoryDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<FullDetailsResponseStoryDto> findById(Long id) {
        Optional<Story> story = storyRepository.findById(id);
        if (story.isPresent()) {
            FullDetailsResponseStoryDto fullDetailsResponseStoryDto = storyMapper.storyToStoryDto(story.get());
            return new ApiResponse<>(fullDetailsResponseStoryDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<FullDetailsResponseStoryDto> updateCategories(UpdateStoryCategories updateStoryCategories) {
        Optional<Story> story = storyRepository.findById(updateStoryCategories.getId());
        if (story.isPresent()) {
            List<Long> categoriesIds = updateStoryCategories.getCategories().stream().map(category -> category.getId()).collect(Collectors.toList());
            Set<Category> categories = new HashSet<>(categoryRepository.findAllById(categoriesIds));
            ;
            if (!CollectionUtils.isEmpty(categories)) {
                story.get().setCategories(categories);
                storyRepository.save(story.get());
                FullDetailsResponseStoryDto fullDetailsResponseStoryDto = storyMapper.storyToStoryDto(story.get());
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
                FullDetailsResponseStoryDto fullDetailsResponseStoryDto = storyMapper.storyToStoryDto(story.get());
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
                FullDetailsResponseStoryDto fullDetailsResponseStoryDto = storyMapper.storyToStoryDto(story.get());
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
            FullDetailsResponseStoryDto responseStoryDto = storyMapper.storyToStoryDto(story.get());
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

    @Transactional(readOnly = true)
    @Override
    public ApiResponse<PaginatedResponse<ResponseStoryDtoWithoutFullDetails>> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> allStories = storyRepository.findAll(pageable);
        if (allStories.getNumberOfElements() == 0) {
            PaginatedResponse<ResponseStoryDtoWithoutFullDetails> paginatedResponse = new PaginatedResponse<>(allStories.getNumber(), allStories.getSize(), allStories.getNumberOfElements(),
                    new ArrayList<>(), allStories.getTotalElements(), allStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        PaginatedResponse<ResponseStoryDtoWithoutFullDetails> paginatedResponse = null;
        try {
            List<ResponseStoryDtoWithoutFullDetails> allStoriesDto = allStories.getContent().stream()
                    .map(story -> storyMapper.storyToResponseStoryDtoWithoutFullDetails(story)).collect(Collectors.toList());

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
