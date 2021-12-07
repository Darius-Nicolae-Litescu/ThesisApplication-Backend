package darius.licenta.backend.mapper.storytask;

import darius.licenta.backend.domain.StoryTask;
import darius.licenta.backend.dto.storytask.StoryTaskDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoryTaskMapper {
    StoryTask storyTaskDtoToStoryTask(StoryTaskDto storyTaskDto);

    StoryTaskDto storyTaskToStoryTaskDto(StoryTask storyTask);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryTaskFromStoryTaskDto(StoryTaskDto storyTaskDto, @MappingTarget StoryTask storyTask);
}
