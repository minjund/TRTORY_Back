package com.trpg.trpg_back.domain.board.api;

import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.entity.Boards;
import com.trpg.trpg_back.domain.board.serviceImpl.BoardsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardsApi {

    private final BoardsServiceImpl boardsServiceImpl;

    @PostMapping("/create-board")
    public void createBoard(@RequestBody BoardsRequest boardsRequest) {

        BoardsResponse saveBoardId = boardsServiceImpl.saveBoards(boardsRequest);

        System.out.println(saveBoardId.getBoard_id());

    }

}
