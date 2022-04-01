package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.kanban.Board;
import darius.licenta.backend.domain.sql.kanban.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface CardRepository extends JpaRepository<Card, Long> {
    @Modifying
    @Query("UPDATE Card c SET c.columnList.id = ?1, c.rank = ?2 WHERE c.id = ?3")
    void updateCardInformation(Long columnListId, BigDecimal rank, Long cardId);
}