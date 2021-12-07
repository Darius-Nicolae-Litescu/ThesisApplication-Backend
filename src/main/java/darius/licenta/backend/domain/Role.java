package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
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

}

