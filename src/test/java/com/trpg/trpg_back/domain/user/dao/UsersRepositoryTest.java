package com.trpg.trpg_back.domain.user.dao;

import com.trpg.trpg_back.domain.user.dao.jpa.UsersRepository;
import com.trpg.trpg_back.domain.user.dto.UsersRequest;
import com.trpg.trpg_back.domain.user.entity.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    @DisplayName("유저 등록 테스트")
    void save() {
        // given
        UsersRequest usersRequest = new UsersRequest();
        Users users = new Users();
        usersRequest.setUserEmail("testId");
        usersRequest.setUserPassword("testPw");
        usersRequest.setUserNickname("testNickname");

        // when
        users.createUser(usersRequest);
        Users save = usersRepository.save(users);

        // then
        assertEquals(users.getUserNickname(), save.getUserNickname());
    }
}