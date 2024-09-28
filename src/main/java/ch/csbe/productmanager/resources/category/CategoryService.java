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
 * Service für die Verwaltung von Kategorien.
 * Dieser Service enthält Methoden zum Abrufen, Erstellen, Aktualisieren und Löschen von Kategorien.
 */
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    /**
     * Konstruktor zur Initialisierung des CategoryService.
     *
     * @param categoryRepository Repository zur Datenbankverwaltung von Kategorien
     * @param categoryMapper Mapper zum Konvertieren zwischen DTOs und Entitäten
     */
    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    /**
     * Ruft alle Kategorien ab und konvertiert sie in DTOs zur Anzeige.
     *
     * @return Liste von CategoryShowDto mit allen Kategorien
     */
    public List<CategoryShowDto> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        List<CategoryShowDto> categoryShowDtos = new ArrayList<>();
        for (Category category : allCategories) {
            categoryShowDtos.add(categoryMapper.toShowDto(category));
        }
        return categoryShowDtos;
    }

    /**
     * Sucht eine Kategorie anhand ihrer ID und gibt Details dazu zurück.
     *
     * @param id Die ID der gesuchten Kategorie
     * @return Optional mit CategoryDetailDto, falls die Kategorie gefunden wird
     */
    public Optional<CategoryDetailDto> getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDetailDto);
    }

    /**
     * Erstellt eine neue Kategorie basierend auf den übergebenen Daten.
     *
     * @param createDto DTO mit den Informationen für die neue Kategorie
     * @return CategoryShowDto mit den Daten der neu erstellten Kategorie
     */
    public CategoryShowDto addCategory(CategoryCreateDto createDto) {
        Category savedCategory = categoryRepository.save(categoryMapper.toEntity(createDto));
        return categoryMapper.toShowDto(savedCategory);
    }

    /**
     * Aktualisiert eine bestehende Kategorie basierend auf der ID und den aktualisierten Daten.
     *
     * @param id Die ID der zu aktualisierenden Kategorie
     * @param updatedCategory DTO mit den neuen Informationen für die Kategorie
     * @return Optional mit CategoryShowDto, falls die Kategorie erfolgreich aktualisiert wird
     */
    public Optional<CategoryShowDto> updateCategory(Integer id, CategoryUpdateDto updatedCategory) {
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryMapper.update(updatedCategory, category);
                    Category savedCategory = categoryRepository.save(category);
                    return categoryMapper.toShowDto(savedCategory);
                });
    }

    /**
     * Löscht eine Kategorie anhand ihrer ID.
     *
     * @param id Die ID der zu löschenden Kategorie
     * @return true, wenn die Kategorie erfolgreich gelöscht wurde, andernfalls false
     */
    public boolean deleteCategory(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
