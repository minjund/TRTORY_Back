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
        private String user_id;
        private String user_pw;
        private String user_discord_id;
        private String user_nickname;
        private String use_yn;


}
