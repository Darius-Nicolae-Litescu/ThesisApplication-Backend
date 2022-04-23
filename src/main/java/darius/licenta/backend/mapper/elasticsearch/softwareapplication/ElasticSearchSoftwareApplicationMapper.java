package darius.licenta.backend.mapper.elasticsearch.softwareapplication;

import darius.licenta.backend.domain.elasticsearch.ElasticSearchSoftwareApplicationDto;
import darius.licenta.backend.domain.sql.SoftwareApplication;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElasticSearchSoftwareApplicationMapper {
    SoftwareApplication elasticSearchSoftwareApplicationDtoToSoftwareApplication(ElasticSearchSoftwareApplicationDto elasticSearchSoftwareApplicationDto);

    ElasticSearchSoftwareApplicationDto softwareApplicationToElasticSearchSoftwareApplicationDto(SoftwareApplication softwareApplication);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSoftwareApplicationFromElasticSearchSoftwareApplicationDto(ElasticSearchSoftwareApplicationDto elasticSearchSoftwareApplicationDto, @MappingTarget SoftwareApplication softwareApplication);
}
