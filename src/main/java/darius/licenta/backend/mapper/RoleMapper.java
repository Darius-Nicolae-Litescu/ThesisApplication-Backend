package darius.licenta.backend.mapper;

import darius.licenta.backend.domain.Role;
import darius.licenta.backend.dto.RoleInsertDto;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    Role roleInsertDtoToRole(RoleInsertDto source);
    RoleInsertDto roleToRoleInsertDto(Role destination);

}