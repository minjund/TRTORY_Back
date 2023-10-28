package com.trpg.trpg_back.service;

import com.trpg.trpg_back.entity.user;
import com.trpg.trpg_back.repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class userService {
    @Autowired
    private userRepository userRepository;
    public int signup(user user) {
        try {
            userRepository.save(user);
            return 100 ; // 리턴되는 값 json으로 값 넘겼을 때 보여지는 부분 user.js에 콘솔창 결과값나옴
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("userservice " + e.getMessage());
        }
        return -100;
    }

    public List signIn(user user) {
        try {
            List userInfo = userRepository.findByUserIdAndUserPw(user.getUserId(),user.getUserPw());
            return userInfo ; // 리턴되는 값 json으로 값 넘겼을 때 보여지는 부분 user.js에 콘솔창 결과값나옴
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("userservice " + e.getMessage());
        }
        return Collections.singletonList(-100);
    }

}
