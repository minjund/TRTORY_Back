package com.trpg.trpg_back.domain.board.entity;

import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardsTest {
    @Test
    @DisplayName("게시판 생성")
    public void testCreateBoard() {

        //given
        BoardsRequest boardsRequest = new BoardsRequest();
        boardsRequest.setBoard_title("신나는모험");
        boardsRequest.setBoard_contents("가나나다다라");
        boardsRequest.setBoard_type("일반");
        boardsRequest.setWriter_id("minjun");

        //when
        Boards boards = Boards.createBoard(boardsRequest.getBoard_title(), boardsRequest.getBoard_contents(), boardsRequest.getBoard_type(), boardsRequest.getWriter_id());

        //then
        assertEquals(boardsRequest.getBoard_title(), boards.getBoard_title());
        assertEquals(boardsRequest.getBoard_contents(), boards.getBoard_contents());
        assertEquals(boardsRequest.getBoard_type(), boards.getBoard_type());
        assertEquals(boardsRequest.getWriter_id(), boards.getWriter_id());
        assertEquals("Y", boards.getUse_yn());
    }
}