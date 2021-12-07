package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
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
}
