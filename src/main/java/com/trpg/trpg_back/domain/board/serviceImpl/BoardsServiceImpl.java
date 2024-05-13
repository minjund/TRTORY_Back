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

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardsServiceImpl {
    private static Boards boards = new Boards();

    private final BoardsRepository boardsRepository;

    @Transactional
    public Long saveBoards(BoardsRequest boardsRequest) {
        boards.createBoard(boardsRequest.getBoardTitle(),
                boardsRequest.getBoardContents(),
                BoardsType.NEW,
                boardsRequest.getWriterId());

        boards = boardsRepository.save(boards);

        return boards.getBoardId();
    }

    @Transactional
    public Long updateBoard(BoardsRequest boardsRequest) {
        Boards boards = boardsRepository.findById(boardsRequest.getBoardId())
                .orElseThrow(NoSearchBoardsException::new);

        boards.updateBoard(
                boardsRequest.getBoardTitle(),
                boardsRequest.getBoardContents(),
                boardsRequest.getBoardType(),
                boardsRequest.getWriterId()
        );

        return boards.getBoardId();
    }

    public List<BoardsResponse> searchBoards(Long boardId) {
        List<Boards> boards;

        if(boardId == null){
            boards = boardsRepository.findAll();
        } else {
            boards = boardsRepository.findAllById(Collections.singleton(boardId));
        }

        return boards.stream()
                .map(BoardsResponse::new)
                .toList();
    }

    public BoardsType[] boardsTypeList() {
        return boards.boardsTypeList();
    }
}
