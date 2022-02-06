package darius.licenta.backend.domain;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @CollectionTable(name="user_roles")
    @ElementCollection(fetch = FetchType.EAGER)
    List<UserRole> userRoles;

    @OneToMany(mappedBy = "uploadedBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> userAttachments;

    public User(Employee employee, String username, String password, String email, Boolean isActive, Boolean isDeleted) {
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(Employee employee, String username, String password, Blob profilePicture, String email, Boolean isActive, Boolean isDeleted) {
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.email = email;
    }

    public User(Employee employee, String username, String password, String email) {
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
        UserRole defaultUserRole = UserRole.USER;
        UserRole adminUserRole = UserRole.ADMIN;
        UserRole moderatorUserRole = UserRole.MODERATOR;

        userRoles = new ArrayList<>();
        userRoles.add(defaultUserRole);
        userRoles.add(adminUserRole);
        userRoles.add(moderatorUserRole);

    }

    public Set<Attachment> getUserAttachments() {
        return userAttachments;
    }

    public Blob getProfilePicture() {
        return profilePicture;
    }

    public Long getId() {
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

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setId(Long id) {
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


    public void setProfilePicture(Blob profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setUserAttachments(Set<Attachment> userAttachments) {
        this.userAttachments = userAttachments;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void removeUserRole(UserRole userRole) {
        this.userRoles.remove(userRole);
    }

    public void addUserRole(UserRole userRole) {
        this.userRoles.add(userRole);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
