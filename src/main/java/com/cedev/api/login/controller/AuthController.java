package com.cedev.api.login.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

import com.cedev.api.login.service.AuthService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
 // Spring Boot AuthController 내부 추가
    @GetMapping("/check-auth")
    public Map<String, Object> checkAuth(@CookieValue(name = "AUTH_TOKEN", required = false) String token) {
        Map<String, Object> resultMap = new HashMap<>();
        
        // 쿠키가 없거나 빈 값인 경우
        if (token == null || token.isEmpty()) {
            resultMap.put("success", false);
            resultMap.put("message", "인증 쿠키가 존재하지 않습니다.");
            return resultMap;
        }

        try {
            // AuthService에서 키를 가져와 검증 (유효시간, 변조 여부 등)
            // 토큰이 유효하면 정상 반환, 만료되거나 다르면 예외 발생
            // Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token);
            
            resultMap.put("success", true);
            resultMap.put("message", "인증된 사용자입니다.");
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("message", "만료되었거나 유효하지 않은 토큰입니다.");
        }

        return resultMap;
    }
    

    @PostMapping("/dologin")
    public Map<String, Object> Dologin(@RequestBody Map<String, String> param, HttpServletResponse response) {
        
        String userId = param.get("userId");
        String userPw = param.get("userPw");

        // 1. 서비스 호출을 통해 로그인 처리 및 토큰 발급 결과 수신
        Map<String, Object> resultMap = authService.DoLogin(userId, userPw);

        // 2. 로그인 성공 여부 확인
        boolean isSuccess = (boolean) resultMap.getOrDefault("success", false);

        if (isSuccess && resultMap.containsKey("token")) {
            String jwtToken = (String) resultMap.get("token");

            // 3. 최신 Spring 환경에 안전한 ResponseCookie 객체 생성
            ResponseCookie cookie = ResponseCookie.from("AUTH_TOKEN", jwtToken)
                    .httpOnly(true)                // JavaScript 접근 차단 (XSS 방어)
                    //.secure(true)                  // HTTPS 환경에서만 전송 (로컬 HTTP 환경 테스트 시 잠시 주석 처리 가능)
                    .secure(false)                  // HTTPS 환경에서만 전송 (로컬 HTTP 환경 테스트 시 잠시 주석 처리 가능)
                    .path("/")                     // 도메인 전역에서 쿠키 유효
                    .maxAge(60 * 60 * 2)           // 쿠키 만료 시간: 2시간 (초 단위)
                    //.sameSite("Strict")            // CSRF 공격 방어 옵션 (Lax 또는 Strict)
                    .sameSite("Lax") // 👈 로컬 장치 테스트 시에는 Lax 또는 주석 처리 권장
                    .build();

            // 4. 응답 헤더에 쿠키 주입
            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
            
            // 5. 프론트엔드로 내려가는 JSON 결과값에서는 토큰 보안을 위해 제거 가능 (선택 사항)
            // resultMap.remove("token"); 
        }

        return resultMap;
    }
}
