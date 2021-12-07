package darius.licenta.backend.mapper.role;

import darius.licenta.backend.domain.Role;
import darius.licenta.backend.dto.role.RoleInsertDto;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    Role roleInsertDtoToRole(RoleInsertDto source);
    RoleInsertDto roleToRoleInsertDto(Role destination);

}