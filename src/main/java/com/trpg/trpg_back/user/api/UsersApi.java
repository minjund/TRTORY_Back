package com.trpg.trpg_back.user.api;


import com.trpg.trpg_back.user.entity.Users;
import com.trpg.trpg_back.user.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/account"})
@RequiredArgsConstructor
public class UsersApi {

    final UserServiceImpl userService;

    @PostMapping({"/signup"})
    public ResponseEntity signUp (@RequestBody Users user) throws Exception {
        HttpHeaders resHeader = new HttpHeaders();
        //회원 가입 여부 성공


        resHeader.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
    }
    @GetMapping({"/signIn"})
    public ResponseEntity signIn (@RequestParam(value = "userId") String userId, @RequestParam(value = "userPw") String userPw) throws Exception {
        HttpHeaders resHeader = new HttpHeaders();
        //유저 entity 세팅
        Users user = new Users();

        resHeader.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity<>(userService.signIn(user), HttpStatus.OK);
    }
}
