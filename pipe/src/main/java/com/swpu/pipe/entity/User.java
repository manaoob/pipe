package com.swpu.pipe.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ”√ªß
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="tb_user")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	private String username;
	
	private String nickName;
	
	private Date birthday;
	
	private String photo;
	
	private String phone;
	
	private String QQorWechat;
	
	private String email;
	
	private String notes;
	
	private String password;
	
	private String gender;
	
	private String loginTime;

	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<InputData> inputDatas;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<ResultData> resultDatas;
	
	
	public List<ResultData> getResultDatas() {
		return resultDatas;
	}
	public void setResultDatas(List<ResultData> resultDatas) {
		this.resultDatas = resultDatas;
	}
	public List<InputData> getInputDatas() {
		return inputDatas;
	}
	public void setInputDatas(List<InputData> inputDatas) {
		this.inputDatas = inputDatas;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

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

	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	
	
	

}
