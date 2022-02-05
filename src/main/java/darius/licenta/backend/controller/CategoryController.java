package darius.licenta.backend.controller;

import darius.licenta.backend.domain.UserRole;
import darius.licenta.backend.dto.category.CategoryDto;
import darius.licenta.backend.dto.softwareapplication.InsertSoftwareApplicationDto;
import darius.licenta.backend.dto.softwareapplication.SoftwareApplicationDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.category.CategoryService;
import darius.licenta.backend.service.softwareapplication.SoftwareApplicationService;
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

    @GetMapping("/")
    @Secured({UserRole.Rank.ADMIN})
    public ApiResponse<List<CategoryDto>> getCategories() {
        return categoryService.getAllCategories();
    }
}