package darius.licenta.backend.mapper.priority;

import darius.licenta.backend.domain.Category;
import darius.licenta.backend.domain.Priority;
import darius.licenta.backend.dto.priority.InsertPriorityDto;
import darius.licenta.backend.dto.priority.PriorityDto;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PriorityMapper {
    Priority priorityDtoToPriority(PriorityDto priorityDto);

    PriorityDto priorityToPriorityDto(Priority priority);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePriorityFromPriorityDto(PriorityDto priorityDto, @MappingTarget Priority priority);

    Priority insertPriorityDtoToPriority(InsertPriorityDto insertPriorityDto);

    InsertPriorityDto priorityToInsertPriorityDto(Priority priority);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePriorityFromInsertPriorityDto(InsertPriorityDto insertPriorityDto, @MappingTarget Priority priority);

    default Set<Long> categoriesToCategoryIds(Set<Category> categories) {
        return categories.stream().map(Category::getId).collect(Collectors.toSet());
    }
}
