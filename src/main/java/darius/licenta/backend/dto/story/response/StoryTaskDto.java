package darius.licenta.backend.dto.story.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class StoryTaskDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final int storyPoints;
    private final LocalDateTime createdAt;
    private final String status;
    private final LocalDateTime finishedAt;
}
