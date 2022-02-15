package darius.licenta.backend.persistence.elasticsearch;

import darius.licenta.backend.domain.elasticsearch.ElasticSearchSoftwareApplicationDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SoftwareApplicationElasticSearchRepository extends ElasticsearchRepository<ElasticSearchSoftwareApplicationDto, Long> {
}