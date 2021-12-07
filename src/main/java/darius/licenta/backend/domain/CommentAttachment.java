package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = CommentAttachment.TABLE_NAME)
public class CommentAttachment {
    public static final String TABLE_NAME = "comment_attachment";

    @Id
    @GeneratedValue()
    private long id;

    @CreationTimestamp
    @Column(name = "posted_at", nullable = false)
    private LocalDateTime postedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "story_comment_id", nullable = false)
    private StoryComment storyComment;
}