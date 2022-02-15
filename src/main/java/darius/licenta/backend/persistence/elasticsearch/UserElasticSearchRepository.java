package darius.licenta.backend.persistence.elasticsearch;

import darius.licenta.backend.domain.elasticsearch.ElasticSearchUserDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserElasticSearchRepository extends ElasticsearchRepository<ElasticSearchUserDto, Long> {

}