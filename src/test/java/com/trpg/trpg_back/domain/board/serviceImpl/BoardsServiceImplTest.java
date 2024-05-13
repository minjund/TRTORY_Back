package com.trpg.trpg_back.domain.board.serviceImpl;

import com.trpg.trpg_back.domain.board.dto.BoardsRequest;
import com.trpg.trpg_back.domain.board.dto.BoardsResponse;
import com.trpg.trpg_back.domain.board.entity.BoardsType;
import com.trpg.trpg_back.domain.board.exception.NoSearchBoardsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional(noRollbackFor = Exception.class)
class BoardsServiceImplTest {

    @Autowired
    private BoardsServiceImpl boardsServiceImpl;

    @Test
    @DisplayName("게시판 생성 테스트")
    @Rollback(value = false)
    void insertDbBoards() {
        //given
        BoardsRequest boardsRequest = new BoardsRequest();
        boardsRequest.setBoardTitle("신나는모험");
        boardsRequest.setBoardContents("가나나다다라");
        boardsRequest.setBoardType(BoardsType.NEW);
        boardsRequest.setWriterId(1);

        //when
        Long saveBoardsId = boardsServiceImpl.saveBoards(boardsRequest);

        //then
        assertEquals(0, saveBoardsId);
    }

    @Test
    @DisplayName("게시판 업데이트 실패 - 게시글을 찾을 수 없음")
    void updateDbFailBoards() {
        //given
        BoardsRequest boardsRequest = new BoardsRequest();
        boardsRequest.setBoardId(100L);
        boardsRequest.setBoardTitle("신나는모험");
        boardsRequest.setBoardContents("나나나");
        boardsRequest.setBoardType(BoardsType.NOTICE);
        boardsRequest.setWriterId(1);

        //when
        NoSearchBoardsException nosb = assertThrows(NoSearchBoardsException.class, () -> boardsServiceImpl.updateBoard(boardsRequest));

        //then
        assertEquals("검색된 게시글이 없습니다.", nosb.getMessage());
    }

    @Test
    @DisplayName("게시판 업데이트 성공")
    @Rollback(value = false)
    void updateDbBoards() {
        //given
        BoardsRequest boardsRequest = new BoardsRequest();
        boardsRequest.setBoardId(2L);
        boardsRequest.setBoardTitle("신나는모험");
        boardsRequest.setBoardContents("나나나");
        boardsRequest.setBoardType(BoardsType.NOTICE);

        //when
        //저장 후 업데이트
        Long updateBoardId = boardsServiceImpl.updateBoard(boardsRequest);

        //then
        assertEquals(boardsRequest.getBoardId(), updateBoardId);
    }
}