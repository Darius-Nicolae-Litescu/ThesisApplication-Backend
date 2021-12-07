package darius.licenta.backend.controllers;

import darius.licenta.backend.domain.Role;
import darius.licenta.backend.dto.RoleInsertDto;
import darius.licenta.backend.mapper.RoleMapper;
import darius.licenta.backend.service.RoleService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
//@Api(tags = {"Authentication"})
public class RoleController {

    private final RoleService roleService;

    private final RoleMapper roleMapper;

    @Autowired
    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @RequestMapping(value = "/getRole", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> getRole(@RequestBody RoleInsertDto roleInsertDto) {
        Role role = roleMapper.roleInsertDtoToRole(roleInsertDto);
        roleService.saveOrUpdateRole(role);
        return roleService.findAllRoles();
    }
}
