package darius.licenta.backend.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = Role.TABLE_NAME)
public class Role {
    public static final String TABLE_NAME = "role";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "role_name", nullable = false, length = 256)
    private String roleName;

    @Column(name = "role_description", nullable = false, length = 512)
    private String roleDescription;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private User user;

    public Role(long id, String roleName, String roleDescription, User user) {
        this.id = id;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.user = user;
    }

    public Role(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public Role() {
    }

    public long getId() {
        return this.id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }

    public User getUser() {
        return this.user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Role)) return false;
        final Role other = (Role) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$roleName = this.getRoleName();
        final Object other$roleName = other.getRoleName();
        if (!Objects.equals(this$roleName, other$roleName)) return false;
        final Object this$roleDescription = this.getRoleDescription();
        final Object other$roleDescription = other.getRoleDescription();
        if (!Objects.equals(this$roleDescription, other$roleDescription))
            return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (!Objects.equals(this$user, other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Role;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $roleName = this.getRoleName();
        result = result * PRIME + ($roleName == null ? 43 : $roleName.hashCode());
        final Object $roleDescription = this.getRoleDescription();
        result = result * PRIME + ($roleDescription == null ? 43 : $roleDescription.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Role(id=" + this.getId() + ", roleName=" + this.getRoleName() + ", roleDescription=" + this.getRoleDescription() + ", user=" + this.getUser() + ")";
    }
}

