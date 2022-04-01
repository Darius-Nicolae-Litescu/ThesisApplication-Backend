package darius.licenta.backend.domain.sql.kanban;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = ColumnList.TABLE_NAME)
public class ColumnList {
    public static final String TABLE_NAME = "card_board";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "column_order", nullable = false, length = 512)
    private Integer columnOrder;

    @Column(name = "title", nullable = false, length = 512)
    private String title;

    @OrderBy("rank ASC")
    @OneToMany(mappedBy= "columnList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Card> cards;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Board board;

    public ColumnList() {
    }

    public ColumnList(Long id, Integer columnOrder, String title, List<Card> cards, Board board) {
        this.id = id;
        this.columnOrder = columnOrder;
        this.title = title;
        this.cards = cards;
        this.board = board;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getColumnOrder() {
        return columnOrder;
    }

    public void setColumnOrder(Integer columnOrder) {
        this.columnOrder = columnOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
