package ch.csbe.productmanager.resources.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository für den Zugriff auf die Benutzer in der Datenbank.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
