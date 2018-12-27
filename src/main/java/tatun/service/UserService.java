package tatun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tatun.model.User;
import tatun.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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
