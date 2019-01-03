package tatun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tatun.model.User;
import tatun.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User category) {
        userRepository.save(category);
    }

    public User findById(int id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.get();
    }

    public void delete(User user) {
        userRepository.delete(user);

    }
    public User initUser(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user != null) return user;
        return createUser(login, password);
    }

    public User createUser(final String login, final String password) {
        final String passwordHash = passwordEncoder.encode(password);
        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordHash);
        userRepository.save(user);
        return user;
    }
}
