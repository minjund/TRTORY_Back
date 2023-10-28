package com.trpg.trpg_back.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(name="user")
public class user {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long seq;
        private String userId;
        private String userPw;
        private String userDiscordId;
        private String userNickname;
        private String useYn;


}
