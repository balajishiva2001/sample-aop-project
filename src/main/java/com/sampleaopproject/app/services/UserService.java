package com.sampleaopproject.app.services;

import java.util.List;

import com.sampleaopproject.app.models.UserDto;

public interface UserService {

	void createUser(UserDto userDto);

	void updateUser(int userId, UserDto userDto);

	void deleteUser(int userId);

	List<UserDto> getAllUser();

	UserDto getUserById(int userId);
}
