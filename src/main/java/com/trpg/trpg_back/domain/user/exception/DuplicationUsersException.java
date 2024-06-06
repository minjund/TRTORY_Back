package com.trpg.trpg_back.domain.user.exception;

public class DuplicationUsersException extends UsersException {

    public DuplicationUsersException() {
        super("중복된 Id가 있습니다.");
    }
}
