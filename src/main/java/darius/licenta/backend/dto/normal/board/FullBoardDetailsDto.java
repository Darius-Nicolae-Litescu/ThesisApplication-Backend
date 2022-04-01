package darius.licenta.backend.dto.normal.board;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class FullBoardDetailsDto implements Serializable {
    private final Long id;
    private final String name;
    private final List<ColumnListDto> columnList;
}
