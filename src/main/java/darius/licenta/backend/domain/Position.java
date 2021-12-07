package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = Position.TABLE_NAME)
public class Position {
    public static final String TABLE_NAME = "position";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Column(name = "seniority_level", nullable = false, length = 256)
    private String seniorityLevel;

    @OneToOne(mappedBy = "position")
    private Employee employee;

}
