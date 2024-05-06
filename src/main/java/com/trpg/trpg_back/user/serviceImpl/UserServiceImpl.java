package com.trpg.trpg_back.user.serviceImpl;

import com.trpg.trpg_back.user.entity.Users;
import com.trpg.trpg_back.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    final UserRepository userRepository;

    public int signup(Users user) {
//        userRepository.save(user);
        return 100 ; // 리턴되는 값 json으로 값 넘겼을 때 보여지는 부분 user.js에 콘솔창 결과값나옴
    }

    public List signIn(Users user) {
        List userInfo = userRepository.findByUserIdAndUserPw(user.getUserId(),user.getUserPw());
        return userInfo ; // 리턴되는 값 json으로 값 넘겼을 때 보여지는 부분 user.js에 콘솔창 결과값나옴
    }

}
