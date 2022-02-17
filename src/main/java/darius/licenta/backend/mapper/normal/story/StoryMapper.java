package darius.licenta.backend.mapper.normal.story;

import darius.licenta.backend.domain.sql.Category;
import darius.licenta.backend.domain.sql.Story;
import darius.licenta.backend.dto.normal.story.response.fulldetails.FullDetailsResponseStoryDto;
import darius.licenta.backend.dto.normal.story.response.table.ResponseStoryDtoWithoutFullDetails;
import darius.licenta.backend.dto.normal.story.request.update.UpdateStoryCategories;
import darius.licenta.backend.dto.normal.story.request.update.UpdateStoryPriority;
import darius.licenta.backend.dto.normal.story.request.update.UpdateStorySoftwareApplication;
import darius.licenta.backend.dto.normal.story.request.insert.InsertStoryDto;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoryMapper {
    Story insertStoryDtoToStory(InsertStoryDto insertStoryDto);

    InsertStoryDto storyToInsertStoryDto(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromInsertStoryDto(InsertStoryDto insertStoryDto, @MappingTarget Story story);

    default Set<Long> categoriesToCategoryIds(Set<Category> categories) {
        return categories.stream().map(Category::getId).collect(Collectors.toSet());
    }

    Story storyDtoToStory(FullDetailsResponseStoryDto fullDetailsResponseStoryDto);

    FullDetailsResponseStoryDto storyToStoryDto(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromStoryDto(FullDetailsResponseStoryDto fullDetailsResponseStoryDto, @MappingTarget Story story);

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
}
