package ch.csbe.productmanager.resources.category.dto;

import org.jetbrains.annotations.NotNull;

/**
 * DTO zur Anzeige von Kategorien.
 */
public class CategoryShowDto {

    @NotNull
    private Integer id;

    private String name;

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
}

