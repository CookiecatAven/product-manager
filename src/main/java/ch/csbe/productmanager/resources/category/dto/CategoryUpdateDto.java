package ch.csbe.productmanager.resources.category.dto;

/**
 * DTO zur Aktualisierung von Kategorien.
 */
public class CategoryUpdateDto {

    private String name;

    // Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

