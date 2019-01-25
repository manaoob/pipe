package com.swpu.pipe.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_resultdata")
public class ResultData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7704878638576000945L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer resultDataId;
	
	private String crackJs;  // J积分
	
	private String crackMises; // 沿裂纹线的mises
	
	private String axialU2;  // 沿轴向的U2位移
	
	private String axialMises; // 沿轴向的mises应力
	
	private String axialPressure; // 沿轴向的正应力
	
	private String axialShear; // 沿轴向的剪应力
	
//	private String mises;
//	private String maxPrincipal;
//	private String maxPrincipalabs;
//	private String midPrincipal;
//	private String minPrincipal;
//	private String S11;
//	private String S22;
//	private String S33;
//	
//	private String magnitude;
//	private String U1;
//	private String U2;
//	private String U3;
//	private String K;
//	
//	private String misesPhoto;
//	private String magnitudePhoto;
	
	@ManyToOne
	@JoinColumn(name = "user_resultData_id")
	private User user;
	
	@OneToOne(optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name = "inputDataId_resultData_id", referencedColumnName = "inputDataId", unique = true)
	private InputData inputData;

	public Integer getResultDataId() {
		return resultDataId;
	}

	public void setResultDataId(Integer resultDataId) {
		this.resultDataId = resultDataId;
	}
	
	public String getCrackJs() {
		return crackJs;
	}

	public void setCrackJs(String crackJs) {
		this.crackJs = crackJs;
	}

	public String getCrackMises() {
		return crackMises;
	}

	public void setCrackMises(String crackMises) {
		this.crackMises = crackMises;
	}

	public String getAxialU2() {
		return axialU2;
	}

	public void setAxialU2(String axialU2) {
		this.axialU2 = axialU2;
	}

	public String getAxialMises() {
		return axialMises;
	}

	public void setAxialMises(String axialMises) {
		this.axialMises = axialMises;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public InputData getInputData() {
		return inputData;
	}

	public void setInputData(InputData inputData) {
		this.inputData = inputData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAxialPressure() {
		return axialPressure;
	}

	public void setAxialPressure(String axialPressure) {
		this.axialPressure = axialPressure;
	}

	public String getAxialShear() {
		return axialShear;
	}

	public void setAxialShear(String axialShear) {
		this.axialShear = axialShear;
	}
	
	
}
