package darius.licenta.backend.dto.story.response.table;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class ResponseStoryDtoWithoutFullDetails implements Serializable {
    private final Long id;
    private final String description;
    private final Set<CategoryDto> categories;
    private final Set<StoryTaskDto> storySubtasks;
    private final PriorityDto priority;
    private final Set<AttachmentDto> storyAttachments;
    private final SoftwareApplicationDto softwareApplication;

    @Data
    public static class CategoryDto implements Serializable {
        private final Long id;
    }

    @Data
    public static class StoryTaskDto implements Serializable {
        private final Long id;
    }

    @Data
    public static class PriorityDto implements Serializable {
        private final Long id;
    }

    @Data
    public static class SoftwareApplicationDto implements Serializable {
        private final Long id;
    }
}
