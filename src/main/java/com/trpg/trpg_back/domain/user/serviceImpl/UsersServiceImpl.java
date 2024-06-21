package com.trpg.trpg_back.domain.user.serviceImpl;

import com.trpg.trpg_back.domain.user.dao.jpa.UsersRepository;
import com.trpg.trpg_back.domain.user.dto.UsersRequest;
import com.trpg.trpg_back.domain.user.entity.Users;
import com.trpg.trpg_back.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl {
    private static final Users users = new Users();
    private final UsersRepository userRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public Long signup(UsersRequest usersRequest) {

        users.createUser(usersRequest);
        Users userSaveInfo = userRepository.save(users);

        return userSaveInfo.getUserSeq();
    }

    public Map<String, String> getLoginAccessRefreshToken(String userId, String userPw) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, userPw));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userId);

        final String accessToken = jwtUtil.generateToken(userDetails.getUsername(), 15 * 60 * 1000);
        final String refreshToken = jwtUtil.generateToken(userDetails.getUsername(), 30 * 24 * 60 * 1000);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);

        return tokens;
    }

    public Map<String, String> reissuanceAccessToken(Map<String, String> request) throws Exception {
        String refreshToken = request.get("refresh_token");

        if (jwtUtil.isTokenExpired(refreshToken)) {
            throw new Exception("토큰이 만료되었습니다. 다시 로그인 해주세요.");
        }

        final String username = jwtUtil.extractClaims(refreshToken).getSubject();
        final String newAccessToken = jwtUtil.generateToken(username, 15 * 60 * 1000);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", newAccessToken);
        tokens.put("refresh_token", refreshToken);

        return tokens;
    }
}


