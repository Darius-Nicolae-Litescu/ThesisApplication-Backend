package darius.licenta.backend.mapper.normal.story;

import darius.licenta.backend.domain.sql.Category;
import darius.licenta.backend.domain.sql.Story;
import darius.licenta.backend.domain.sql.StoryTask;
import darius.licenta.backend.dto.normal.story.request.update.*;
import darius.licenta.backend.dto.normal.story.request.insert.InsertStoryDto;
import darius.licenta.backend.dto.normal.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.normal.story.response.partialdetails.ResponseStoryDtoWithoutFullDetails;
import darius.licenta.backend.dto.normal.story.response.table.TableStoryDto;
import darius.licenta.backend.dto.normal.user.UserStoryActivityDto;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoryMapper {
    default Set<Long> categoriesToCategoryIds(Set<Category> categories) {
        return categories.stream().map(Category::getId).collect(Collectors.toSet());
    }

    Story updateStoryCategoriesToStory(UpdateStoryCategories updateStoryCategories);

    UpdateStoryCategories storyToUpdateStoryCategories(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromUpdateStoryCategories(UpdateStoryCategories updateStoryCategories, @MappingTarget Story story);

    Story updateStoryPriorityToStory(UpdateStoryPriority updateStoryPriority);

    UpdateStoryPriority storyToUpdateStoryPriority(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromUpdateStoryPriority(UpdateStoryPriority updateStoryPriority, @MappingTarget Story story);

    Story updateStorySoftwareApplicationToStory(UpdateStorySoftwareApplication updateStorySoftwareApplication);

    UpdateStorySoftwareApplication storyToUpdateStorySoftwareApplication(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromUpdateStorySoftwareApplication(UpdateStorySoftwareApplication updateStorySoftwareApplication, @MappingTarget Story story);

    Story fullDetailsResponseStoryDtoToStory(FullDetailsResponseStoryDto fullDetailsResponseStoryDto);

    @Mapping(target = "totalStoryPoints", source = "totalStoryPoints")
    FullDetailsResponseStoryDto storyToFullDetailsResponseStoryDto(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromFullDetailsResponseStoryDto(FullDetailsResponseStoryDto fullDetailsResponseStoryDto, @MappingTarget Story story);

    @Mapping(source = "priorityId", target = "priority.id")
    @Mapping(source = "softwareApplicationId", target = "softwareApplication.id")
    Story insertStoryDtoToStory(InsertStoryDto insertStoryDto);

    @InheritInverseConfiguration(name = "insertStoryDtoToStory")
    @Mapping(target = "categoryIds", expression = "java(categoriesToCategoryIds(story.getCategories()))")
    InsertStoryDto storyToInsertStoryDto(Story story);

    @InheritConfiguration(name = "insertStoryDtoToStory")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromInsertStoryDto(InsertStoryDto insertStoryDto, @MappingTarget Story story);

    default Set<Long> categoriesToCategoryIds1(Set<Category> categories) {
        return categories.stream().map(Category::getId).collect(Collectors.toSet());
    }

    Story userStoryActivityDtoToStory(UserStoryActivityDto userStoryActivityDto);

    UserStoryActivityDto storyToUserStoryActivityDto(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromUserStoryActivityDto(UserStoryActivityDto userStoryActivityDto, @MappingTarget Story story);


    @Mapping(source = "createdById", target = "createdBy.id")
    @Mapping(source = "priorityId", target = "priority.id")
    @Mapping(source = "softwareApplicationId", target = "softwareApplication.id")
    Story tableStoryDtoToStory(TableStoryDto tableStoryDto);

    @InheritInverseConfiguration(name = "tableStoryDtoToStory")
    @Mapping(target = "categoryIds", expression = "java(categoriesToCategoryIds(story.getCategories()))")
    @Mapping(target = "storySubtaskIds", expression = "java(storySubtasksToStorySubtaskIds(story.getStorySubtasks()))")
    TableStoryDto storyToTableStoryDto(Story story);

    @InheritConfiguration(name = "tableStoryDtoToStory")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromTableStoryDto(TableStoryDto tableStoryDto, @MappingTarget Story story);

    default Set<Long> categoriesToCategoryIds2(Set<Category> categories) {
        return categories.stream().map(Category::getId).collect(Collectors.toSet());
    }

    default Set<Long> storySubtasksToStorySubtaskIds(Set<StoryTask> storySubtasks) {
        return storySubtasks.stream().map(StoryTask::getId).collect(Collectors.toSet());
    }

    @Mapping(source = "createdById", target = "createdBy.id")
    @Mapping(source = "createdByUsername", target = "createdBy.username")
    @Mapping(source = "createdByEmail", target = "createdBy.email")
    @Mapping(source = "priorityId", target = "priority.id")
    @Mapping(source = "priorityTitle", target = "priority.title")
    @Mapping(source = "priorityDescription", target = "priority.description")
    @Mapping(source = "priorityLevel", target = "priority.level")
    Story responseStoryDtoWithoutFullDetailsToStory(ResponseStoryDtoWithoutFullDetails responseStoryDtoWithoutFullDetails);

    @InheritInverseConfiguration(name = "responseStoryDtoWithoutFullDetailsToStory")
    ResponseStoryDtoWithoutFullDetails storyToResponseStoryDtoWithoutFullDetails(Story story);

    @InheritConfiguration(name = "responseStoryDtoWithoutFullDetailsToStory")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromResponseStoryDtoWithoutFullDetails(ResponseStoryDtoWithoutFullDetails responseStoryDtoWithoutFullDetails, @MappingTarget Story story);

    Story changeStoryTitleAndDescriptionToStory(ChangeStoryTitleAndDescription changeStoryTitleAndDescription);

    ChangeStoryTitleAndDescription storyToChangeStoryTitleAndDescription(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromChangeStoryTitleAndDescription(ChangeStoryTitleAndDescription changeStoryTitleAndDescription, @MappingTarget Story story);


    @Mapping(source = "priorityId", target = "priority.id")
    Story changeStoryGeneralDetailsToStory(ChangeStoryGeneralDetails changeStoryGeneralDetails);

    @Mapping(source = "priority.id", target = "priorityId")
    @Mapping(target = "categoryIds", expression = "java(categoriesToCategoryIds(story.getCategories()))")
    ChangeStoryGeneralDetails storyToChangeStoryGeneralDetails(Story story);

    @Mapping(source = "priorityId", target = "priority.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromChangeStoryGeneralDetails(ChangeStoryGeneralDetails changeStoryGeneralDetails, @MappingTarget Story story);

    default Set<Long> categoriesToCategoryIds3(Set<Category> categories) {
        return categories.stream().map(Category::getId).collect(Collectors.toSet());
    }
}
