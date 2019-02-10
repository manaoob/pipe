package com.swpu.pipe.dto;

public class InputDataDto {

	private Double externalDiameter;  // 外径
	private Double innerDiameter;    // 内径
	//private Double thicknessOfPipe;
	
	private String elasticityModulus; //弹性模量
	private Double poissonRatio;  // 泊松比
	
	private Integer typeOfCrack;
	
	private Double  crackLength; // 裂纹形状比
	private Double  relativeLength; // 裂纹相对深度
	
	private Integer pressure;  // 内压
	
	private Integer yield; // 屈服强度
	
	private Double yieldOffset; // 弹性系数
	
	private Integer hardening; // 硬化系数
	//private String notes;
	private Integer lenghtOfSubside; // 沉降区长度
	
	private Integer depthOfSubside; // 沉降深度
	
	private Integer buriedDepth; // 埋深
	
	private Integer typeOfSoil;

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

	public Integer getTypeOfCrack() {
		return typeOfCrack;
	}

	public void setTypeOfCrack(Integer typeOfCrack) {
		this.typeOfCrack = typeOfCrack;
	}

	public Double getCrackLength() {
		return crackLength;
	}

	public void setCrackLength(Double crackLength) {
		this.crackLength = crackLength;
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

	public Integer getDepthOfSubside() {
		return depthOfSubside;
	}

	public void setDepthOfSubside(Integer depthOfSubside) {
		this.depthOfSubside = depthOfSubside;
	}

	public Integer getBuriedDepth() {
		return buriedDepth;
	}

	public void setBuriedDepth(Integer buriedDepth) {
		this.buriedDepth = buriedDepth;
	}

	public Integer getTypeOfSoil() {
		return typeOfSoil;
	}

	public void setTypeOfSoil(Integer typeOfSoil) {
		this.typeOfSoil = typeOfSoil;
	}
	
	
}
