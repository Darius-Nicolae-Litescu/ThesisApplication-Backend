package darius.licenta.backend.dto.story.response;

import darius.licenta.backend.dto.story.response.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class StoryDto implements Serializable {
    private final Long id;
    private final String description;
    private final Set<CategoryDto> categories;
    private final Set<StoryTaskDto> storySubtasks;
    private final PriorityDto priority;
    private final Set<AttachmentDto> storyAttachments;
    private final SoftwareApplicationDto softwareApplication;
}
