package darius.licenta.backend.mapper;

import darius.licenta.backend.domain.Role;
import darius.licenta.backend.dto.RoleInsertDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
class RoleMapperImpl implements RoleMapper {

    @Override
    public Role roleInsertDtoToRole(RoleInsertDto source) {
        if (source == null) {
            return null;
        }
        Role role = new Role();
        role.setRoleName(source.getRoleName());
        role.setRoleDescription(source.getRoleDescription());
        return role;
    }

    @Override
    public RoleInsertDto roleToRoleInsertDto(Role destination) {
        if (destination == null) {
            return null;
        }
        RoleInsertDto roleInsertDto = new RoleInsertDto();
        roleInsertDto.setRoleName(destination.getRoleName());
        roleInsertDto.setRoleDescription(destination.getRoleDescription());
        return roleInsertDto;
    }
}