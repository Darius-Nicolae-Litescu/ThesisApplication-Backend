package darius.licenta.backend.dto.normal.board;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class ColumnListDto implements Serializable {
    private final Long id;
    private final String title;
    private final Integer columnOrder;
    private final Set<CardDto> cards;
}
