package com.sampleaopproject.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sampleaopproject.app.models.UserDto;
import com.sampleaopproject.app.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
		userService.createUser(userDto);
		return new ResponseEntity<String>("User Created", HttpStatus.CREATED);
	}

	@PutMapping("/users/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") int userId) {
		userService.updateUser(userId, userDto);
		return new ResponseEntity<String>("User Updated", HttpStatus.OK);
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> readAllUser() {
		return new ResponseEntity<List<UserDto>>(userService.getAllUser(), HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDto> readUserById(@PathVariable("userId") int userId) {
		return new ResponseEntity<UserDto>(userService.getUserById(userId), HttpStatus.OK);
	}
}
