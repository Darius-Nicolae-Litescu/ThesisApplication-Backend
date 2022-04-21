package darius.licenta.backend.mapper.normal.board;

import darius.licenta.backend.domain.sql.kanban.Board;
import darius.licenta.backend.dto.normal.board.request.CreateBoardDto;
import darius.licenta.backend.dto.normal.board.response.BoardSearchResponseDto;
import darius.licenta.backend.dto.normal.board.response.fulldetails.FullBoardDetailsDto;
import darius.licenta.backend.dto.normal.board.request.UpdateBoardDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BoardMapper {


    Board fullBoardDetailsDtoToBoard(FullBoardDetailsDto fullBoardDetailsDto);

    FullBoardDetailsDto boardToFullBoardDetailsDto(Board board);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBoardFromFullBoardDetailsDto(FullBoardDetailsDto fullBoardDetailsDto, @MappingTarget Board board);

    Board updateBoardDtoToBoard(UpdateBoardDto updateBoardDto);

    UpdateBoardDto boardToUpdateBoardDto(Board board);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBoardFromUpdateBoardDto(UpdateBoardDto updateBoardDto, @MappingTarget Board board);

    Board boardSearchResponseDtoToBoard(BoardSearchResponseDto boardSearchResponseDto);

    BoardSearchResponseDto boardToBoardSearchResponseDto(Board board);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBoardFromBoardSearchResponseDto(BoardSearchResponseDto boardSearchResponseDto, @MappingTarget Board board);

    Board createBoardDtoToBoard(CreateBoardDto createBoardDto);

    CreateBoardDto boardToCreateBoardDto(Board board);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBoardFromCreateBoardDto(CreateBoardDto createBoardDto, @MappingTarget Board board);
}
