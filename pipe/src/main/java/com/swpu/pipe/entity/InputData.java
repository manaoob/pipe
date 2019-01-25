package com.swpu.pipe.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_inputdata")
public class InputData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1603533197080176459L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer inputDataId;
	
	private Double externalDiameter;  // �⾶
	private Double innerDiameter;    // �ھ�
	//private Double thicknessOfPipe;
	
	private String elasticityModulus; //����ģ��
	private Double poissonRatio;  // ���ɱ�
	
	private Integer typeOfCrack;
	
	private Double  crackLength; // ������״��
	private Double  relativeLength; // ����������
	
	private Integer pressure;  // ��ѹ
	
	private Integer yield; // ����ǿ��
	
	private Double yieldOffset; // ����ϵ��
	
	private Integer hardening; // Ӳ��ϵ��
	//private String notes;
	private Integer lenghtOfSubside; // ����������
	
	private Integer depthOfSubside; // �������
	
	private Integer buriedDepth; // ����
	
	private Integer typeOfSoil;
	
	@ManyToOne
	@JoinColumn(name = "user_inputData_id")
	private User user;
	
	@OneToOne(mappedBy="inputData", fetch = FetchType.LAZY)
	private ResultData resultData;
	
	
	public ResultData getResultData() {
		return resultData;
	}
	public void setResultData(ResultData resultData) {
		this.resultData = resultData;
	}
	public Integer getInputDataId() {
		return inputDataId;
	}
	public void setInputDataId(Integer inputDataId) {
		this.inputDataId = inputDataId;
	}

	public Double getExternalDiameter() {
		return externalDiameter;
	}

	public void setExternalDiameter(Double externalDiameter) {
		this.externalDiameter = externalDiameter;
	}

	public Double getInnerDiameter() {
		return innerDiameter;
	}

	public void setInnerDiameter(Double innerDiameter) {
		this.innerDiameter = innerDiameter;
	}



	public String getElasticityModulus() {
		return elasticityModulus;
	}

	public void setElasticityModulus(String elasticityModulus) {
		this.elasticityModulus = elasticityModulus;
	}

	public Double getPoissonRatio() {
		return poissonRatio;
	}

	public void setPoissonRatio(Double poissonRatio) {
		this.poissonRatio = poissonRatio;
	}



	public Double getCrackLength() {
		return crackLength;
	}

	public void setCrackLength(Double crackLength) {
		this.crackLength = crackLength;
	}

	

	public Integer getDepthOfSubside() {
		return depthOfSubside;
	}
	public void setDepthOfSubside(Integer depthOfSubside) {
		this.depthOfSubside = depthOfSubside;
	}
	public Double getRelativeLength() {
		return relativeLength;
	}
	public void setRelativeLength(Double relativeLength) {
		this.relativeLength = relativeLength;
	}
	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Integer getYield() {
		return yield;
	}
	public void setYield(Integer yield) {
		this.yield = yield;
	}
	public Double getYieldOffset() {
		return yieldOffset;
	}
	public void setYieldOffset(Double yieldOffset) {
		this.yieldOffset = yieldOffset;
	}
	public Integer getHardening() {
		return hardening;
	}
	public void setHardening(Integer hardening) {
		this.hardening = hardening;
	}
	public Integer getLenghtOfSubside() {
		return lenghtOfSubside;
	}
	public void setLenghtOfSubside(Integer lenghtOfSubside) {
		this.lenghtOfSubside = lenghtOfSubside;
	}
	public Integer getDepthOfSrbside() {
		return depthOfSubside;
	}
	public void setDepthOfSrbside(Integer depthOfSubside) {
		this.depthOfSubside = depthOfSubside;
	}
	public Integer getBuriedDepth() {
		return buriedDepth;
	}
	public void setBuriedDepth(Integer buriedDepth) {
		this.buriedDepth = buriedDepth;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getTypeOfSoil() {
		return typeOfSoil;
	}
	public void setTypeOfSoil(Integer typeOfSoil) {
		this.typeOfSoil = typeOfSoil;
	}
	public Integer getTypeOfCrack() {
		return typeOfCrack;
	}
	public void setTypeOfCrack(Integer typeOfCrack) {
		this.typeOfCrack = typeOfCrack;
	}
	
	
	
}
