package darius.licenta.backend.mapper.story;

import darius.licenta.backend.domain.Category;
import darius.licenta.backend.domain.Story;
import darius.licenta.backend.dto.story.*;
import darius.licenta.backend.dto.story.response.StoryDto;
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

    Story storyDtoToStory(StoryDto storyDto);

    StoryDto storyToStoryDto(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromStoryDto(StoryDto storyDto, @MappingTarget Story story);
}
