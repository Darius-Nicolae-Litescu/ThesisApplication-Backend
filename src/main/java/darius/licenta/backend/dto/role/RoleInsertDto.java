package darius.licenta.backend.dto.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class RoleInsertDto {
    @NotNull
    @JsonProperty("roleName")
    private String roleName;

    @NotNull
    @JsonProperty("roleDescription")
    private String roleDescription;

    public String getRoleName() {
        return this.roleName;
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }

    @JsonProperty("roleName")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @JsonProperty("roleDescription")
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}