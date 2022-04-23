package darius.licenta.backend.dto.normal.board.response;

import java.io.Serializable;
import java.util.Objects;

public class BoardSearchResponseDto implements Serializable {
    private final Long id;
    private final String name;

    public BoardSearchResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardSearchResponseDto that = (BoardSearchResponseDto) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BoardSearchResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
