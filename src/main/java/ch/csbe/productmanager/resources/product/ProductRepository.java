package ch.csbe.productmanager.resources.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Repository für den Zugriff auf die Produkte in der Datenbank.
 */
@RepositoryRestResource(exported = false)
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
