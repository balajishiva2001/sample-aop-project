package com.sampleaopproject.app.models;

import java.util.Arrays;

public class UserDto {

	private int userId;
	
	private String userName;
	
	private String userBranch;
	
	private String[] userSkills;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int userId, String userName, String userBranch, String[] userSkills) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userBranch = userBranch;
		this.userSkills = userSkills;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBranch() {
		return userBranch;
	}

	public void setUserBranch(String userBranch) {
		this.userBranch = userBranch;
	}

	public String[] getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(String[] userSkills) {
		this.userSkills = userSkills;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", userBranch=" + userBranch
				+ ", userSkills=" + Arrays.toString(userSkills) + "]";
	}
	
	

}
