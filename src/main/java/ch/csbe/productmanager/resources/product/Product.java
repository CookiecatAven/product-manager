package ch.csbe.productmanager.resources.product;

import ch.csbe.productmanager.resources.category.Category;
import jakarta.persistence.*;

/**
 * Die Product-Klasse repräsentiert ein Produkt in der Datenbank.
 * Jedes Produkt gehört zu einer bestimmten Kategorie.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Der Name des Produkts.
     */
    private String name;

    /**
     * Der Preis des Produkts.
     */
    private double price;

    /**
     * Die Kategorie, zu der dieses Produkt gehört.
     * Die Beziehung wird durch @ManyToOne definiert, was bedeutet, dass viele Produkte zu einer Kategorie gehören können.
     */
    @ManyToOne
    @JoinColumn(name = "category_id")  // Fremdschlüssel in der Tabelle "products"
    private Category category;

    // Getter und Setter für alle Felder
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
