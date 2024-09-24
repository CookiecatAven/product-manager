package ch.csbe.productmanager.resources.category;

import ch.csbe.productmanager.resources.product.Product;
import jakarta.persistence.*;
import java.util.List;

/**
 * Die Category-Klasse repräsentiert eine Kategorie in der Datenbank.
 * Eine Kategorie kann viele Produkte enthalten.
 */
@Entity
@Table(name = "categories")
public class Category {

    /**
     * Die eindeutige ID der Kategorie, die automatisch generiert wird.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Der Name der Kategorie.
     */
    private String name;

    /**
     * Die Liste von Produkten, die zu dieser Kategorie gehören.
     * Die Beziehung wird durch @OneToMany definiert, was bedeutet, dass eine Kategorie viele Produkte haben kann.
     */
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    // Getter und Setter für alle Felder

    /**
     * Gibt die ID der Kategorie zurück.
     *
     * @return Kategorie-ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Setzt die ID der Kategorie.
     *
     * @param id Kategorie-ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gibt den Namen der Kategorie zurück.
     *
     * @return Kategoriename
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen der Kategorie.
     *
     * @param name Kategoriename
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die Liste von Produkten zurück, die zu dieser Kategorie gehören.
     *
     * @return Liste der Produkte
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Setzt die Liste von Produkten, die zu dieser Kategorie gehören.
     *
     * @param products Liste der Produkte
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
