package com.swpu.pipe.dto;

import javax.validation.constraints.Pattern;

import com.swpu.pipe.entity.User;

public class UserRegDto {

	@Pattern(regexp="\\w{4,20}")
	private String username;
	private String password;
	private String rePassword;
	
	public User toUser(){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
	
	
}
