package com.trpg.trpg_back.domain.user.api;


import com.trpg.trpg_back.domain.user.dao.UsersRepository;
import com.trpg.trpg_back.domain.user.dto.UsersRequest;
import com.trpg.trpg_back.domain.user.entity.Users;
import com.trpg.trpg_back.domain.user.serviceImpl.UsersServiceImpl;
import com.trpg.trpg_back.global.comm.responseData.ResponseData;
import com.trpg.trpg_back.global.comm.responseData.ResponseDataCode;
import com.trpg.trpg_back.global.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping({"/api/vi/users"})
@RequiredArgsConstructor
public class UsersApi {

    private final UsersServiceImpl usersServiceImpl;


    private final JwtUtil jwtUtil;


    private final UsersRepository usersRepository;


    @PostMapping({"/signup"})
    public ResponseEntity<ResponseData<Map<String, String>>> signUp (@RequestBody UsersRequest usersRequest) throws Exception {

        //회원 가입 여부
        ResponseData<Map<String, String>> responseDataDTO = new ResponseData<>();

        Map<String, String> accessToken = usersServiceImpl.signup(usersRequest);

        if (!accessToken.isEmpty()) {
            responseDataDTO.setCode(ResponseDataCode.SUCCESS.getCode());
            responseDataDTO.setMessage("회원가입 성공");
        } else {
            responseDataDTO.setCode(ResponseDataCode.BAD.getCode());
            responseDataDTO.setMessage("회원가입 실패");
        }

        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }
    @GetMapping({"/signIn"})
    public ResponseEntity<ResponseData<Map<String, String>>> signIn (@RequestParam(value = "userId") String userId, @RequestParam(value = "userPw") String userPw) throws Exception {
        ResponseData<Map<String, String>> responseDataDTO = new ResponseData<>();

        Map<String, String> tokens = jwtUtil.getLoginAccessRefreshToken(userId, userPw);

        responseDataDTO.setCode(ResponseDataCode.SUCCESS.getCode());
        responseDataDTO.setMessage("로그인 토큰 발급 성공");
        responseDataDTO.setItem(tokens);

        //유저 entity 세팅
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<ResponseData<Map<String, String>>> refresh(@RequestBody Map<String, String> request) throws Exception {
         ResponseData<Map<String, String>> responseDataDTO = new ResponseData<>();

        Map<String, String> accessAndReFreshToken = jwtUtil.reissuanceAccessToken(request);

        responseDataDTO.setCode(ResponseDataCode.SUCCESS.getCode());
        responseDataDTO.setMessage("토큰 재발급 성공");
        responseDataDTO.setItem(accessAndReFreshToken);

        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);


    }
    // 수정 전
//    @GetMapping("/userinfo")
//    public Map<String, String> getUserInfo(HttpServletRequest request) {
//        String authorization = request.getHeader("Authorization");
//        String jwt = authorization.substring(7);
//        String username = jwtUtil.extractUsername(jwt);
//        Users user = usersRepository.findByUserNickname(username);
//
//        Map<String, String> userInfo = new HashMap<>();
//        userInfo.put("username", user.getUserNickname());
//
//        return userInfo;
//    }
}
