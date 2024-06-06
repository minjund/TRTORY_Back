package com.trpg.trpg_back.domain.user.dto;

import lombok.Data;

@Data
public class UsersRequest {
    private long seq;
    private String userNickname;
    private String userPassword;
    private String userEmail;
    private String userDiscordId;
    private String userComment;
    private String userImage;

}
