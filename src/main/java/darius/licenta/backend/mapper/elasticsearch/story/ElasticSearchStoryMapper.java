package darius.licenta.backend.mapper.elasticsearch.story;

import darius.licenta.backend.domain.sql.Story;
import darius.licenta.backend.domain.elasticsearch.ElasticSearchStoryDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElasticSearchStoryMapper {
    Story elasticSearchStoryDtoToStory(ElasticSearchStoryDto elasticSearchStoryDto);

    ElasticSearchStoryDto storyToElasticSearchStoryDto(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryFromElasticSearchStoryDto(ElasticSearchStoryDto elasticSearchStoryDto, @MappingTarget Story story);
}
