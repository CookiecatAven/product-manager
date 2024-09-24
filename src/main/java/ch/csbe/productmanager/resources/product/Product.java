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

    /**
     * Die eindeutige ID des Produkts, die automatisch generiert wird.
     */
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

    /**
     * Gibt die ID des Produkts zurück.
     *
     * @return Produkt-ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Setzt die ID des Produkts.
     *
     * @param id Produkt-ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gibt den Namen des Produkts zurück.
     *
     * @return Produktname
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen des Produkts.
     *
     * @param name Produktname
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt den Preis des Produkts zurück.
     *
     * @return Produktpreis
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setzt den Preis des Produkts.
     *
     * @param price Produktpreis
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gibt die Kategorie des Produkts zurück.
     *
     * @return Produktkategorie
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Setzt die Kategorie des Produkts.
     *
     * @param category Produktkategorie
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
