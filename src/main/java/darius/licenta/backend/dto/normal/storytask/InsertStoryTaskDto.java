package darius.licenta.backend.dto.normal.storytask;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class InsertStoryTaskDto implements Serializable {
    private final String title;
    private final String description;
    private final int storyPoints;
    private final LocalDateTime createdAt;
    private final Long assignedToId;
    private final String status;
    private final Long storyId;
}
