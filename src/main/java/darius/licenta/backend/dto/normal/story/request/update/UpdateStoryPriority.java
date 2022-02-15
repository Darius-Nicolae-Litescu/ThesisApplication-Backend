package darius.licenta.backend.dto.normal.story.request.update;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateStoryPriority implements Serializable {
    private final Long id;
    private final PriorityDto priority;

    @Data
    public static class PriorityDto implements Serializable {
        private final Long id;
    }
}
