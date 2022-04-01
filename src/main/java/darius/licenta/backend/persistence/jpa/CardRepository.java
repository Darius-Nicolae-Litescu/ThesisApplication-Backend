package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.kanban.Board;
import darius.licenta.backend.domain.sql.kanban.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}