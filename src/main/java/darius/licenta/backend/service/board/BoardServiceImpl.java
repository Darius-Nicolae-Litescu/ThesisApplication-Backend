package darius.licenta.backend.service.board;

import darius.licenta.backend.domain.sql.User;
import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.domain.sql.kanban.Board;
import darius.licenta.backend.domain.sql.kanban.Card;
import darius.licenta.backend.domain.sql.kanban.ColumnList;
import darius.licenta.backend.dto.normal.board.request.CreateBoardDto;
import darius.licenta.backend.dto.normal.board.request.UpdateBoardDto;
import darius.licenta.backend.dto.normal.board.response.BoardSearchResponseDto;
import darius.licenta.backend.dto.normal.board.response.fulldetails.FullBoardDetailsDto;
import darius.licenta.backend.mapper.normal.board.BoardMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    private final BoardRepository boardRepository;
    private final ColumnListRepository columnListRepository;
    private final CardRepository cardRepository;
    private final StoryRepository storyRepository;
    private final UserRepository userRepository;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper, BoardRepository boardRepository, ColumnListRepository columnListRepository, CardRepository cardRepository, StoryRepository storyRepository, UserRepository userRepository) {
        this.boardMapper = boardMapper;
        this.boardRepository = boardRepository;
        this.columnListRepository = columnListRepository;
        this.cardRepository = cardRepository;
        this.storyRepository = storyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApiResponse<FullBoardDetailsDto> getFullDetailsByBoardId(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        FullBoardDetailsDto fullBoardDetailsDto = boardMapper.boardToFullBoardDetailsDto(board);
        return new ApiResponse<>(fullBoardDetailsDto, HttpStatus.OK);
    }

    @Transactional
    @Override
    public ApiResponse<FullBoardDetailsDto> updateBoardDetails(String username, UpdateBoardDto updateBoardDto) {

        User user = userRepository.findByUsername(username).orElseThrow(ResourceNotFoundException::new);

        if (!user.getUserRoles().contains(UserRole.BOARD_ADMIN)) {
            return new ApiResponse<>("Username '" + username + "' is not authorized to move cards", null, HttpStatus.UNAUTHORIZED);
        }
        updateBoardDto.getColumnList().forEach(columnListDto -> {
            columnListRepository.updateColumnList(columnListDto.getTitle(), columnListDto.getColumnOrder(), columnListDto.getId());
            columnListDto.getCards().forEach(cardDto -> {
                cardRepository.updateCardInformation(columnListDto.getId(), cardDto.getRank(), cardDto.getId());
            });
        });

        Board board = boardRepository.findById(updateBoardDto.getId()).orElseThrow(ResourceNotFoundException::new);
        FullBoardDetailsDto fullBoardDetailsDto = boardMapper.boardToFullBoardDetailsDto(board);
        return new ApiResponse<>(fullBoardDetailsDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<BoardSearchResponseDto>> getAllBoards() {
        List<BoardSearchResponseDto> boardList = boardRepository.getAllBoards();
        return new ApiResponse<>(boardList, HttpStatus.OK);
    }

    @Transactional
    @Override
    public ApiResponse<Boolean> addAllStoriesToBoard(Long boardId) {
        List<ColumnList> boardColumnList = columnListRepository.findByBoard_Id(boardId);
        if (!CollectionUtils.isEmpty(boardColumnList)) {
            ColumnList columnList = boardColumnList.get(0);
            List<Long> storiesIds = storyRepository.getAllStoryIds();
            List<Card> cards = new ArrayList<>();
            storiesIds.forEach(storyId -> {
                Card card = new Card();
                card.setRank(new BigDecimal(0));
                card.setColumnList(columnList);
                card.setStory(storyRepository.findById(storyId).orElseThrow(ResourceNotFoundException::new));
                cards.add(card);
            });
            cardRepository.saveAll(cards);
            return new ApiResponse<>(true, HttpStatus.OK);
        }
        return new ApiResponse<>("No column list found for board", false, HttpStatus.OK);
    }

    @Override
    public ApiResponse<FullBoardDetailsDto> createBoard(CreateBoardDto createBoardDto) {
        Board board = boardMapper.createBoardDtoToBoard(createBoardDto);
        for (ColumnList columnList : board.getColumnList()) {
            columnList.setBoard(board);
        }
        board = boardRepository.save(board);
        FullBoardDetailsDto fullBoardDetailsDto = boardMapper.boardToFullBoardDetailsDto(board);
        return new ApiResponse<>(fullBoardDetailsDto, HttpStatus.OK);
    }


}
