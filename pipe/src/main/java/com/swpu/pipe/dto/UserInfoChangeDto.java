package com.swpu.pipe.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.swpu.pipe.entity.User;

public class UserInfoChangeDto {

	private String nickName;
	
	private String birthday;
	
//	private Date birthday;
	
	private String phone;
	
	private String QQorWechat;
	
	private String email;
	
	private String notes;

	public User toUser(UserInfoChangeDto userInfoChangeDto){
		User user = new User();
		user.setNickName(nickName);
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			user.setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		user.setBirthday(birthday);
		user.setPhone(phone);
		user.setQQorWechat(QQorWechat);
		user.setNotes(notes);
		user.setEmail(email);
		return user;
	}
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

//	public void setBirthday(Date birthday) {
//		this.birthday = birthday;
//	}
//	public Date getBirthday() {
//		return birthday;
//	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQQorWechat() {
		return QQorWechat;
	}

	public void setQQorWechat(String qQorWechat) {
		QQorWechat = qQorWechat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
