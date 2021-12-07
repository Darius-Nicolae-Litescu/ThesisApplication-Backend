package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = Person.TABLE_NAME)
public class Person {
    public static final String TABLE_NAME = "person";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "first_name", nullable = false, length = 256)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @OneToOne(mappedBy = "person")
    private Employee employee;
}
