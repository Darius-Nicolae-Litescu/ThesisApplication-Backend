package darius.licenta.backend.persistence.elasticsearch;

import darius.licenta.backend.domain.elasticsearch.ElasticSearchCommentDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CommentElasticSearchRepository extends ElasticsearchRepository<ElasticSearchCommentDto, Long> {
}