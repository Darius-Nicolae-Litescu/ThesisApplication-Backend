package darius.licenta.backend.service.role;

import darius.licenta.backend.domain.Role;
import darius.licenta.backend.dto.role.RoleDto;
import darius.licenta.backend.dto.softwareapplication.InsertSoftwareApplicationDto;
import darius.licenta.backend.dto.softwareapplication.SoftwareApplicationDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;

public interface RoleService {
    ApiResponse<RoleDto> insert(RoleDto roleDto);

    ApiResponse<RoleDto> update (RoleDto roleDto);

    ApiResponse<List<RoleDto>> findRolesByUserId(long userId);

    ApiResponse<List<RoleDto>> findRolesByUserUsername(String username);

    ApiResponse<List<RoleDto>> findAllRoles();

    ApiResponse<RoleDto> deleteRole(String roleName);
}
