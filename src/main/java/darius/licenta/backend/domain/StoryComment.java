package darius.licenta.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = StoryComment.TABLE_NAME)
public class StoryComment {
    public static final String TABLE_NAME = "story_comment";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "content", nullable = false, length = 512)
    private String content;

    @Column(name = "posted_at", nullable = false)
    private LocalDateTime postedAt;

    @OneToMany(mappedBy = "storyComment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CommentAttachment> commentAttachments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private StoryTask storyTask;

}