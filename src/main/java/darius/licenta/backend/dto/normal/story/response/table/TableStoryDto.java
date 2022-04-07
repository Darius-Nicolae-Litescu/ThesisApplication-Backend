package darius.licenta.backend.dto.normal.story.response.table;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class TableStoryDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final Long createdById;
    private final Set<Long> categoryIds;
    private final Set<Long> storySubtaskIds;
    private final Long priorityId;
    private final Long softwareApplicationId;
    private final Boolean isFinished;
    private final Long totalStoryPoints;
}
