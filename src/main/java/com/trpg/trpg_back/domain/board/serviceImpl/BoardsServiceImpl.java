package com.trpg.trpg_back.domain.board.serviceImpl;


import com.trpg.trpg_back.domain.board.dao.BoardsRepository;
import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.entity.Boards;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardsServiceImpl {
    private final BoardsRepository boardsRepository;


    @Transactional
    public BoardsResponse saveBoards(BoardsRequest boardsRequest) {

        Boards boards = Boards.createBoard(boardsRequest.getBoard_title(),
                boardsRequest.getBoard_contents(),
                boardsRequest.getBoard_type(),
                boardsRequest.getWriter_id());

        Boards save = boardsRepository.save(boards);

        return new BoardsResponse(save.getBoard_id());
    }

}
