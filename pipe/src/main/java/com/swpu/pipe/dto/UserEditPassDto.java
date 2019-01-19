package com.swpu.pipe.dto;

public class UserEditPassDto {

	private String username;
	
	private String originPassword;
	
	private String password;
	
	private String rePassword;

	public UserEditPassDto(){
		
	}
	public UserEditPassDto(String username, String originPassword, String password, String rePassword) {
		super();
		this.username = username;
		this.originPassword = originPassword;
		this.password = password;
		this.rePassword = rePassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOriginPassword() {
		return originPassword;
	}

	public void setOriginPassword(String originPassword) {
		this.originPassword = originPassword;
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
