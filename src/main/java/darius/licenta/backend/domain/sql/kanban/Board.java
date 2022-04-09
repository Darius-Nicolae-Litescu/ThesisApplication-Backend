package darius.licenta.backend.domain.sql.kanban;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Board.TABLE_NAME)
public class Board {
    public static final String TABLE_NAME = "board";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 512)
    private String name;

    @OrderBy("columnOrder ASC")
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ColumnList> columnList;

    public Board() {
    }

    public Board(Long id, String name, List<ColumnList> columnList) {
        this.id = id;
        this.name = name;
        this.columnList = columnList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ColumnList> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnList> columnList) {
        this.columnList = columnList;
    }
}