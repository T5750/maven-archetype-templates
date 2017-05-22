package com.evangel.model;

/**
 * Created by ZHR on 2016/4/27.
 */
public class UserInfo {
	private Integer userId;
	private String userName;
	private String userPwd;

	public UserInfo() {
	}

	public UserInfo(Integer userId, String userName, String userPwd) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
