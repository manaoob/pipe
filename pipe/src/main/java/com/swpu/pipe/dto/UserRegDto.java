package com.swpu.pipe.dto;

import javax.validation.constraints.Pattern;

import com.swpu.pipe.entity.User;

public class UserRegDto {

	@Pattern(regexp="\\w{4,20}")
	private String username;
	private Integer password;
	private Integer rePassword;
	
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
	public Integer getPassword() {
		return password;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public Integer getRePassword() {
		return rePassword;
	}
	public void setRePassword(Integer rePassword) {
		this.rePassword = rePassword;
	}
	
	
	
}
