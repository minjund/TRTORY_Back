package com.trpg.trpg_back.domain.user.serviceImpl;

import com.trpg.trpg_back.domain.user.dao.UsersRepository;
import com.trpg.trpg_back.domain.user.dto.UsersRequest;
import com.trpg.trpg_back.domain.user.entity.Users;
import com.trpg.trpg_back.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl {
    private static final Users users = new Users();
    private final UsersRepository userRepository;
    private final JwtUtil jwtUtil;


    public Map<String, String> signup(UsersRequest usersRequest) {

        users.createUser(usersRequest);
        Users userSaveInfo = userRepository.save(users);

        return jwtUtil.getLoginAccessRefreshToken(userSaveInfo.getUserNickname(), userSaveInfo.getUserPassword());
    }
}
