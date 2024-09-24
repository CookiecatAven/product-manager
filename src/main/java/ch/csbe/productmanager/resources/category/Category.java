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
    @Column(columnDefinition = "INT")
    private Integer id;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean active;

    /**
     * Der Name der Kategorie.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Die Liste von Produkten, die zu dieser Kategorie gehören.
     * Die Beziehung wird durch @OneToMany definiert, was bedeutet, dass eine Kategorie viele Produkte haben kann.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    // Getter und Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
