package com.trpg.trpg_back.domain.board.exception;

public class BoardsException extends RuntimeException {

    protected BoardsException() {
        super();
    }

    protected BoardsException(String msg) {
        super(msg);
    }

    public BoardsException(String msg, Exception e) {
        super(msg, e);
    }

}
