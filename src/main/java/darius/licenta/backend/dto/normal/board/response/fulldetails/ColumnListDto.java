package darius.licenta.backend.dto.normal.board.response.fulldetails;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ColumnListDto implements Serializable {
    private final Long id;
    private final String title;
    private final Integer columnOrder;
    private final List<CardDto> cards;

    public ColumnListDto(Long id, String title, Integer columnOrder, List<CardDto> cards) {
        this.id = id;
        this.title = title;
        this.columnOrder = columnOrder;
        this.cards = cards;
    }


    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getColumnOrder() {
        return this.columnOrder;
    }

    public List<CardDto> getCards() {
        return this.cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColumnListDto that = (ColumnListDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(columnOrder, that.columnOrder)) return false;
        return Objects.equals(cards, that.cards);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (columnOrder != null ? columnOrder.hashCode() : 0);
        result = 31 * result + (cards != null ? cards.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ColumnListDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", columnOrder=" + columnOrder +
                ", cards=" + cards +
                '}';
    }
}
