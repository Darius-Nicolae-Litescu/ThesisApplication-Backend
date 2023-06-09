package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.category.CategoryDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    @Secured(UserRole.Rank.ADMIN)
    public ApiResponse<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.insert(categoryDto);
    }

    @PutMapping("/")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.update(categoryDto);
    }

    @GetMapping("/{id}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<CategoryDto> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<List<CategoryDto>> getCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<CategoryDto> deleteCategoryById(@PathVariable Long id) {
        return categoryService.deleteById(id);
    }
}
