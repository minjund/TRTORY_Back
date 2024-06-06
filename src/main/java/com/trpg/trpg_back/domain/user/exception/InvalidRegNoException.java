package com.trpg.trpg_back.domain.user.exception;
public class InvalidRegNoException extends UsersException{

    public InvalidRegNoException() {
        super("주민등록번호 형식이 올바르지 않습니다.");
    }
}
