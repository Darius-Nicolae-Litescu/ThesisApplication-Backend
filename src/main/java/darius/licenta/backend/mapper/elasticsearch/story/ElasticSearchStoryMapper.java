package darius.licenta.backend.mapper.elasticsearch.story;

import darius.licenta.backend.domain.elasticsearch.ElasticSearchStoryDto;
import darius.licenta.backend.domain.sql.Story;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElasticSearchStoryMapper {
    @Mapping(source = "priorityId", target = "priority.id")
    @Mapping(source = "priorityTitle", target = "priority.title")
    @Mapping(source = "priorityDescription", target = "priority.description")
    @Mapping(source = "priorityLevel", target = "priority.level")
    @Mapping(source = "priorityPriorityIcon", target = "priority.priorityIcon")
    @Mapping(source = "softwareApplicationId", target = "softwareApplication.id")
    @Mapping(source = "softwareApplicationName", target = "softwareApplication.name")
    @Mapping(source = "softwareApplicationDescription", target = "softwareApplication.description")
    @Mapping(source = "softwareApplicationModificationDate", target = "softwareApplication.modificationDate")
    Story elasticSearchStoryDtoToStory(ElasticSearchStoryDto elasticSearchStoryDto);

    @InheritInverseConfiguration(name = "elasticSearchStoryDtoToStory")
    ElasticSearchStoryDto storyToElasticSearchStoryDto(Story story);

    @InheritConfiguration(name = "elasticSearchStoryDtoToStory")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromElasticSearchStoryDto(ElasticSearchStoryDto elasticSearchStoryDto, @MappingTarget Story story);
}
