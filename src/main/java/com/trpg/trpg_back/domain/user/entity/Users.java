package com.trpg.trpg_back.domain.user.entity;

import com.trpg.trpg_back.global.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name="user")
public class Users extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long userSeq;

        @Column(name = "email", columnDefinition = "varchar(255)", nullable = true)
        private String email;

        @Column(name = "user_pw", columnDefinition = "varchar(255)", nullable = true)
        private String userPw;

        @Column(name = "user_discord_id", columnDefinition = "varchar(255)", nullable = true)
        private String userDiscordId;

        @Column(name = "user_nickname", columnDefinition = "varchar(45)", nullable = false)
        private String userNickname;

        @Column(name = "use_yn", columnDefinition = "varchar(45)", nullable = false)
        private String useYn;

        @Column(name = "nick_name", columnDefinition = "varchar(255)", nullable = true)
        private String nickName;

}
