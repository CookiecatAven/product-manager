package ch.csbe.productmanager.resources.user;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Die User-Klasse repräsentiert einen Benutzer in der Datenbank.
 */
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Integer id;

    private String username;

    private String password;

    private String role;

}
