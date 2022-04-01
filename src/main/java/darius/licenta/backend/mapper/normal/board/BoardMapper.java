package darius.licenta.backend.mapper.normal.board;

import darius.licenta.backend.domain.sql.kanban.Board;
import darius.licenta.backend.domain.sql.kanban.ColumnList;
import darius.licenta.backend.dto.normal.board.FullBoardDetailsDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BoardMapper {


    Board fullBoardDetailsDtoToBoard(FullBoardDetailsDto fullBoardDetailsDto);

    FullBoardDetailsDto boardToFullBoardDetailsDto(Board board);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBoardFromFullBoardDetailsDto(FullBoardDetailsDto fullBoardDetailsDto, @MappingTarget Board board);
}
