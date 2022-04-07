package darius.licenta.backend.dto.normal.story.request.update;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChangeStoryTitleAndDescription implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
}
