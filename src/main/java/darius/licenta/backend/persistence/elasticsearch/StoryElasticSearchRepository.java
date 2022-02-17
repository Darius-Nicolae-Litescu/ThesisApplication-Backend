package darius.licenta.backend.persistence.elasticsearch;

import darius.licenta.backend.domain.elasticsearch.ElasticSearchStoryDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StoryElasticSearchRepository extends ElasticsearchRepository<ElasticSearchStoryDto, Long> {
}