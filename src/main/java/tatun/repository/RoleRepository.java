package tatun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tatun.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
