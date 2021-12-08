package darius.licenta.backend.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue()
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "username", nullable = false, length = 256)
    private String username;

    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "email", nullable = false, length = 256)
    private String email;

    @Column(name = "is_active", nullable = false, length = 256)
    private Boolean isActive;

    @Column(name = "is_deleted", nullable = false, length = 256)
    private Boolean isDeleted;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Role> roles;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> attachment;

    public User(long id, Employee employee, String username, String password, String email, Boolean isActive, Boolean isDeleted, Set<Role> roles, Set<Attachment> attachment) {
        this.id = id;
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.roles = roles;
        this.attachment = attachment;
    }

    public User(Employee employee, String username, String password, String email, Boolean isActive, Boolean isDeleted) {
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public User() {
    }

    public long getId() {
        return this.id;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public Set<Attachment> getAttachment() {
        return this.attachment;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setAttachment(Set<Attachment> attachment) {
        this.attachment = attachment;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual(this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$employee = this.getEmployee();
        final Object other$employee = other.getEmployee();
        if (!Objects.equals(this$employee, other$employee)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (!Objects.equals(this$username, other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (!Objects.equals(this$password, other$password)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (!Objects.equals(this$email, other$email)) return false;
        final Object this$isActive = this.getIsActive();
        final Object other$isActive = other.getIsActive();
        if (!Objects.equals(this$isActive, other$isActive)) return false;
        final Object this$isDeleted = this.getIsDeleted();
        final Object other$isDeleted = other.getIsDeleted();
        if (!Objects.equals(this$isDeleted, other$isDeleted)) return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if (!Objects.equals(this$roles, other$roles)) return false;
        final Object this$attachment = this.getAttachment();
        final Object other$attachment = other.getAttachment();
        return Objects.equals(this$attachment, other$attachment);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $employee = this.getEmployee();
        result = result * PRIME + ($employee == null ? 43 : $employee.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $isActive = this.getIsActive();
        result = result * PRIME + ($isActive == null ? 43 : $isActive.hashCode());
        final Object $isDeleted = this.getIsDeleted();
        result = result * PRIME + ($isDeleted == null ? 43 : $isDeleted.hashCode());
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        final Object $attachment = this.getAttachment();
        result = result * PRIME + ($attachment == null ? 43 : $attachment.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", employee=" + this.getEmployee() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", email=" + this.getEmail() + ", isActive=" + this.getIsActive() + ", isDeleted=" + this.getIsDeleted() + ", roles=" + this.getRoles() + ", attachment=" + this.getAttachment() + ")";
    }
}
