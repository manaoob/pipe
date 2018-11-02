package com.swpu.pipe.dto;

import com.swpu.pipe.entity.User;

/**
 * 登录信息的数据传输对象
 * @author Administrator
 *
 */
public class UserLonDto {

	//@Pattern(regexp = "\\w{4,20}")
	private String username;
	private String password;
	private String vcode;
	
	public User toUser(UserLonDto userLonDto){
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		return user;
		
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
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
}
