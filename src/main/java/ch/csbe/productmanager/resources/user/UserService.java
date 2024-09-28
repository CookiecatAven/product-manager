package ch.csbe.productmanager.resources.user;

import ch.csbe.productmanager.resources.user.dto.UserCreateDto;
import ch.csbe.productmanager.resources.user.dto.UserDetailDto;
import ch.csbe.productmanager.resources.user.dto.UserShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service für die Benutzerverwaltung.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserShowDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserShowDto> userShowDtos = new ArrayList<>();
        for (User user : users) {
            userShowDtos.add(userMapper.toShowDto(user));
        }
        return userShowDtos;
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

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

    public UserDetailDto addUser(UserCreateDto userCreateDto) {
        User savedUser = userRepository.save(userMapper.toEntity(userCreateDto));
        return userMapper.toDetailDto(savedUser);
    }

    public Optional<UserDetailDto> updateUserRole(String username, String role) {
        return getUserByUsername(username)
                .map(user -> {
                    user.setRole(role);
                    User savedUser = userRepository.save(user);
                    return userMapper.toDetailDto(savedUser);
                });
    }
}
