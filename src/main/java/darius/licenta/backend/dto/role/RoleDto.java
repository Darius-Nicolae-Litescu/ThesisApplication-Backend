package darius.licenta.backend.dto.role;

import java.io.Serializable;

public class RoleDto implements Serializable {
    private String roleName;
    private String roleDescription;

    public RoleDto(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public RoleDto() {
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RoleDto)) return false;
        final RoleDto other = (RoleDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$roleName = this.getRoleName();
        final Object other$roleName = other.getRoleName();
        if (this$roleName == null ? other$roleName != null : !this$roleName.equals(other$roleName)) return false;
        final Object this$roleDescription = this.getRoleDescription();
        final Object other$roleDescription = other.getRoleDescription();
        if (this$roleDescription == null ? other$roleDescription != null : !this$roleDescription.equals(other$roleDescription))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RoleDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $roleName = this.getRoleName();
        result = result * PRIME + ($roleName == null ? 43 : $roleName.hashCode());
        final Object $roleDescription = this.getRoleDescription();
        result = result * PRIME + ($roleDescription == null ? 43 : $roleDescription.hashCode());
        return result;
    }

    public String toString() {
        return "RoleDto(roleName=" + this.getRoleName() + ", roleDescription=" + this.getRoleDescription() + ")";
    }
}
