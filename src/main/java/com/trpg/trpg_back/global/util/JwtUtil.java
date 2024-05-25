package com.trpg.trpg_back.global.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final String secret = "szsSecretKey";
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    // 토큰 생성
    public String generateToken(String userId, long expirationTime) {
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public Map<String, String> getLoginAccessRefreshToken(String userId, String userPw) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, userPw));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userId);

        final String accessToken = this.generateToken(userDetails.getUsername(), 15 * 60 * 1000);
        final String refreshToken = this.generateToken(userDetails.getUsername(), 30 * 24 * 60 * 1000);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);
        return tokens;
    }

    public Map<String, String> reissuanceAccessToken(Map<String, String> request) throws Exception {
        String refreshToken = request.get("refresh_token");

        if (this.isTokenExpired(refreshToken)) {
            throw new Exception("토큰이 만료되었습니다. 다시 로그인 해주세요.");
        }

        final String username = this.extractClaims(refreshToken).getSubject();
        final String newAccessToken = this.generateToken(username, 15 * 60 * 1000);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", newAccessToken);
        tokens.put("refresh_token", refreshToken);

        return tokens;
    }
}
