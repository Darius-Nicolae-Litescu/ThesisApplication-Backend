package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByUserId(long id);
    long deleteByRoleName(String roleName);
    @Override
    List<Role> findAll();
}