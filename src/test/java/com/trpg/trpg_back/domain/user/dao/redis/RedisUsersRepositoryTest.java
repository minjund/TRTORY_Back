package com.trpg.trpg_back.domain.user.dao.redis;

import com.trpg.trpg_back.domain.user.dao.jpa.UsersRepository;
import com.trpg.trpg_back.domain.user.dto.UsersRequest;
import com.trpg.trpg_back.domain.user.entity.RedisUsers;
import com.trpg.trpg_back.domain.user.entity.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RedisUsersRepositoryTest {


    @Autowired
    private RedisUsersRepository usersRepository;

    @Test
    @DisplayName("레디스 유저 등록 테스트")
    void save() {
        // given
        UsersRequest usersRequest = new UsersRequest();
        RedisUsers users = new RedisUsers();
        usersRequest.setSeq(2L);
        usersRequest.setUserEmail("testId");
        usersRequest.setUserPassword("testPw");
        usersRequest.setUserNickname("testNickname");

        // when
        users.createUser(usersRequest);
        RedisUsers save = usersRepository.save(users);

        // then
        assertEquals(users.getUserNickname(), save.getUserNickname());
    }
}