package darius.licenta.backend.dto.normal.board.response.fulldetails;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class FullBoardDetailsDto implements Serializable {
    private final Long id;
    private final String name;
    private final List<ColumnListDto> columnList;

    public FullBoardDetailsDto(Long id, String name, List<ColumnListDto> columnList) {
        this.id = id;
        this.name = name;
        this.columnList = columnList;
    }


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<ColumnListDto> getColumnList() {
        return this.columnList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullBoardDetailsDto that = (FullBoardDetailsDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(columnList, that.columnList);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (columnList != null ? columnList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FullBoardDetailsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", columnList=" + columnList +
                '}';
    }
}
