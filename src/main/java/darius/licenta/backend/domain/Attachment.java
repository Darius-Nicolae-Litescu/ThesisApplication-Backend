package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = Attachment.TABLE_NAME)
public class Attachment {
    public static final String TABLE_NAME = "attachment";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "content_type", nullable = false, length = 256)
    private String contentType;

    @Column(name = "content", nullable = false)
    @Lob
    private Blob content;

    @CreationTimestamp
    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime postedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CommentAttachment commentAttachment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private StoryTask storyTask;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Priority priorityIcon;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Story story;
}