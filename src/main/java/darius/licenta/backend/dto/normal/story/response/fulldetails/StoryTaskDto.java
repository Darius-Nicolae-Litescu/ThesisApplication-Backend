package darius.licenta.backend.dto.normal.story.response.fulldetails;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class StoryTaskDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final int storyPoints;
    private final CreatedByUserDto createdBy;
    private final LocalDateTime createdAt;
    private final String status;
    private final LocalDateTime finishedAt;
    private final Date modificationDate;
}
