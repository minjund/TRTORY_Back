package com.trpg.trpg_back.controller;


import com.trpg.trpg_back.entity.user;
import com.trpg.trpg_back.service.userService;
import jakarta.annotation.Resource;
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
    public ResponseEntity signUp (ModelMap model, @RequestBody user user) throws Exception {
        HttpHeaders resHeader = new HttpHeaders();
        user.setUse_yn("Y");
        resHeader.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
    }


    // 모든 회원 조회
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE },path = {"/findAll"})
    public ResponseEntity<List<user>> getAllUsers() {
        List<user> member = userService.findAll();
        return new ResponseEntity<List<user>>(member, HttpStatus.OK);
    }
}
