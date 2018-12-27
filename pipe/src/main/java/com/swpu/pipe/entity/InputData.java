package com.swpu.pipe.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	private Double externalDiameter;
	private Double innerDiameter;
	private Double thicknessOfPipe;
	
	private Long elasticityModulus;
	private Double poissonRatio;
	
	private String pipePhoto;
	
	private Double  crackLength;
	private Double  RelativeLength;
	
	private Integer pressure;
	
	private String notes;
	
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

	public Double getThicknessOfPipe() {
		return thicknessOfPipe;
	}

	public void setThicknessOfPipe(Double thicknessOfPipe) {
		this.thicknessOfPipe = thicknessOfPipe;
	}

	public Long getElasticityModulus() {
		return elasticityModulus;
	}

	public void setElasticityModulus(Long elasticityModulus) {
		this.elasticityModulus = elasticityModulus;
	}

	public Double getPoissonRatio() {
		return poissonRatio;
	}

	public void setPoissonRatio(Double poissonRatio) {
		this.poissonRatio = poissonRatio;
	}

	public String getPipePhoto() {
		return pipePhoto;
	}

	public void setPipePhoto(String pipePhoto) {
		this.pipePhoto = pipePhoto;
	}

	public Double getCrackLength() {
		return crackLength;
	}

	public void setCrackLength(Double crackLength) {
		this.crackLength = crackLength;
	}

	public Double getRelativeLength() {
		return RelativeLength;
	}

	public void setRelativeLength(Double relativeLength) {
		RelativeLength = relativeLength;
	}

	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
