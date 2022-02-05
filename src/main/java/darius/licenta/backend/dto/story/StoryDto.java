package darius.licenta.backend.dto.story;

import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class StoryDto implements Serializable {
    private final long id;
    private final Set<CategoryDto> categories;
    private final Set<StoryTaskDto> storySubtasks;
    private final long priorityId;
    private final String priorityTitle;
    private final String priorityDescription;
    private final int priorityLevel;
    private final Blob priorityPriorityIcon;
    private final Set<AttachmentDto> storyAttachments;
    private final long softwareApplicationId;
    private final String softwareApplicationName;
    private final String softwareApplicationDescription;

    @Data
    public static class CategoryDto implements Serializable {
        private final long id;
        private final String categoryName;
    }

    @Data
    public static class StoryTaskDto implements Serializable {
        private final long id;
        private final String title;
        private final String description;
        private final int storyPoints;
        private final LocalDateTime createdAt;
        private final String status;
        private final LocalDateTime finishedAt;
    }

    @Data
    public static class AttachmentDto implements Serializable {
        private final long id;
        private final String contentType;
        private final Blob content;
        private final LocalDateTime postedAt;
    }
}
