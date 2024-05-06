package com.trpg.trpg_back.user.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name="user")
public class Users {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long seq;

        private String userId;

        private String userPw;

        private String userDiscordId;

        private String userNickname;

        private String useYn;


}
