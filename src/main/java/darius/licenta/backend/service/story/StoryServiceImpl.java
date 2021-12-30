package darius.licenta.backend.service.story;

import darius.licenta.backend.domain.*;
import darius.licenta.backend.dto.story.*;
import darius.licenta.backend.dto.user.ResponseUserDto;
import darius.licenta.backend.exception.UserNotFoundException;
import darius.licenta.backend.mapper.story.StoryMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.CategoryRepository;
import darius.licenta.backend.persistence.PriorityRepository;
import darius.licenta.backend.persistence.SoftwareApplicationRepository;
import darius.licenta.backend.persistence.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;

    private final CategoryRepository categoryRepository;

    private final PriorityRepository priorityRepository;

    private final SoftwareApplicationRepository softwareApplicationRepository;

    private final StoryMapper storyMapper;

    @Autowired
    public StoryServiceImpl(StoryRepository storyRepository, CategoryRepository categoryRepository, PriorityRepository priorityRepository, SoftwareApplicationRepository softwareApplicationRepository, StoryMapper storyMapper) {
        this.storyRepository = storyRepository;
        this.categoryRepository = categoryRepository;
        this.priorityRepository = priorityRepository;
        this.softwareApplicationRepository = softwareApplicationRepository;
        this.storyMapper = storyMapper;
    }

    @Override
    public ApiResponse<StoryDto> insert(InsertStoryDto insertStoryDto) {
        Story story = storyMapper.insertStoryDtoToStory(insertStoryDto);

        storyRepository.save(story);

        StoryDto responseStoryDto = storyMapper.storyToStoryDto(story);
        return new ApiResponse<>(responseStoryDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<StoryDto> updateCategory(UpdateStoryCategory updateStoryCategory) {
        Optional<Story> story = storyRepository.findById(updateStoryCategory.getStoryId());
        if (story.isPresent()) {
            Optional<Category> category = categoryRepository.findById(updateStoryCategory.getCategoryId());
            if (category.isPresent()) {
                story.get().setCategory(category.get());
                storyRepository.save(story.get());
                StoryDto storyDto = storyMapper.storyToStoryDto(story.get());
                return new ApiResponse<>(storyDto, HttpStatus.OK);
            } else {
                return new ApiResponse<>("Category not found", null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ApiResponse<>("Story not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<StoryDto> updatePriority(UpdateStoryPriority updateStoryPriority) {
        Optional<Story> story = storyRepository.findById(updateStoryPriority.getStoryId());
        if (story.isPresent()) {
            Optional<Priority> priority = priorityRepository.findById(updateStoryPriority.getPriorityId());
            if (priority.isPresent()) {
                story.get().setPriority(priority.get());
                storyRepository.save(story.get());
                StoryDto storyDto = storyMapper.storyToStoryDto(story.get());
                return new ApiResponse<>(storyDto, HttpStatus.OK);
            } else {
                return new ApiResponse<>("Priority not found", null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ApiResponse<>("Story not found", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<StoryDto> updateSoftwareApplication(UpdateStorySoftwareApplication updateStorySoftwareApplication) {
        Optional<Story> story = storyRepository.findById(updateStorySoftwareApplication.getStoryId());
        if (story.isPresent()) {
            Optional<SoftwareApplication> softwareApplication = softwareApplicationRepository.findById(updateStorySoftwareApplication.getSoftwareApplicationId());
            if (softwareApplication.isPresent()) {
                story.get().setSoftwareApplication(softwareApplication.get());
                storyRepository.save(story.get());
                StoryDto storyDto = storyMapper.storyToStoryDto(story.get());
                return new ApiResponse<>(storyDto, HttpStatus.OK);
            } else {
                return new ApiResponse<>("Software application not found", null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ApiResponse<>("Story not found", null, HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ApiResponse<StoryDto> findById(Long id) {
        Story story = storyRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        StoryDto storyDto = storyMapper.storyToStoryDto(story);
        return new ApiResponse<>(storyDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PaginatedResponse<StoryDto>> findByPriority(Long priorityId, int page, int size) {
        return null;
    }

    @Override
    public ApiResponse<PaginatedResponse<StoryDto>> findByCategory(Long categoryId, int page, int size) {
        return null;
    }

    @Override
    public ApiResponse<PaginatedResponse<StoryDto>> findByDescription(String description, int page, int size) {
        return null;
    }

    @Override
    public ApiResponse<PaginatedResponse<StoryDto>> findBySoftwareApplicationId(Long softwareApplicationId, int page, int size) {
        return null;
    }

    @Override
    public ApiResponse<Integer> countAll() {
        return null;
    }

    @Override
    public ApiResponse<PaginatedResponse<StoryDto>> findAll() {
        return null;
    }


}
