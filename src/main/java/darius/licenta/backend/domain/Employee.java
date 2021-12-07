package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = Employee.TABLE_NAME)
public class Employee {
    public static final String TABLE_NAME = "employee";

    @Id
    @GeneratedValue()
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToOne(mappedBy = "employee")
    private User user;
}
