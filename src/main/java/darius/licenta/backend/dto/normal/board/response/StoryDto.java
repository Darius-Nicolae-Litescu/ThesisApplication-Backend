package darius.licenta.backend.dto.normal.board.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
public class StoryDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final UserDto createdBy;
    private final Date modificationDate;
    private final Set<CategoryDto> categories;
    private final PriorityDto priority;
    private final Boolean isFinished;
    private final Long totalStoryPoints;
}
