package darius.licenta.backend.dto.normal.board.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateBoardDto implements Serializable {
    private final String name;
    private final List<ColumnListDto> columnList;

    @Data
    public static class ColumnListDto implements Serializable {
        private final Integer columnOrder;
        private final String title;
    }
}
