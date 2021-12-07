package darius.licenta.backend.mapper.category;

import darius.licenta.backend.domain.Category;
import darius.licenta.backend.dto.category.CategoryDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper {
    Category categoryDtoToCategory(CategoryDto categoryDto);

    CategoryDto categoryToCategoryDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryFromCategoryDto(CategoryDto categoryDto, @MappingTarget Category category);
}
