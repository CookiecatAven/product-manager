package ch.csbe.productmanager.resources.category;

import ch.csbe.productmanager.resources.category.dto.CategoryCreateDto;
import ch.csbe.productmanager.resources.category.dto.CategoryDetailDto;
import ch.csbe.productmanager.resources.category.dto.CategoryShowDto;
import ch.csbe.productmanager.resources.category.dto.CategoryUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller zur Verwaltung der Kategorien.
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryShowDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<CategoryDetailDto> getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public CategoryShowDto addCategory(@RequestBody CategoryCreateDto category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public CategoryShowDto updateCategory(@PathVariable Integer id, @RequestBody CategoryUpdateDto updatedCategory) {
        return categoryService.updateCategory(id, updatedCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
