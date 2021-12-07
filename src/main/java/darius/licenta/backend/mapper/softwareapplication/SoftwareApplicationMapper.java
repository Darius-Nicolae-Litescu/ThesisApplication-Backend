package darius.licenta.backend.mapper.softwareapplication;

import darius.licenta.backend.domain.SoftwareApplication;
import darius.licenta.backend.dto.softwareapplication.SoftwareApplicationDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SoftwareApplicationMapper {
    SoftwareApplication softwareApplicationDtoToSoftwareApplication(SoftwareApplicationDto softwareApplicationDto);

    SoftwareApplicationDto softwareApplicationToSoftwareApplicationDto(SoftwareApplication softwareApplication);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSoftwareApplicationFromSoftwareApplicationDto(SoftwareApplicationDto softwareApplicationDto, @MappingTarget SoftwareApplication softwareApplication);
}
