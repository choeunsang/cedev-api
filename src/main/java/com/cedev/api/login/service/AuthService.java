package com.cedev.api.login.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.cedev.api.login.mapper.AuthMapper;
import com.cedev.api.member.dto.UserDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthService {

    private final AuthMapper authMapper;

    // -------------------------------------------------------------------------------------------
    // JWT 설정 변수 선언 (비밀키는 최소 32바이트 이상의 문자열이어야 합니다)
    // -------------------------------------------------------------------------------------------
    private final String SECRET_STRING = "your-very-long-and-secure-secret-key-that-is-at-least-32-bytes-long";
    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 2; // 토큰 유효 시간: 2시간

    public AuthService(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }
    
    //-------------------------------------------------------------------------------------------
    // 로그인
    //-------------------------------------------------------------------------------------------    
    public Map<String, Object> DoLogin(String userId, String userPw) {
    	
        Map<String, Object> resultMap = new HashMap<>();
        
        //-------------------------------------------------------------------------------------------
        // (1).ID 존재 여부 확인
        //-------------------------------------------------------------------------------------------        
        int idCnt = authMapper.chkExistId(userId);
        
        if (idCnt == 0)
        {
            resultMap.put("success", false);
            resultMap.put("message", "ID가 존재하지 않습니다.");

            return resultMap;
        }

        //-------------------------------------------------------------------------------------------
        // (2).PW 확인
        //-------------------------------------------------------------------------------------------
        List<UserDto> list = authMapper.chkPw(userId, userPw);

        if (list.size() == 0)
        {
            resultMap.put("success", false);
            resultMap.put("message", "비밀번호가 일치하지 않습니다.");

            return resultMap;
        }

        //-------------------------------------------------------------------------------------------
        // [수정] 로그인 성공 - JWT 토큰 발급 로직 추가
        //-------------------------------------------------------------------------------------------
        UserDto user = list.get(0);
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        // JJWT 0.12.x 최신 표준 빌더 패턴 사용
        String jwtToken = Jwts.builder()
                .subject(user.getUserId())                           // 토큰 식별자 (ID)
                .claim("userName", user.getUserName())               // 필요한 회원 정보 클레임 추가
                .issuedAt(now)                                       // 발급 시간
                .expiration(expiryDate)                              // 만료 시간
                .signWith(SECRET_KEY)                                // 서명 키 설정
                .compact();

        // 결과 맵에 사용자 정보와 토큰 저장
        resultMap.put("success", true);
        resultMap.put("message", "로그인 성공");
        resultMap.put("user", user);
        resultMap.put("token", jwtToken); // 👈 컨트롤러에서 받아 처리할 토큰
        
        return resultMap;
    }
    
    //-------------------------------------------------------------------------------------------
    // DoLogin01
    //-------------------------------------------------------------------------------------------    
    public Map<String, Object> DoLogin01(String userId, String userPw) {
    	
        Map<String, Object> resultMap = new HashMap<>();
        
        int idCnt = authMapper.chkExistId(userId);
        
        if (idCnt == 0)
        {
            resultMap.put("success", false);
            resultMap.put("message", "ID가 존재하지 않습니다.");

            return resultMap;
        }

        resultMap.put("success", true);
        resultMap.put("message", "로그인 성공");
        
        return resultMap;
    }    
    
    //-------------------------------------------------------------------------------------------
    // DoLogin02
    //-------------------------------------------------------------------------------------------    
    public Map<String, Object> DoLogin02(String userId, String userPw) {
    	
        Map<String, Object> resultMap = new HashMap<>();
        
        int idCnt = authMapper.chkExistId(userId);
        
        if (idCnt == 0)
        {
            resultMap.put("success", false);
            resultMap.put("message", "ID가 존재하지 않습니다.");

            return resultMap;
        }

        List<UserDto> list = authMapper.chkPw(userId, userPw);

        if (list.size() == 0)
        {
            resultMap.put("success", false);
            resultMap.put("message", "비밀번호가 일치하지 않습니다.");

            return resultMap;
        }

        resultMap.put("success", true);
        resultMap.put("message", "로그인 성공");
        
        return resultMap;
    }      
}
