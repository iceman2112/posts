package tatun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tatun.enums.Roles;
import tatun.model.Role;
import tatun.model.User;
import tatun.repository.RoleRepository;
import tatun.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

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

    public void createUser(final String login, final String password, Roles roleEnum) {
        final String passwordHash = passwordEncoder.encode(password);

        User user = userRepository.findByLogin(login);
        if (user == null) return;

        user = new User();
        user.setLogin(login);
        user.setPassword(passwordHash);

        Role role = roleService.findByName(roleEnum.name());
        if (role == null) {
            role = new Role();
            role.setName(roleEnum.name());
            roleService.save(role);
        }

        List<Role> roles = new ArrayList<>();
        roles.add(role);

        user.setRoles(roles);

        userRepository.save(user);
    }
}
