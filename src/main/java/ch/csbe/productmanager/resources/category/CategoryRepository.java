package ch.csbe.productmanager.resources.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Repository für den Zugriff auf die Kategorien in der Datenbank.
 */
@RepositoryRestResource(exported = false)
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
