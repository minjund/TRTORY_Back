package com.trpg.trpg_back.domain.board.entity;

public enum BoardsType {
    DEFAULT(0), NOTICE(1);

    private final int type;

    BoardsType(int type) {
        this.type = type;
    }
}
