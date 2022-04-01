package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.kanban.Board;
import darius.licenta.backend.domain.sql.kanban.ColumnList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnListRepository extends JpaRepository<ColumnList, Long> {

}