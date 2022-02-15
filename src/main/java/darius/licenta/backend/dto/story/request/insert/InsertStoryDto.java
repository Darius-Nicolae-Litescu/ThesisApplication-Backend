package darius.licenta.backend.dto.story.request.insert;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class InsertStoryDto implements Serializable {
    private final String description;
    private final Set<InsertStoryCategoryDto> categories;
    private final InsertStoryPriorityDto priority;
}
