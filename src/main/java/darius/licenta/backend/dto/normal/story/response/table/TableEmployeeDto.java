package darius.licenta.backend.dto.normal.story.response.table;

import lombok.Data;

import java.io.Serializable;

@Data
public class TableEmployeeDto implements Serializable {
    private final Long id;
    private final Long personId;
    private final Long positionId;
    private final Long userId;
}
