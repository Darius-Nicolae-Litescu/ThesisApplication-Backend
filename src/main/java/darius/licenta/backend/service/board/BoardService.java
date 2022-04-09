package darius.licenta.backend.service.board;

import darius.licenta.backend.dto.normal.board.request.CreateBoardDto;
import darius.licenta.backend.dto.normal.board.request.UpdateBoardDto;
import darius.licenta.backend.dto.normal.board.response.BoardSearchResponseDto;
import darius.licenta.backend.dto.normal.board.response.FullBoardDetailsDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;

public interface BoardService {

    ApiResponse<FullBoardDetailsDto> getFullDetailsByBoardId(Long id);
    ApiResponse<FullBoardDetailsDto> updateBoardDetails(UpdateBoardDto updateBoardDto);
    ApiResponse<List<BoardSearchResponseDto>> getAllBoards();
    ApiResponse<FullBoardDetailsDto> createBoard(CreateBoardDto createBoardDto);
    ApiResponse<Boolean> addAllStoriesToBoard(Long boardId);
}