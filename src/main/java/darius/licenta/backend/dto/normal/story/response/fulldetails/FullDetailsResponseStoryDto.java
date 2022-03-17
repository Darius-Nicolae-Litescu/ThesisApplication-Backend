package darius.licenta.backend.dto.normal.story.response.fulldetails;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
public class FullDetailsResponseStoryDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final CreatedByUserDto createdBy;
    private final Date modificationDate;
    private final Set<CategoryDto> categories;
    private final Set<StoryTaskDto> storySubtasks;
    private final PriorityDto priority;
    private List<CommentDto> comments;
    private final Set<AttachmentDto> storyAttachments;
    private final SoftwareApplicationDto softwareApplication;
}
