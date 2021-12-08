package darius.licenta.backend.service.role;

import darius.licenta.backend.domain.Role;

import java.util.List;

public interface RoleService {
    void saveOrUpdateRole(Role role);
    boolean deleteRole(String roleName);
    List<Role> findRolesByUserId(long userId);
    List<Role> findAllRoles();
}
