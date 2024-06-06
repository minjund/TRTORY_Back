package com.trpg.trpg_back.domain.user.exception;

public class TokenExpiredException extends UsersException {

        public TokenExpiredException() {
            super("토큰이 만료되었습니다. 다시 로그인 해주세요.");
        }
}
