package com.trpg.trpg_back.domain.board.serviceImpl;


import com.trpg.trpg_back.domain.board.dao.BoardsRepository;
import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.entity.Boards;
import com.trpg.trpg_back.domain.board.entity.BoardsType;
import com.trpg.trpg_back.domain.board.exception.NoSearchBoardsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardsServiceImpl {

    private final BoardsRepository boardsRepository;

    @Transactional
    public BoardsResponse saveBoards(BoardsRequest boardsRequest) {

        Boards boards = new Boards();

        boards.createBoard(boardsRequest.getBoardTitle(),
                boardsRequest.getBoardContents(),
                BoardsType.DEFAULT,
                boardsRequest.getWriterId());

        boards = boardsRepository.save(boards);

        return new BoardsResponse(boards.getBoardId());
    }

    @Transactional
    public BoardsResponse updateBoard(BoardsRequest boardsRequest) {
        Boards boards = boardsRepository.findById(boardsRequest.getBoardId())
                .orElseThrow(NoSearchBoardsException::new);

        boards.updateBoard(
                boardsRequest.getBoardTitle(),
                boardsRequest.getBoardContents(),
                boardsRequest.getBoardType(),
                boardsRequest.getWriterId()
        );

        return new BoardsResponse(boards.getBoardId());
    }

}
