package darius.licenta.backend.dto.normal.storytask;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChangeStoryTaskTitleAndDescription implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
}
