package ch.csbe.productmanager.resources.category;

import ch.csbe.productmanager.resources.product.Product;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

/**
 * Die Category-Klasse repräsentiert eine Kategorie in der Datenbank.
 * Eine Kategorie kann viele Produkte enthalten.
 */
@Entity
@Table(name = "categories")
@Data
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
}

