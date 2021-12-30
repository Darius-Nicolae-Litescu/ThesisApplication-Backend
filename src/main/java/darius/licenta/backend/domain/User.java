package darius.licenta.backend.domain;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue()
    private long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "username", nullable = false, length = 256)
    private String username;

    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "profile_picture", nullable = true)
    @Lob
    private Blob profilePicture;

    @Column(name = "email", nullable = false, length = 256)
    private String email;

    @Column(name = "is_active", nullable = false, length = 256)
    private Boolean isActive;

    @Column(name = "is_deleted", nullable = false, length = 256)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Role> roles;

    public User(Employee employee, String username, String password, String email, Boolean isActive, Boolean isDeleted) {
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public User(Employee employee, String username, String password, Blob profilePicture, String email, Boolean isActive, Boolean isDeleted) {
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.email = email;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public User(Employee employee, String username, String password, String email) {
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isActive = true;
        this.isDeleted = false;
    }

    public User() {
    }

    public Blob getProfilePicture() {
        return profilePicture;
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

    public void setProfilePicture(Blob profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(employee, user.employee) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(profilePicture, user.profilePicture) && Objects.equals(email, user.email) && Objects.equals(isActive, user.isActive) && Objects.equals(isDeleted, user.isDeleted) && Objects.equals(roles, user.roles);
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
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", employee=" + this.getEmployee() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", email=" + this.getEmail() + ", isActive=" + this.getIsActive() + ", isDeleted=" + this.getIsDeleted() + ", roles=" + this.getRoles() + ")";
    }
}
