package darius.licenta.backend.service.story;

import darius.licenta.backend.domain.Category;
import darius.licenta.backend.domain.Priority;
import darius.licenta.backend.domain.Story;
import darius.licenta.backend.dto.story.InsertStoryDto;
import darius.licenta.backend.dto.story.UpdateStoryCategory;
import darius.licenta.backend.dto.story.UpdateStoryPriority;
import darius.licenta.backend.dto.story.UpdateStorySoftwareApplication;
import darius.licenta.backend.dto.story.response.StoryDto;
import darius.licenta.backend.mapper.story.StoryMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.CategoryRepository;
import darius.licenta.backend.persistence.PriorityRepository;
import darius.licenta.backend.persistence.SoftwareApplicationRepository;
import darius.licenta.backend.persistence.StoryRepository;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StoryServiceImpl implements StoryService {
    Logger logger = LoggerFactory.getLogger(StoryServiceImpl.class);

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

        StoryDto responseStoryDto = storyMapper.storyToStoryDto(databaseStory);
        return new ApiResponse<>(responseStoryDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<StoryDto> updateCategory(UpdateStoryCategory updateStoryCategory) {
        return null;
    }

    @Override
    public ApiResponse<StoryDto> updatePriority(UpdateStoryPriority updateStoryPriority) {
        return null;
    }

    @Override
    public ApiResponse<StoryDto> updateSoftwareApplication(UpdateStorySoftwareApplication updateStorySoftwareApplication) {
        return null;
    }

    @Override
    public ApiResponse<StoryDto> findById(Long id) {
        Optional<Story> story = storyRepository.findById(id);
        if (story.isPresent()) {
            StoryDto storyDto = storyMapper.storyToStoryDto(story.get());
            return new ApiResponse<>(storyDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<StoryDto> deleteById(Long id) {
        return null;
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

    /*
    @Override
    public ApiResponse<StoryDto> updateCategory(UpdateStoryCategory updateStoryCategory) {
        Optional<Story> story = storyRepository.findById(updateStoryCategory.getCategories());
        if (story.isPresent()) {
            Optional<Category> category = categoryRepository
                    .findAllById(updateStoryCategory.getCategories().stream().collect(category => category.get().getId()));
            if (category.isPresent()) {
                story.get().setCategories(new HashSet<Category>() {

                    {
                        add(category.get());
                    }
                });
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
                story.get().setPriority(new HashSet<Priority>() {

                    {
                        add(priority.get());
                    }
                });
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
    public ApiResponse<StoryDto> deleteById(Long id) {
        Optional<Story> story = storyRepository.findById(id);
        if (story.isPresent()) {
            storyRepository.delete(story.get());
            StoryDto responseStoryDto = storyMapper.storyToStoryDto(story.get());
            return new ApiResponse<>(responseStoryDto, HttpStatus.ACCEPTED);
        } else {
            return new ApiResponse<>("Story id not found ... ", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<PaginatedResponse<StoryDto>> findByPriority(Long priorityId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> filteredStories = storyRepository.findByPriority_Id(priorityId, pageable);
        if (filteredStories.getNumberOfElements() == 0) {
            PaginatedResponse<StoryDto> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                    new ArrayList<>(), filteredStories.getTotalElements(), filteredStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<StoryDto> filteredStoriesDto = new ArrayList<>();

        filteredStories.getContent().forEach(story -> filteredStoriesDto.add(storyMapper.storyToStoryDto(story)));

        PaginatedResponse<StoryDto> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                filteredStoriesDto, filteredStories.getTotalElements(), filteredStories.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PaginatedResponse<StoryDto>> findByCategory(Long categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> filteredStories = storyRepository.findByCategory_Id(categoryId, pageable);
        if (filteredStories.getNumberOfElements() == 0) {
            PaginatedResponse<StoryDto> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                    new ArrayList<>(), filteredStories.getTotalElements(), filteredStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<StoryDto> filteredStoriesDto = new ArrayList<>();

        filteredStories.getContent().forEach(story -> filteredStoriesDto.add(storyMapper.storyToStoryDto(story)));

        PaginatedResponse<StoryDto> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                filteredStoriesDto, filteredStories.getTotalElements(), filteredStories.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PaginatedResponse<StoryDto>> findByDescription(String description, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> filteredStories = storyRepository.findByDescriptionLike(description, pageable);
        if (filteredStories.getNumberOfElements() == 0) {
            PaginatedResponse<StoryDto> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                    new ArrayList<>(), filteredStories.getTotalElements(), filteredStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<StoryDto> filteredStoriesDto = new ArrayList<>();

        filteredStories.getContent().forEach(story -> filteredStoriesDto.add(storyMapper.storyToStoryDto(story)));

        PaginatedResponse<StoryDto> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                filteredStoriesDto, filteredStories.getTotalElements(), filteredStories.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PaginatedResponse<StoryDto>> findBySoftwareApplicationId(Long softwareApplicationId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> filteredStories = storyRepository.findBySoftwareApplication_Id(softwareApplicationId, pageable);
        if (filteredStories.getNumberOfElements() == 0) {
            PaginatedResponse<StoryDto> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                    new ArrayList<>(), filteredStories.getTotalElements(), filteredStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<StoryDto> filteredStoriesDto = new ArrayList<>();

        filteredStories.getContent().forEach(story -> filteredStoriesDto.add(storyMapper.storyToStoryDto(story)));

        PaginatedResponse<StoryDto> paginatedResponse = new PaginatedResponse<>(filteredStories.getNumber(), filteredStories.getSize(), filteredStories.getNumberOfElements(),
                filteredStoriesDto, filteredStories.getTotalElements(), filteredStories.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }
    */
    @Transactional(readOnly = true)
    @Override
    public ApiResponse<PaginatedResponse<StoryDto>> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Story> allStories = storyRepository.findAll(pageable);
        if (allStories.getNumberOfElements() == 0) {
            PaginatedResponse<StoryDto> paginatedResponse = new PaginatedResponse<>(allStories.getNumber(), allStories.getSize(), allStories.getNumberOfElements(),
                    new ArrayList<>(), allStories.getTotalElements(), allStories.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        PaginatedResponse<StoryDto> paginatedResponse = null;
        try {
            List<StoryDto> allStoriesDto = allStories.getContent().stream()
                    .map(story -> storyMapper.storyToStoryDto(story)).collect(Collectors.toList());

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
