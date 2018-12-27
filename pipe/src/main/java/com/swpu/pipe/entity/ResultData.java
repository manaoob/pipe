package com.swpu.pipe.entity;

import java.io.Serializable;

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
	
	private String mises;
	private String maxPrincipal;
	private String maxPrincipalabs;
	private String midPrincipal;
	private String minPrincipal;
	private String S11;
	private String S22;
	private String S33;
	
	private String magnitude;
	private String U1;
	private String U2;
	private String U3;
	private String K;
	
	private String misesPhoto;
	private String magnitudePhoto;
	
	@ManyToOne
	@JoinColumn(name = "user_resultData_id")
	private User user;
	
	@OneToOne(optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name = "inputDataId", referencedColumnName = "inputDataId", unique = true)
	private InputData inputData;

	public Integer getResultDataId() {
		return resultDataId;
	}

	public void setResultDataId(Integer resultDataId) {
		this.resultDataId = resultDataId;
	}
	
	
	public String getMises() {
		return mises;
	}

	public void setMises(String mises) {
		this.mises = mises;
	}

	public String getMaxPrincipal() {
		return maxPrincipal;
	}

	public void setMaxPrincipal(String maxPrincipal) {
		this.maxPrincipal = maxPrincipal;
	}

	public String getMaxPrincipalabs() {
		return maxPrincipalabs;
	}

	public void setMaxPrincipalabs(String maxPrincipalabs) {
		this.maxPrincipalabs = maxPrincipalabs;
	}

	public String getMidPrincipal() {
		return midPrincipal;
	}

	public void setMidPrincipal(String midPrincipal) {
		this.midPrincipal = midPrincipal;
	}

	public String getMinPrincipal() {
		return minPrincipal;
	}

	public void setMinPrincipal(String minPrincipal) {
		this.minPrincipal = minPrincipal;
	}

	public String getS11() {
		return S11;
	}

	public void setS11(String s11) {
		S11 = s11;
	}

	public String getS22() {
		return S22;
	}

	public void setS22(String s22) {
		S22 = s22;
	}

	public String getS33() {
		return S33;
	}

	public void setS33(String s33) {
		S33 = s33;
	}

	public String getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(String magnitude) {
		this.magnitude = magnitude;
	}

	public String getU1() {
		return U1;
	}

	public void setU1(String u1) {
		U1 = u1;
	}

	public String getU2() {
		return U2;
	}

	public void setU2(String u2) {
		U2 = u2;
	}

	public String getU3() {
		return U3;
	}

	public void setU3(String u3) {
		U3 = u3;
	}

	public String getK() {
		return K;
	}

	public void setK(String k) {
		K = k;
	}

	public String getMisesPhoto() {
		return misesPhoto;
	}

	public void setMisesPhoto(String misesPhoto) {
		this.misesPhoto = misesPhoto;
	}

	public String getMagnitudePhoto() {
		return magnitudePhoto;
	}

	public void setMagnitudePhoto(String magnitudePhoto) {
		this.magnitudePhoto = magnitudePhoto;
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
}
