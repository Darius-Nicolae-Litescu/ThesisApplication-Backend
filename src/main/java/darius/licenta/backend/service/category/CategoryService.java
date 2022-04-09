package darius.licenta.backend.service.category;

import darius.licenta.backend.dto.normal.category.CategoryDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;

public interface CategoryService {
    ApiResponse<CategoryDto> insert(CategoryDto categoryDto);

    ApiResponse<CategoryDto> update(CategoryDto categoryDto);

    ApiResponse<CategoryDto> getCategoryById(Long id);

    ApiResponse<CategoryDto> deleteById(Long id);

    ApiResponse<List<CategoryDto>> getAllCategories();

    ApiResponse<List<CategoryDto>> findByName(String name);

    ApiResponse<List<CategoryDto>> deleteByName(String name);

}
