package darius.licenta.backend.service.Role;

import darius.licenta.backend.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    void saveOrUpdateRole(Role role);
    boolean deleteRole(String roleName);
    List<Role> findRolesByUserId(long userId);
    List<Role> findAllRoles();
}
