package com.trpg.trpg_back.domain.user.api;


import com.trpg.trpg_back.domain.user.dto.UsersRequest;
import com.trpg.trpg_back.domain.user.serviceImpl.UsersServiceImpl;
import com.trpg.trpg_back.global.comm.responseData.ResponseData;
import com.trpg.trpg_back.global.comm.responseData.ResponseDataCode;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping({"/api/v1/users"})
@SecurityRequirement(name = "Authorization")
@RequiredArgsConstructor
public class UsersApi {

    private final UsersServiceImpl usersServiceImpl;

    @PostMapping({"/signup"})
    public ResponseEntity<?> signUp (@RequestBody UsersRequest usersRequest) {

        Long signupId = usersServiceImpl.signup(usersRequest);
        return new ResponseEntity<>(signupId,HttpStatus.OK);
    }
    @GetMapping({"/signIn"})
    public ResponseEntity<?> signIn (@RequestParam(value = "userId") String userId, @RequestParam(value = "userPw") String userPw) throws Exception {
        Map<String, String> loginAccessRefreshToken = usersServiceImpl.getLoginAccessRefreshToken(userId, userPw);
        return new ResponseEntity<>(loginAccessRefreshToken, HttpStatus.OK);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> request) throws Exception {
        Map<String, String> accessAndReFreshToken = usersServiceImpl.reissuanceAccessToken(request);

        return new ResponseEntity<>(accessAndReFreshToken, HttpStatus.OK);
    }
}
