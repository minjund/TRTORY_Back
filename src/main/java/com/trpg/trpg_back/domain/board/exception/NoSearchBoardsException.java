package com.trpg.trpg_back.domain.board.exception;

public class NoSearchBoardsException extends BoardsException {
    public NoSearchBoardsException() {
        super("검색된 게시글이 없습니다.");
    }
}
