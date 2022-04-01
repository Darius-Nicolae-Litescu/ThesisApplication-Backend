package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.Attachment;
import darius.licenta.backend.domain.sql.kanban.Board;
import darius.licenta.backend.dto.normal.board.FullBoardDetailsDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.kanban.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/{id}")
    public ApiResponse<FullBoardDetailsDto> getFullBoardDetails(@PathVariable Long id) {
        return boardService.getFullDetailsByBoardId(id);
    }

}