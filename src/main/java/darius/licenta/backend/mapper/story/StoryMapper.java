package darius.licenta.backend.mapper.story;

import darius.licenta.backend.domain.Story;
import darius.licenta.backend.dto.story.InsertStoryDto;
import darius.licenta.backend.dto.story.StoryDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoryMapper {
    Story storyDtoToStory(StoryDto storyDto);

    StoryDto storyToStoryDto(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromStoryDto(StoryDto storyDto, @MappingTarget Story story);

    Story insertStoryDtoToStory(InsertStoryDto insertStoryDto);

    InsertStoryDto storyToInsertStoryDto(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromInsertStoryDto(InsertStoryDto insertStoryDto, @MappingTarget Story story);
}
