package darius.licenta.backend.mapper.elasticsearch.storytask;

import darius.licenta.backend.domain.sql.StoryTask;
import darius.licenta.backend.domain.elasticsearch.ElasticSearchStoryTaskDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElasticSearchStoryTaskMapper {

    @Mapping(source = "createdByUsername", target = "createdBy.username")
    @Mapping(source = "assignedToUsername", target = "assignedTo.username")
    StoryTask elasticSearchStoryTaskDtoToStoryTask(ElasticSearchStoryTaskDto elasticSearchStoryTaskDto);

    @InheritInverseConfiguration(name = "elasticSearchStoryTaskDtoToStoryTask")
    ElasticSearchStoryTaskDto storyTaskToElasticSearchStoryTaskDto(StoryTask storyTask);

    @InheritConfiguration(name = "elasticSearchStoryTaskDtoToStoryTask")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryTaskFromElasticSearchStoryTaskDto(ElasticSearchStoryTaskDto elasticSearchStoryTaskDto, @MappingTarget StoryTask storyTask);
}
