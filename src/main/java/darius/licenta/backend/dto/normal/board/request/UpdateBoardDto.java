package darius.licenta.backend.dto.normal.board.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class UpdateBoardDto implements Serializable {
    private final Long id;
    private final List<ColumnListDto> columnList;

    public UpdateBoardDto(Long id, List<ColumnListDto> columnList) {
        this.id = id;
        this.columnList = columnList;
    }

    public Long getId() {
        return this.id;
    }

    public List<ColumnListDto> getColumnList() {
        return this.columnList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateBoardDto that = (UpdateBoardDto) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(columnList, that.columnList);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (columnList != null ? columnList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateBoardDto{" +
                "id=" + id +
                ", columnList=" + columnList +
                '}';
    }

    public static class ColumnListDto implements Serializable {
        private final Long id;
        private final Integer columnOrder;
        private final String title;
        private final List<CardDto> cards;

        public ColumnListDto(Long id, Integer columnOrder, String title, List<CardDto> cards) {
            this.id = id;
            this.columnOrder = columnOrder;
            this.title = title;
            this.cards = cards;
        }

        public Long getId() {
            return this.id;
        }

        public Integer getColumnOrder() {
            return this.columnOrder;
        }

        public String getTitle() {
            return this.title;
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
            if (!Objects.equals(columnOrder, that.columnOrder)) return false;
            if (!Objects.equals(title, that.title)) return false;
            return Objects.equals(cards, that.cards);
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (columnOrder != null ? columnOrder.hashCode() : 0);
            result = 31 * result + (title != null ? title.hashCode() : 0);
            result = 31 * result + (cards != null ? cards.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "ColumnListDto{" +
                    "id=" + id +
                    ", columnOrder=" + columnOrder +
                    ", title='" + title + '\'' +
                    ", cards=" + cards +
                    '}';
        }

        public static class CardDto implements Serializable {
            private final Long id;
            private final BigDecimal rank;

            public CardDto(Long id, BigDecimal rank) {
                this.id = id;
                this.rank = rank;
            }

            public Long getId() {
                return this.id;
            }

            public BigDecimal getRank() {
                return this.rank;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                CardDto cardDto = (CardDto) o;

                if (!Objects.equals(id, cardDto.id)) return false;
                return Objects.equals(rank, cardDto.rank);
            }

            @Override
            public int hashCode() {
                int result = id != null ? id.hashCode() : 0;
                result = 31 * result + (rank != null ? rank.hashCode() : 0);
                return result;
            }

            @Override
            public String toString() {
                return "CardDto{" +
                        "id=" + id +
                        ", rank=" + rank +
                        '}';
            }
        }
    }
}
