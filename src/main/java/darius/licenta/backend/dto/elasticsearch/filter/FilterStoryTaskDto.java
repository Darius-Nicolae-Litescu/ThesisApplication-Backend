package darius.licenta.backend.dto.elasticsearch.filter;

import lombok.Data;

@Data
public class FilterStoryTaskDto {
    private final String title;
    private final String description;
    private final Long storyPoints;
    private final String createdByUsername;
    private final String assignedToUsername;
    private final String status;

}
