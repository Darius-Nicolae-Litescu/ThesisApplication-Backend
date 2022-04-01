package darius.licenta.backend.dto.normal.board.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class UpdateBoardDto implements Serializable {
    private final Long id;
    private final List<ColumnListDto> columnList;

    @Data
    public static class ColumnListDto implements Serializable {
        private final Long id;
        private final Integer columnOrder;
        private final String title;
        private final List<CardDto> cards;

        @Data
        public static class CardDto implements Serializable {
            private final Long id;
            private final BigDecimal rank;
        }
    }
}
