package ch.csbe.productmanager.resources.user;

import ch.csbe.productmanager.resources.user.dto.UserCreateDto;
import ch.csbe.productmanager.resources.user.dto.UserDetailDto;
import ch.csbe.productmanager.resources.user.dto.UserShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service für die Benutzerverwaltung.
 * Dieser Service enthält Methoden zum Abrufen, Erstellen, Aktualisieren und Überprüfen von Benutzern.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Konstruktor zur Initialisierung des UserService.
     *
     * @param userRepository Repository zur Datenbankverwaltung von Benutzern
     * @param userMapper Mapper zum Konvertieren zwischen DTOs und Entitäten
     */
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Ruft alle Benutzer ab und konvertiert sie in DTOs zur Anzeige.
     *
     * @return Liste von UserShowDto mit allen Benutzern
     */
    public List<UserShowDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserShowDto> userShowDtos = new ArrayList<>();
        for (User user : users) {
            userShowDtos.add(userMapper.toShowDto(user));
        }
        return userShowDtos;
    }

    /**
     * Sucht einen Benutzer anhand seines Benutzernamens.
     *
     * @param username Der Benutzername des gesuchten Benutzers
     * @return Optional mit dem gefundenen Benutzer oder leer, falls nicht gefunden
     */
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Überprüft, ob die Anmeldedaten korrekt sind, indem das Passwort mit dem gespeicherten Wert verglichen wird.
     *
     * @param username Der Benutzername des zu überprüfenden Benutzers
     * @param password Das Passwort, das überprüft werden soll
     * @return Optional mit dem Benutzer, wenn die Anmeldedaten korrekt sind, oder leer
     */
    public Optional<User> getUserWithCredentials(String username, String password) {
        Optional<User> foundUser = userRepository.findByUsername(username);
        // Wenn User mit Benutzername gefunden wurde, muss das Passwort überprüft werden
        return foundUser.map(user -> {
            if (encoder.matches(password, user.getPassword())) {
                return user;
            }
            return null;
        });
    }

    /**
     * Erstellt einen neuen Benutzer basierend auf den übergebenen Daten.
     * Verschlüsselt das Passwort und setzt die Standardrolle auf "Benutzer".
     *
     * @param userCreateDto DTO mit den Informationen für den neuen Benutzer
     * @return UserDetailDto mit den Details des neu erstellten Benutzers
     */
    public UserDetailDto addUser(UserCreateDto userCreateDto) {
        User userToSave = userMapper.toEntity(userCreateDto);
        // Passwort verschlüsseln bevor Entity gespeichert wird
        userToSave.setPassword(encoder.encode(userToSave.getPassword()));
        // Neue User haben die Rolle "Benutzer"
        userToSave.setRole("Benutzer");
        User savedUser = userRepository.save(userToSave);
        return userMapper.toDetailDto(savedUser);
    }

    /**
     * Aktualisiert die Rolle eines Benutzers anhand des Benutzernamens.
     *
     * @param username Der Benutzername des Benutzers, dessen Rolle aktualisiert werden soll
     * @param role Die neue Rolle, die dem Benutzer zugewiesen werden soll
     * @return Optional mit UserDetailDto, falls die Rolle erfolgreich aktualisiert wird
     */
    public Optional<UserDetailDto> updateUserRole(String username, String role) {
        return getUserByUsername(username)
                .map(user -> {
                    user.setRole(role);
                    User savedUser = userRepository.save(user);
                    return userMapper.toDetailDto(savedUser);
                });
    }
}
