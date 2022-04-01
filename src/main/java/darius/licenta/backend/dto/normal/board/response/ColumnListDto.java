package darius.licenta.backend.dto.normal.board.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class ColumnListDto implements Serializable {
    private final Long id;
    private final String title;
    private final Integer columnOrder;
    private final List<CardDto> cards;
}
