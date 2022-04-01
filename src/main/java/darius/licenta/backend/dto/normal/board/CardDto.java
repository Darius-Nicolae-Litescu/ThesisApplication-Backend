package darius.licenta.backend.dto.normal.board;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CardDto implements Serializable {
    private final Long id;
    private final BigDecimal rank;
    private final StoryDto story;
}
