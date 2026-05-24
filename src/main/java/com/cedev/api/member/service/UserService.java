package com.cedev.api.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cedev.api.member.dto.UserCreateRequestDto;
import com.cedev.api.member.dto.UserDto;
import com.cedev.api.member.dto.UserUpdateRequestDto;
import com.cedev.api.member.mapper.UserMapper;

@Service
public class UserService {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 목록조회
    //-------------------------------------------------------------------------------------------
    public List<UserDto> getUserList() {
        return userMapper.getUserList();
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 상세
    //-------------------------------------------------------------------------------------------
    public UserDto getUser(int userSeq) {
        return userMapper.getUser(userSeq);
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 등록
    //-------------------------------------------------------------------------------------------
    public int createUser(UserCreateRequestDto param) {
        return userMapper.createUser(param);
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 수정
    //-------------------------------------------------------------------------------------------
    public int updateUser(int userSeq, UserUpdateRequestDto param) {
        return userMapper.updateUser(userSeq, param);
    }

    //-------------------------------------------------------------------------------------------
    // 회원정보 삭제
    //-------------------------------------------------------------------------------------------
    public int deleteUser(int userSeq) {
        return userMapper.deleteUser(userSeq);
    }
}