package darius.licenta.backend.mapper.priority;

import darius.licenta.backend.domain.Priority;
import darius.licenta.backend.dto.priority.PriorityDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PriorityMapper {
    Priority priorityDtoToPriority(PriorityDto priorityDto);

    PriorityDto priorityToPriorityDto(Priority priority);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePriorityFromPriorityDto(PriorityDto priorityDto, @MappingTarget Priority priority);
}
