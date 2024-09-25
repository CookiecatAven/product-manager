package ch.csbe.productmanager.resources.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository für den Zugriff auf die Produkte in der Datenbank.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
