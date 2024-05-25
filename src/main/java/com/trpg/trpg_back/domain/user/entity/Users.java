package com.trpg.trpg_back.domain.user.entity;

import com.trpg.trpg_back.domain.scenario.dto.ScenariosRequest;
import com.trpg.trpg_back.domain.user.dao.UsersRepository;
import com.trpg.trpg_back.domain.user.dto.UsersRequest;
import com.trpg.trpg_back.global.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Getter
@Table(name="user")
public class Users extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long userSeq;

        @Column(name = "user_email", columnDefinition = "varchar(255)", nullable = true)
        private String userEmail;

        @Column(name = "user_password", columnDefinition = "varchar(255)", nullable = true)
        private String userPassword;

        @Column(name = "user_discord_id", columnDefinition = "varchar(255)", nullable = true)
        private String userDiscordId;

        @Column(name = "user_nickname", columnDefinition = "varchar(45)", nullable = false)
        private String userNickname;

        @Column(name = "use_yn", columnDefinition = "varchar(45)", nullable = false)
        private String useYn;

        public void createUser(UsersRequest usersRequest) {
                this.userEmail = usersRequest.getUserEmail();
                this.userPassword = passwordEncrypt(usersRequest.getUserPassword());

                this.useYn = "Y";
                this.useYn = "Y";
        }

        //password bcrypt로 암호화
        public String passwordEncrypt(String password) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            return passwordEncoder.encode(password);
        }

}
