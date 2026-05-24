package com.cedev.api.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cedev.api.member.dto.UserCreateRequestDto;
import com.cedev.api.member.dto.UserDto;
import com.cedev.api.member.dto.UserUpdateRequestDto;

@Mapper
public interface UserMapper {

    //-------------------------------------------------------------------------------------------
    // 회원정보 목록조회
    //-------------------------------------------------------------------------------------------
    List<UserDto> getUserList();

    //-------------------------------------------------------------------------------------------
    // 회원정보 상세
    //-------------------------------------------------------------------------------------------
    UserDto getUser(@Param("userSeq") int userSeq);

    //-------------------------------------------------------------------------------------------
    // 회원정보 등록
    //-------------------------------------------------------------------------------------------
    int createUser(UserCreateRequestDto param);

    //-------------------------------------------------------------------------------------------
    // 회원정보 수정
    //-------------------------------------------------------------------------------------------
    int updateUser(
            @Param("userSeq") int userSeq,
            @Param("param") UserUpdateRequestDto param
    );

    //-------------------------------------------------------------------------------------------
    // 회원정보 삭제
    //-------------------------------------------------------------------------------------------
    int deleteUser(@Param("userSeq") int userSeq);
}