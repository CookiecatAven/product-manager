package ch.csbe.productmanager.resources.category;

import ch.csbe.productmanager.resources.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository für den Zugriff auf die Kategorien in der Datenbank.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
