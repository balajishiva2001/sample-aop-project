package com.sampleaopproject.app.utils;

import org.springframework.stereotype.Component;

import com.sampleaopproject.app.entities.UserEntity;
import com.sampleaopproject.app.models.UserDto;

@Component
public class ModelMapper {

	public UserEntity mapToUserEntity(UserDto userDto) {
		return new UserEntity(userDto.getUserId(), userDto.getUserName(), userDto.getUserBranch(), userDto.getUserSkills());
	}
	
	public UserDto mapToUserDto(UserEntity userEntity) {
		return new UserDto(userEntity.getUserId(), userEntity.getUserName(), userEntity.getUserBranch(), userEntity.getUserSkills());
	}
}
