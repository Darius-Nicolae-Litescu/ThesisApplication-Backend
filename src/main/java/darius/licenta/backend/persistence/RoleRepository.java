package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);

    List<Role> findByUser_Username(String username);

    List<Role> findByUser_Id(long id);

    long deleteByRoleName(String roleName);

    List<Role> findAll();
}