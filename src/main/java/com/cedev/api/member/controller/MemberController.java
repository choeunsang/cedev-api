package com.cedev.api.member.controller;

import java.util.List;
import org.springframework.stereotype.Controller; // 1. @Controller 사용
import org.springframework.ui.Model;             // 2. Model 임포트
import org.springframework.web.bind.annotation.*;
import com.cedev.api.member.dto.UserDto;
import com.cedev.api.member.service.UserService;

@Controller // 🛑 @RestController에서 @Controller로 변경!
@RequestMapping("/page/member")
public class MemberController {

    private final UserService userService;

    // 생성자 주입 (UserService만 안전하게 주입받습니다)
    public MemberController(UserService userService) {
        this.userService = userService;
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 목록조회 (화면 이동 + 데이터 전달)
    //-------------------------------------------------------------------------------------------
    @GetMapping("/list")
    public String getUserList(Model model) { // 🛑 메서드 파라미터로 Model을 받습니다.
        
        // 1. 서비스에서 회원 목록 데이터를 가져옵니다.
        List<UserDto> userList = userService.getUserList();
        
        // 2. JSP에서 사용할 수 있도록 "list"라는 이름으로 데이터를 담습니다.
        model.addAttribute("list", userList);
        
        // 3. 열고자 하는 JSP 파일의 경로(이름)를 문자열로 리턴합니다.
        // (예: /WEB-INF/views/page/member/list.jsp 인 경우 "page/member/list" 리턴)
        return "page/member/list"; 
    }
}
