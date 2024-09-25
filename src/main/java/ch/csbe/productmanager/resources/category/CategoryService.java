package ch.csbe.productmanager.resources.category;

import ch.csbe.productmanager.resources.category.dto.CategoryCreateDto;
import ch.csbe.productmanager.resources.category.dto.CategoryDetailDto;
import ch.csbe.productmanager.resources.category.dto.CategoryShowDto;
import ch.csbe.productmanager.resources.category.dto.CategoryUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service für die Kategorieverwaltung.
 */
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryShowDto> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        List<CategoryShowDto> categoryShowDtos = new ArrayList<>();
        for (Category category : allCategories) {
            categoryShowDtos.add(categoryMapper.toShowDto(category));
        }
        return categoryShowDtos;
    }

    public Optional<CategoryDetailDto> getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDetailDto);
    }

    public CategoryShowDto addCategory(CategoryCreateDto createDto) {
        Category savedCategory = categoryRepository.save(categoryMapper.toEntity(createDto));
        return categoryMapper.toShowDto(savedCategory);
    }

    public CategoryShowDto updateCategory(Integer id, CategoryUpdateDto updatedCategory) {
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryMapper.update(updatedCategory, category);
                    Category savedCategory = categoryRepository.save(category);
                    return categoryMapper.toShowDto(savedCategory);
                })
                .orElseThrow(() -> new RuntimeException("Kategorie mit ID " + id + " nicht gefunden."));
    }

    public void deleteCategory(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Kategorie mit ID " + id + " nicht gefunden.");
        }
    }
}
