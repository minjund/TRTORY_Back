package com.trpg.trpg_back.domain.user.entity;

import com.trpg.trpg_back.domain.user.dto.UsersRequest;
import com.trpg.trpg_back.global.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@RedisHash(value = "users", timeToLive = 300)
public class RedisUsers extends BaseEntity {

    @Id
    private long userSeq;
    private String userEmail;
    private String userPassword;
    private String userDiscordId;
    private String userNickname;
    private String useYn;

    public void createUser(UsersRequest usersRequest) {
        this.userSeq = usersRequest.getSeq();
        this.userEmail = usersRequest.getUserEmail();
        this.userPassword = passwordEncrypt(usersRequest.getUserPassword());
        this.userDiscordId = usersRequest.getUserDiscordId();
        this.userNickname = usersRequest.getUserNickname();
        this.useYn = "Y";
    }

    //password bcrypt로 암호화
    public String passwordEncrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

}
