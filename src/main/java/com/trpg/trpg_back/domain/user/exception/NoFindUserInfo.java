package com.trpg.trpg_back.domain.user.exception;

public class NoFindUserInfo extends UsersException {
    public NoFindUserInfo(String userId) {
        super("해당 유저 정보를 찾을 수 없습니다. (userId: " + userId + ")");
    }
}
