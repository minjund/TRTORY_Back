package com.trpg.trpg_back.domain.board.api;

import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.entity.Boards;
import com.trpg.trpg_back.domain.board.serviceImpl.BoardsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardsApi {

    private final BoardsServiceImpl boardsServiceImpl;

    @PostMapping("/create-board")
    public void createBoard(@RequestBody BoardsRequest boardsRequest) {

        BoardsResponse saveBoardId = boardsServiceImpl.saveBoards(boardsRequest);

        System.out.println(saveBoardId.getBoard_id());

    }

    @PutMapping("/update-board")
    public void updateBoard(@RequestBody BoardsRequest boardsRequest) {

        BoardsResponse updateBoard = boardsServiceImpl.updateBoard(boardsRequest);

        System.out.println(updateBoard.getBoard_id());

    }

}
