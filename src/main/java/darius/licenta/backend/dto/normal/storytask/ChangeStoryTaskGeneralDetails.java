package darius.licenta.backend.dto.normal.storytask;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ChangeStoryTaskGeneralDetails implements Serializable {
    private final Long id;
    private final int storyPoints;
    private final String assignedToUsername;
    private final String status;
    private final LocalDateTime finishedAt;
}
