package darius.licenta.backend.domain.sql;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.util.*;

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

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "picture_id")
    private Picture profilePicture;

    @Column(name = "bio_description", nullable = true, length = 3000)
    private String bioDescription;

    @Column(name = "email", nullable = false, length = 256)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date modificationDate;

    @CollectionTable(name = "user_roles")
    @ElementCollection(fetch = FetchType.EAGER)
    List<UserRole> userRoles;

    @OneToMany(mappedBy = "uploadedBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> userAttachments;

    @OneToMany(mappedBy = "postedBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> userComments;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Story> userStories;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StoryTask> userStoryTasks;

    public User(Long id, Employee employee, String username, String password, Picture profilePicture, String bioDescription, String email, Date modificationDate, List<UserRole> userRoles, Set<Attachment> userAttachments, Set<Comment> userComments, Set<Story> userStories, Set<StoryTask> userStoryTasks) {
        this.id = id;
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.bioDescription = bioDescription;
        this.email = email;
        this.modificationDate = modificationDate;
        this.userRoles = userRoles;
        this.userAttachments = userAttachments;
        this.userComments = userComments;
        this.userStories = userStories;
        this.userStoryTasks = userStoryTasks;
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

    public Set<Comment> getUserComments() {
        return userComments;
    }

    public Set<Story> getUserStories() {
        return userStories;
    }

    public Set<StoryTask> getUserStoryTasks() {
        return userStoryTasks;
    }

    public String getBioDescription() {
        return bioDescription;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Set<Attachment> getUserAttachments() {
        return userAttachments;
    }

    public Picture getProfilePicture() {
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

    public void setUserComments(Set<Comment> userComments) {
        this.userComments = userComments;
    }

    public void setUserStories(Set<Story> userStories) {
        this.userStories = userStories;
    }

    public void setUserStoryTasks(Set<StoryTask> userStoryTasks) {
        this.userStoryTasks = userStoryTasks;
    }

    public void setProfilePicture(Picture profilePicture) {
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

    public void setBioDescription(String bioDescription) {
        this.bioDescription = bioDescription;
    }

    public void addUserComment(Comment comment) {
        this.userComments.add(comment);
    }

    public void addUserRole(UserRole userRole) {
        this.userRoles.add(userRole);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(username, user.username)) return false;
        return Objects.equals(email, user.email);
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
