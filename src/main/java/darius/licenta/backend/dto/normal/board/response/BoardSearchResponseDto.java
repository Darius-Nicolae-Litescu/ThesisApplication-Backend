package darius.licenta.backend.dto.normal.board.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BoardSearchResponseDto implements Serializable {
    private final Long id;
    private final String name;

    public BoardSearchResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
