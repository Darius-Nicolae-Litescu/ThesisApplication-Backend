package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = Story.TABLE_NAME)
public class Story {
    public static final String TABLE_NAME = "story";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @OneToMany(mappedBy="story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StoryTask> storySubtasks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "priority", nullable = false)
    private Priority priority;

    @OneToMany(mappedBy="story", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> storyAttachments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private SoftwareApplication softwareApplication;
}

