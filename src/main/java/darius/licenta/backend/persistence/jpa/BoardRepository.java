package darius.licenta.backend.persistence.jpa;


import darius.licenta.backend.domain.sql.kanban.Board;
import darius.licenta.backend.dto.normal.board.response.BoardSearchResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select new darius.licenta.backend.dto.normal.board.response.BoardSearchResponseDto(b.id, b.name) from Board b")
    List<BoardSearchResponseDto> getAllBoards();
}