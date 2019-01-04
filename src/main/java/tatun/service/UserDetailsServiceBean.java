package tatun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tatun.model.Role;
import tatun.model.User;
import tatun.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceBean implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null) throw new UsernameNotFoundException("User not found.");

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(login);

        builder.password(user.getPassword());

        List<Role> userRoles = user.getRoles();
        List<String> roles = new ArrayList<>();
        for(Role role : userRoles) roles.add(role.getName());
        builder.roles(roles.toArray(new String[] {}));

        return builder.build();
    }
}
