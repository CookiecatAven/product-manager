package ch.csbe.productmanager.resources.product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository für den Zugriff auf die Produkte in der Datenbank.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
