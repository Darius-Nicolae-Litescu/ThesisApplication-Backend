package darius.licenta.backend.service.category;

import darius.licenta.backend.dto.normal.category.CategoryDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;

public interface CategoryService {
    ApiResponse<CategoryDto> insert(CategoryDto categoryDto);

    ApiResponse<CategoryDto> update(CategoryDto categoryDto);

    ApiResponse<List<CategoryDto>> findByName(String name);

    ApiResponse<CategoryDto> findById(Long id);

    ApiResponse<List<CategoryDto>> getAllCategories();

    ApiResponse<List<CategoryDto>> deleteByName(String name);

    ApiResponse<CategoryDto> deleteById(Long id);
}
