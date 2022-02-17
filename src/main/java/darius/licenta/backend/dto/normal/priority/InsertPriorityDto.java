package darius.licenta.backend.dto.normal.priority;

import lombok.Data;

import java.io.Serializable;

@Data
public class InsertPriorityDto implements Serializable {
    private final String title;
    private final String description;
    private final int level;
}
