package darius.licenta.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = StoryTask.TABLE_NAME)
public class StoryTask {
    public static final String TABLE_NAME = "story_task";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "title", length = 512)
    private String title;

    @Column(name = "description", length = 512)
    private String description;

    @Column(name = "story_points")
    private int storyPoints;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    @Column(name = "status", nullable = false, length = 512)
    private String status;

    @CreationTimestamp
    @Column(name = "finished_at", nullable = false)
    private LocalDateTime finishedAt;

    @OneToMany(mappedBy = "storyTask", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StoryComment> storyComments;

    @OneToMany(mappedBy = "commentAttachment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> commentAttachments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Story story;
}