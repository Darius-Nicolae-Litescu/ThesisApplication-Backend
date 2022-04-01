package darius.licenta.backend.domain.sql.kanban;

import darius.licenta.backend.domain.sql.Attachment;
import darius.licenta.backend.domain.sql.Story;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = Card.TABLE_NAME)
public class Card {
    public static final String TABLE_NAME = "card";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rank", columnDefinition="Decimal(10,2) default '0.0'")
    private BigDecimal rank;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private ColumnList columnList;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Story story;

    public Card(Long id, BigDecimal rank, ColumnList columnList, Story story) {
        this.id = id;
        this.rank = rank;
        this.columnList = columnList;
        this.story = story;
    }

    public Card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getRank() {
        return rank;
    }

    public void setRank(BigDecimal rank) {
        this.rank = rank;
    }

    public ColumnList getColumnList() {
        return columnList;
    }

    public void setColumnList(ColumnList columnList) {
        this.columnList = columnList;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}