package ch.csbe.productmanager.resources.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository für den Zugriff auf die Benutzer in der Datenbank.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
