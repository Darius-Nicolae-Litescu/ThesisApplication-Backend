package darius.licenta.backend.controller;

/*
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
    public List<Role> getRole(@RequestBody RoleDto roleInsertDto) {
        Role role = roleMapper.roleDtoToRole(roleInsertDto);
        roleService.saveOrUpdateRole(role);
        return roleService.findAllRoles();
    }
}
*/