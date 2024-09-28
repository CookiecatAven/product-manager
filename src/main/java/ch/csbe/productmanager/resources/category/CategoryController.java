package ch.csbe.productmanager.resources.category;

import ch.csbe.productmanager.resources.category.dto.CategoryCreateDto;
import ch.csbe.productmanager.resources.category.dto.CategoryDetailDto;
import ch.csbe.productmanager.resources.category.dto.CategoryShowDto;
import ch.csbe.productmanager.resources.category.dto.CategoryUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller zur Verwaltung der Kategorien.
 * Dokumentiert mit SpringDoc für OpenAPI/Swagger.
 */
@RestController
@RequestMapping("/categories")
@Tag(name = "CategoryController", description = "Verwaltung von Kategorien im System")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Holt alle Kategorien.
     *
     * @return Liste von CategoryShowDto
     */
    @Operation(summary = "Holt alle Kategorien", description = "Gibt eine Liste von allen im System vorhandenen Kategorien zurück.")
    @ApiResponse(responseCode = "200", description = "Erfolgreich alle Kategorien erhalten.")
    @GetMapping
    public List<CategoryShowDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    /**
     * Holt eine einzelne Kategorie basierend auf der ID.
     *
     * @param id die ID der Kategorie
     * @return die Kategorie in Form eines CategoryDetailDto
     */
    @Operation(summary = "Findet eine Kategorie nach ID", description = "Gibt eine Kategorie zurück, die der angegebenen ID entspricht.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Kategorie erfolgreich gefunden."),
            @ApiResponse(responseCode = "404", description = "Kategorie mit dieser ID nicht gefunden.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDetailDto> getCategoryById(@PathVariable Integer id) {
        Optional<CategoryDetailDto> foundCategory = categoryService.getCategoryById(id);
        return foundCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Fügt eine neue Kategorie hinzu.
     *
     * @param category die Daten für die zu erstellende Kategorie
     * @return die erstellte Kategorie in Form eines CategoryShowDto
     */
    @Operation(summary = "Erstellt eine neue Kategorie", description = "Fügt eine neue Kategorie in das System ein und gibt die erstellte Kategorie zurück.")
    @ApiResponse(responseCode = "201", description = "Kategorie erfolgreich erstellt.")
    @PostMapping
    public ResponseEntity<CategoryShowDto> addCategory(@RequestBody CategoryCreateDto category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(category));
    }

    /**
     * Aktualisiert eine bestehende Kategorie.
     *
     * @param id              die ID der Kategorie
     * @param updatedCategory die aktualisierten Daten der Kategorie
     * @return die aktualisierte Kategorie in Form eines CategoryShowDto
     */
    @Operation(summary = "Aktualisiert eine bestehende Kategorie", description = "Aktualisiert die Daten einer bestehenden Kategorie basierend auf der ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Kategorie erfolgreich aktualisiert."),
            @ApiResponse(responseCode = "404", description = "Kategorie mit dieser ID nicht gefunden.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CategoryShowDto> updateCategory(@PathVariable Integer id, @RequestBody CategoryUpdateDto updatedCategory) {
        Optional<CategoryShowDto> storedUpdatedCategory = categoryService.updateCategory(id, updatedCategory);
        return storedUpdatedCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Löscht eine Kategorie basierend auf der ID.
     *
     * @param id die ID der Kategorie, die gelöscht werden soll
     */
    @Operation(summary = "Löscht eine Kategorie", description = "Löscht eine Kategorie aus dem System basierend auf der angegebenen ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Kategorie erfolgreich gelöscht."),
            @ApiResponse(responseCode = "404", description = "Kategorie mit dieser ID nicht gefunden.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        boolean deleteResult = categoryService.deleteCategory(id);
        return deleteResult ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
