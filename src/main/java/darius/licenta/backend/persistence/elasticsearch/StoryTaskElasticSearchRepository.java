package darius.licenta.backend.persistence.elasticsearch;

import darius.licenta.backend.domain.elasticsearch.ElasticSearchStoryTaskDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StoryTaskElasticSearchRepository extends ElasticsearchRepository<ElasticSearchStoryTaskDto, Long> {
}