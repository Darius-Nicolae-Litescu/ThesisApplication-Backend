package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = Priority.TABLE_NAME)
public class Priority {
    public static final String TABLE_NAME = "priority";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "title", nullable = false, length = 256)
    private String title;

    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @Column(name = "level", nullable = false, length = 256)
    private int level;

    @OneToOne(mappedBy = "priorityIcon")
    private Attachment priorityIcon;

    @OneToOne(mappedBy = "priority")
    private Story story;

}
