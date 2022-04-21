package darius.licenta.backend.controller;

import darius.licenta.backend.dto.normal.board.request.CreateBoardDto;
import darius.licenta.backend.dto.normal.board.request.UpdateBoardDto;
import darius.licenta.backend.dto.normal.board.response.BoardSearchResponseDto;
import darius.licenta.backend.dto.normal.board.response.fulldetails.FullBoardDetailsDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ApiResponse<List<BoardSearchResponseDto>> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PutMapping("/")
    public ApiResponse<FullBoardDetailsDto> updateBoard(@RequestBody UpdateBoardDto updateBoardDto) {
        return boardService.updateBoardDetails(updateBoardDto);
    }

    @PostMapping
    public ApiResponse<FullBoardDetailsDto> createBoard(@RequestBody CreateBoardDto createBoardDto) {
        return boardService.createBoard(createBoardDto);
    }

    @PutMapping("/add/stories/all")
    public ApiResponse<Boolean> addAllStoriesToBoard(@RequestParam Long boardId) {
        return boardService.addAllStoriesToBoard(boardId);
    }
}