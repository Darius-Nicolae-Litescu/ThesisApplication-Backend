package darius.licenta.backend.mapper.elasticsearch.storytask;

import darius.licenta.backend.domain.sql.StoryTask;
import darius.licenta.backend.domain.elasticsearch.ElasticSearchStoryTaskDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElasticSearchStoryTaskMapper {
    StoryTask elasticSearchStoryTaskDtoToStoryTask(ElasticSearchStoryTaskDto elasticSearchStoryTaskDto);

    ElasticSearchStoryTaskDto storyTaskToElasticSearchStoryTaskDto(StoryTask storyTask);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryTaskFromElasticSearchStoryTaskDto(ElasticSearchStoryTaskDto elasticSearchStoryTaskDto, @MappingTarget StoryTask storyTask);
}
