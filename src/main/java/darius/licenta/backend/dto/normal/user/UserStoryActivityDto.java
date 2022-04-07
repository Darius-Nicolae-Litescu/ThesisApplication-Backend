package darius.licenta.backend.dto.normal.user;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserStoryActivityDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final Boolean isFinished;
    private final Long totalStoryPoints;
}
