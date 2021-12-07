package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = SoftwareApplication.TABLE_NAME)
public class SoftwareApplication {
    public static final String TABLE_NAME = "software_application";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @OneToMany(mappedBy = "softwareApplication", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Story> stories;

}

