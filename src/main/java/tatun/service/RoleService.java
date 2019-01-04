package tatun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tatun.model.Role;
import tatun.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public Role findById(int id) {
        Optional<Role> optional = roleRepository.findById(id);
        return optional.get();
    }

    public void delete(Role role) {
        roleRepository.delete(role);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
