package darius.licenta.backend.mapper.normal.story;

import darius.licenta.backend.domain.sql.Category;
import darius.licenta.backend.domain.sql.Story;
import darius.licenta.backend.dto.normal.story.request.insert.InsertStoryDto;
import darius.licenta.backend.dto.normal.story.request.update.UpdateStoryCategories;
import darius.licenta.backend.dto.normal.story.request.update.UpdateStoryPriority;
import darius.licenta.backend.dto.normal.story.request.update.UpdateStorySoftwareApplication;
import darius.licenta.backend.dto.normal.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.normal.story.response.table.ResponseStoryDtoWithoutFullDetails;
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

    Story responseStoryDtoForTableToStory(ResponseStoryDtoWithoutFullDetails responseStoryDtoWithoutFullDetails);

    ResponseStoryDtoWithoutFullDetails storyToResponseStoryDtoWithoutFullDetails(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateResponseStoryDtoWithoutFullDetails(ResponseStoryDtoWithoutFullDetails responseStoryDtoWithoutFullDetails, @MappingTarget Story story);

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
}
