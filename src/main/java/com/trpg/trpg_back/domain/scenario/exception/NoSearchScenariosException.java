package com.trpg.trpg_back.domain.scenario.exception;

public class NoSearchScenariosException extends ScenariosException {
    public NoSearchScenariosException() {
        super("검색된 게시글이 없습니다.");
    }
}
