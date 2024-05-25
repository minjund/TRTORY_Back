package com.trpg.trpg_back.domain.user.dto;

import lombok.Data;

@Data
public class UsersRequest {

    private String userNickname;
    private String userPassword;
    private String userEmail;
    private String userComment;
    private String userImage;

}
