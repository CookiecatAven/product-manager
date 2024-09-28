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

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
}
