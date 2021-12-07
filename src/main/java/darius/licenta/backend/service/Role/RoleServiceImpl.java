package darius.licenta.backend.service.Role;

import darius.licenta.backend.persistence.RoleRepository;
import darius.licenta.backend.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public void saveOrUpdateRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public boolean deleteRole(String roleName) {
        return roleRepository.deleteByRoleName(roleName) > 0;
    }

    @Override
    public List<Role> findRolesByUserId(long userId) {
        List<Role> roles = roleRepository.findByUserId(userId);
        if (Objects.isNull(roles)) {
            return new ArrayList<>();
        }
        return roles;
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}