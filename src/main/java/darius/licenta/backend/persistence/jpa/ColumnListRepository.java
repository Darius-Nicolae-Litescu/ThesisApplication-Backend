package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.kanban.ColumnList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColumnListRepository extends JpaRepository<ColumnList, Long> {
    @Modifying
    @Query("UPDATE ColumnList as cl SET cl.title = ?1, cl.columnOrder = ?2 WHERE cl.id = ?3")
    void updateColumnList(String title, int columnOrder, Long columnListId);

    List<ColumnList> findByBoard_Id(Long id);
}