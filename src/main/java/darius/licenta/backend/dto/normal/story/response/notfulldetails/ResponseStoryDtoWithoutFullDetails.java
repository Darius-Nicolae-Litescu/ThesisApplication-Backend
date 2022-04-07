package darius.licenta.backend.dto.normal.story.response.notfulldetails;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
public class ResponseStoryDtoWithoutFullDetails implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final Long createdById;
    private final String createdByUsername;
    private final String createdByEmail;
    private final Date modificationDate;
    private final Set<CategoryDto> categories;
    private final Set<StoryTaskDto> storySubtasks;
    private final Long priorityId;
    private final String priorityTitle;
    private final String priorityDescription;
    private final int priorityLevel;
    private final Boolean isFinished;
    private final Long totalStoryPoints;

    @Data
    public static class CategoryDto implements Serializable {
        private final Long id;
        private final String categoryName;
    }

    @Data
    public static class StoryTaskDto implements Serializable {
        private final Long id;
        private final String title;
        private final String description;
    }
}
