package darius.licenta.backend.dto.normal.board.request;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CreateBoardDto implements Serializable {
    private final String name;
    private final List<ColumnListDto> columnList;

    public CreateBoardDto(String name, List<ColumnListDto> columnList) {
        this.name = name;
        this.columnList = columnList;
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

        CreateBoardDto that = (CreateBoardDto) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(columnList, that.columnList);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (columnList != null ? columnList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreateBoardDto{" +
                "name='" + name + '\'' +
                ", columnList=" + columnList +
                '}';
    }

    public static class ColumnListDto implements Serializable {
        private final Integer columnOrder;
        private final String title;

        public ColumnListDto(Integer columnOrder, String title) {
            this.columnOrder = columnOrder;
            this.title = title;
        }

        public Integer getColumnOrder() {
            return this.columnOrder;
        }

        public String getTitle() {
            return this.title;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ColumnListDto that = (ColumnListDto) o;

            if (!Objects.equals(columnOrder, that.columnOrder)) return false;
            return Objects.equals(title, that.title);
        }

        @Override
        public int hashCode() {
            int result = columnOrder != null ? columnOrder.hashCode() : 0;
            result = 31 * result + (title != null ? title.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "ColumnListDto{" +
                    "columnOrder=" + columnOrder +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
}
