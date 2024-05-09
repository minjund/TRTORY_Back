package com.trpg.trpg_back.domain.board.entity;

import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardsTest {
    @Test
    @DisplayName("게시판 생성")
    public void testCreateBoard() {
        //given
        Boards boards = new Boards();

        BoardsRequest boardsRequest = new BoardsRequest();
        boardsRequest.setBoardTitle("신나는모험");
        boardsRequest.setBoardContents("가나나다다라");
        boardsRequest.setWriterId(1);

        //when
        boards.createBoard(boardsRequest.getBoardTitle(), boardsRequest.getBoardContents(), BoardsType.DEFAULT, boardsRequest.getWriterId());

        //then
        assertEquals(boardsRequest.getBoardTitle(), boards.getBoardTitle());
        assertEquals(boardsRequest.getBoardContents(), boards.getBoardContents());
        assertEquals(boardsRequest.getBoardType().name(), boards.getBoardType());
        assertEquals(boardsRequest.getWriterId(), boards.getWriterId());
        assertEquals("Y", boards.getUseYn());
    }
}