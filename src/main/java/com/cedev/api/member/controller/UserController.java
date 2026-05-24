package com.cedev.api.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cedev.api.member.dto.UserCreateRequestDto;
import com.cedev.api.member.dto.UserDto;
import com.cedev.api.member.dto.UserUpdateRequestDto;
import com.cedev.api.member.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 목록조회
    //-------------------------------------------------------------------------------------------
    @GetMapping("/list")
    public List<UserDto> getUserList() {
        return userService.getUserList();
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 상세
    //-------------------------------------------------------------------------------------------
    @GetMapping("/{userSeq}")
    public UserDto getUser(@PathVariable("userSeq") int userSeq) {
        return userService.getUser(userSeq);
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 등록
    //-------------------------------------------------------------------------------------------
    @PostMapping("/signup")
    public int createUser(@RequestBody UserCreateRequestDto param) {
        return userService.createUser(param);
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 수정
    //-------------------------------------------------------------------------------------------
    @PutMapping("/{userSeq}/password")
    public int updateUser(
            @PathVariable("userSeq") int userSeq,
            @RequestBody UserUpdateRequestDto param) {

        return userService.updateUser(userSeq, param);
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 삭제
    //-------------------------------------------------------------------------------------------
    @DeleteMapping("/{userSeq}")
    public int deleteUser(@PathVariable("userSeq") int userSeq) {
        return userService.deleteUser(userSeq);
    }
}