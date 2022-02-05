package darius.licenta.backend.service.category;

import darius.licenta.backend.domain.Category;
import darius.licenta.backend.dto.category.CategoryDto;
import darius.licenta.backend.mapper.category.CategoryMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ApiResponse<CategoryDto> insert(CategoryDto categoryDto) {
        Category category = categoryMapper.categoryDtoToCategory(categoryDto);

        categoryRepository.save(category);

        CategoryDto categoryDtoResponse = categoryMapper.categoryToCategoryDto(category);
        return new ApiResponse<>(categoryDtoResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<CategoryDto> update(CategoryDto categoryDto) {
        Optional<Category> category = categoryRepository.findById(categoryDto.getId());
        if (category.isPresent()) {
            category.get().setCategoryName(categoryDto.getCategoryName());

            categoryRepository.save(category.get());
            CategoryDto categoryDtoResponse = categoryMapper.categoryToCategoryDto(category.get());
            return new ApiResponse<>(categoryDtoResponse, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<List<CategoryDto>> findByName(String name) {
        List<Category> categories = categoryRepository.findByCategoryNameLike(name);
        if (!CollectionUtils.isEmpty(categories)) {
            List<CategoryDto> categoryDtos = categories.stream()
                    .map(categoryMapper::categoryToCategoryDto)
                    .collect(Collectors.toList());
            return new ApiResponse<>(categoryDtos, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<CategoryDto> findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            CategoryDto categoryDto = categoryMapper.categoryToCategoryDto(category.get());
            return new ApiResponse<>(categoryDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<List<CategoryDto>> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (!CollectionUtils.isEmpty(categories)) {
            List<CategoryDto> categoryDtos = categories.stream()
                    .map(categoryMapper::categoryToCategoryDto)
                    .collect(Collectors.toList());
            return new ApiResponse<>(categoryDtos, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<List<CategoryDto>> deleteByName(String name) {
        List<Category> categories = categoryRepository.findByCategoryNameLike(name);
        if (!CollectionUtils.isEmpty(categories)) {
            categoryRepository.deleteAll(categories);
            List<CategoryDto> categoryDtos = categories.stream()
                    .map(categoryMapper::categoryToCategoryDto)
                    .collect(Collectors.toList());
            return new ApiResponse<>(categoryDtos, HttpStatus.ACCEPTED);
        } else {
            return new ApiResponse<>("Could not find any category with name like: " + name, null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<CategoryDto> deleteById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.delete(category.get());
            CategoryDto categoryDto = categoryMapper.categoryToCategoryDto(category.get());
            return new ApiResponse<>(categoryDto, HttpStatus.OK);
        } else {
            return new ApiResponse<>("Could not find any category with id " + id, null, HttpStatus.NOT_FOUND);
        }
    }
}
