package ch.csbe.productmanager.resources.product;

import ch.csbe.productmanager.resources.category.Category;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Die Product-Klasse repräsentiert ein Produkt in der Datenbank.
 * Jedes Produkt gehört zu einer bestimmten Kategorie.
 */
@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Integer id;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean active;

    @Column(unique = true, nullable = false, length = 100)
    private String sku;

    @Column(nullable = false, length = 500)
    private String name;

    @Column(nullable = false, length = 1000)
    private String image;

    @Column(nullable = false, columnDefinition = "MEDIUMTEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "FLOAT")
    private Float price;

    @Column(nullable = false, columnDefinition = "INT")
    private Integer stock;

    /**
     * Die Kategorie, zu der dieses Produkt gehört.
     * Die Beziehung wird durch @ManyToOne definiert, was bedeutet, dass viele Produkte zu einer Kategorie gehören können.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")  // Fremdschlüssel in der Tabelle "products"
    private Category category;
}
