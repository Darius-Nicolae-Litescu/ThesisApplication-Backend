package darius.licenta.backend.persistence.jpa;


import darius.licenta.backend.domain.sql.kanban.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}