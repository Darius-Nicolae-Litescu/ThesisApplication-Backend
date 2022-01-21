package darius.licenta.backend.service.role;

import darius.licenta.backend.domain.Role;
import darius.licenta.backend.dto.role.RoleDto;
import darius.licenta.backend.exception.RoleNotFoundException;
import darius.licenta.backend.mapper.role.RoleMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public ApiResponse<RoleDto> insert(RoleDto roleDto) {
        Role role = roleMapper.roleDtoToRole(roleDto);

        roleRepository.save(role);

        RoleDto responseRoleDto = roleMapper.roleToRoleDto(role);
        return new ApiResponse<>(responseRoleDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<RoleDto> update(RoleDto roleDto) {
        Optional<Role> role = roleRepository.findByRoleName(roleDto.getRoleName());
        if (role.isPresent()) {
            role.get().setRoleDescription(roleDto.getRoleDescription());
            roleRepository.save(role.get());
            RoleDto roleDtoResponse = roleMapper.roleToRoleDto(role.get());
            return new ApiResponse<>(roleDtoResponse, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<List<RoleDto>> findRolesByUserId(long userId) {
        List<Role> roles = roleRepository.findByUser_Id(userId);
        if (CollectionUtils.isEmpty(roles)) {
            return new ApiResponse<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        List<RoleDto> roleDtos = new ArrayList<>();

        roles.forEach(role -> roleDtos.add(roleMapper.roleToRoleDto(role)));
        return new ApiResponse<>(roleDtos, HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<RoleDto>> findRolesByUserUsername(String username) {
        List<Role> roles = roleRepository.findByUser_Username(username);
        if (CollectionUtils.isEmpty(roles)) {
            return new ApiResponse<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        List<RoleDto> roleDtos = new ArrayList<>();

        roles.forEach(role -> roleDtos.add(roleMapper.roleToRoleDto(role)));
        return new ApiResponse<>(roleDtos, HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<RoleDto>> findAllRoles() {
        List<Role> roles = roleRepository.findAll();

        List<RoleDto> roleDtos = new ArrayList<>();

        roles.forEach(role -> roleDtos.add(roleMapper.roleToRoleDto(role)));
        return new ApiResponse<>(roleDtos, HttpStatus.OK);
    }

    @Override
    public ApiResponse<RoleDto> deleteRole(String roleName) {
        Optional<Role> role = roleRepository.findByRoleName(roleName);
        if (role.isPresent()) {
            roleRepository.delete(role.get());
            RoleDto roleDto = roleMapper.roleToRoleDto(role.get());
            return new ApiResponse<>(roleDto, HttpStatus.ACCEPTED);
        } else {
            throw new RoleNotFoundException("Role " + roleName + " cannot be found in database");
        }
    }
}