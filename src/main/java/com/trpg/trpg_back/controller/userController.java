package com.trpg.trpg_back.controller;


import com.trpg.trpg_back.entity.user;
import com.trpg.trpg_back.service.userService;
import jakarta.annotation.Resource;
import org.apache.catalina.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@Configuration
@RequestMapping({"/account"})
public class userController {
    @Resource
    userService userService;

    @PostMapping({"/signup"})
    public ResponseEntity signUp (@RequestBody user user) throws Exception {
        HttpHeaders resHeader = new HttpHeaders();
        //회원 가입 여부 성공
        user.setUseYn("Y");

        resHeader.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
    }
    @GetMapping({"/signIn"})
    public ResponseEntity signIn (@RequestParam(value = "userId") String userId, @RequestParam(value = "userPw") String userPw) throws Exception {
        HttpHeaders resHeader = new HttpHeaders();
        //유저 entity 세팅
        user user = new user();
        user.setUserId(userId);
        user.setUserPw(userPw);

        resHeader.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity<>(userService.signIn(user), HttpStatus.OK);
    }
}
