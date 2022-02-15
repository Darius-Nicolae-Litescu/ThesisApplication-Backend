package darius.licenta.backend.dto.story.response.fulldetails;

import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;

@Data
public class PriorityDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final int level;
    private final Blob priorityIcon;
}
