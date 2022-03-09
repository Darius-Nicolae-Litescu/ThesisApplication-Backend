package darius.licenta.backend.dto.normal.story.request.insert;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class InsertStoryDto implements Serializable {
    private final String title;
    private final String description;
    private final Set<Long> categoryIds;
    private final Long priorityId;
    private final Long softwareApplicationId;
}
