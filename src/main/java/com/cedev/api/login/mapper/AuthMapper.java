package com.cedev.api.login.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cedev.api.member.dto.UserDto;

@Mapper
public interface AuthMapper {
	
	
	int chkExistId(@Param("userId") String userId);
	
	List<UserDto> chkPw(@Param("userId") String userId, @Param("userPw") String userPw);
	
	

}
