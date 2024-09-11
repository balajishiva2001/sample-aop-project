package com.sampleaopproject.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampleaopproject.app.entities.UserEntity;
import com.sampleaopproject.app.models.UserDto;
import com.sampleaopproject.app.repos.UserDao;
import com.sampleaopproject.app.utils.ModelMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void createUser(UserDto userDto) {
		userDao.save(modelMapper.mapToUserEntity(userDto));
	}

	@Override
	public void updateUser(int userId, UserDto userDto) {
		if (userDao.findById(userId).isPresent()) {
			UserEntity userEntity = userDao.findById(userId).get();
			userEntity.setUserName(userDto.getUserName());
			userEntity.setUserBranch(userDto.getUserBranch());
			userEntity.setUserSkills(userDto.getUserSkills());
			userDao.save(userEntity);
		}
	}

	@Override
	public void deleteUser(int userId) {
		if (userDao.findById(userId).isPresent()) {
			UserEntity userEntity = userDao.findById(userId).get();
			userDao.delete(userEntity);
		}
	}

	@Override
	public List<UserDto> getAllUser() {
		return userDao.findAll().stream().map(obj -> modelMapper.mapToUserDto(obj)).toList();
	}

	@Override
	public UserDto getUserById(int userId) {

		if (userDao.findById(userId).isPresent()) {
			return modelMapper.mapToUserDto(userDao.findById(userId).get());
		} else {
			return new UserDto();
		}

	}

}
