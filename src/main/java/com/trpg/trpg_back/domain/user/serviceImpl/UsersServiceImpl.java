package com.trpg.trpg_back.domain.user.serviceImpl;

import com.trpg.trpg_back.domain.user.dao.UsersRepository;
import com.trpg.trpg_back.domain.user.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl {

    final UsersRepository userRepository;

    public int signup(Users user) {
//        userRepository.save(user);
        return 100 ; // 리턴되는 값 json으로 값 넘겼을 때 보여지는 부분 user.js에 콘솔창 결과값나옴
    }
}
