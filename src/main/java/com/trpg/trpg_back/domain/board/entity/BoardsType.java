package com.trpg.trpg_back.domain.board.entity;

public enum BoardsType {
    ALL, NEW, POPULAR, RECOMMEND;

    private final String type;

    BoardsType() {
        this.type = name();
    }
}
