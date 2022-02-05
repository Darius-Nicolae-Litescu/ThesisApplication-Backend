package darius.licenta.backend.mapper.story;

import darius.licenta.backend.domain.Category;
import darius.licenta.backend.domain.Story;
import darius.licenta.backend.dto.story.*;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoryMapper {


    @Mapping(source = "priorityId", target = "priority.id")
    @Mapping(source = "priorityTitle", target = "priority.title")
    @Mapping(source = "priorityDescription", target = "priority.description")
    @Mapping(source = "priorityLevel", target = "priority.level")
    @Mapping(source = "priorityPriorityIcon", target = "priority.priorityIcon")
    @Mapping(source = "softwareApplicationId", target = "softwareApplication.id")
    @Mapping(source = "softwareApplicationName", target = "softwareApplication.name")
    @Mapping(source = "softwareApplicationDescription", target = "softwareApplication.description")
    Story storyDtoToStory(StoryDto storyDto);

    @InheritInverseConfiguration(name = "storyDtoToStory")
    StoryDto storyToStoryDto(Story story);

    @InheritConfiguration(name = "storyDtoToStory")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromStoryDto(StoryDto storyDto, @MappingTarget Story story);

    Story insertStoryDtoToStory(InsertStoryDto insertStoryDto);

    InsertStoryDto storyToInsertStoryDto(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromInsertStoryDto(InsertStoryDto insertStoryDto, @MappingTarget Story story);

    default Set<Long> categoriesToCategoryIds(Set<Category> categories) {
        return categories.stream().map(Category::getId).collect(Collectors.toSet());
    }
}
