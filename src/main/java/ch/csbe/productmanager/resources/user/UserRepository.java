package ch.csbe.productmanager.resources.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * Repository für den Zugriff auf die Benutzer in der Datenbank.
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
