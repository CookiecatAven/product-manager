package ch.csbe.productmanager.resources.category.dto;


import org.jetbrains.annotations.NotNull;

/**
 * DTO für die Erstellung einer neuen Kategorie.
 */
public class CategoryCreateDto {

    @NotNull
    private String name;

    // Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
