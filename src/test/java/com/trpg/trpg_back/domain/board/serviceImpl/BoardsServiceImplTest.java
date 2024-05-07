package com.trpg.trpg_back.domain.board.serviceImpl;

import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.entity.Boards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional(noRollbackFor = Exception.class)
class BoardsServiceImplTest {

    @Autowired
    private BoardsServiceImpl boardsServiceImpl;

    @Test
    @DisplayName("게시판 생성 테스트")
    void saveBoards() {
        //given
        BoardsRequest boardsRequest = new BoardsRequest();
        boardsRequest.setBoard_title("신나는모험");
        boardsRequest.setBoard_contents("가나나다다라");
        boardsRequest.setBoard_type("일반");
        boardsRequest.setWriter_id("minjun");

        //when
        BoardsResponse boardsResponse = boardsServiceImpl.saveBoards(boardsRequest);

        //then
        assertEquals(boardsRequest.getBoard_title(), boardsResponse.getBoard_title());
        assertEquals(boardsRequest.getBoard_contents(), boardsResponse.getBoard_contents());
        assertEquals(boardsRequest.getBoard_type(), boardsResponse.getBoard_type());
        assertEquals(boardsRequest.getWriter_id(), boardsResponse.getWriter_id());
        assertEquals("Y", boardsResponse.getUse_yn());
    }
}