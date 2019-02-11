package com.swpu.pipe.dto;

import java.util.List;

/**
 * 展示计算数据的DTO
 * @author Allen
 *
 */

public class DataShowDto {

	private List<String> crackJs;
	
	private List<String> crackMises;
	
	private List<String> axialUs;
	
	private List<String> axialMises;
	
	private List<String> axialPressure;
	
	private List<String> axialShear;
 
	public DataShowDto(List<String> crackJs, List<String> crackMises, List<String> axialUs, List<String> axialMises, List<String> axialPressure, List<String> axialShear) {
		super();
		this.crackJs = crackJs;
		this.crackMises = crackMises;
		this.axialUs = axialUs;
		this.axialMises = axialMises;
		this.axialPressure = axialPressure;
		this.axialShear = axialShear;
		
	}
	public DataShowDto() {

	}

	public List<String> getCrackJs() {
		return crackJs;
	}

	public void setCrackJs(List<String> crackJs) {
		this.crackJs = crackJs;
	}

	public List<String> getCrackMises() {
		return crackMises;
	}

	public void setCrackMises(List<String> crackMises) {
		this.crackMises = crackMises;
	}

	public List<String> getAxialUs() {
		return axialUs;
	}

	public void setAxialUs(List<String> axialUs) {
		this.axialUs = axialUs;
	}

	public List<String> getAxialMises() {
		return axialMises;
	}

	public void setAxialMises(List<String> axialMises) {
		this.axialMises = axialMises;
	}
	public List<String> getAxialPressure() {
		return axialPressure;
	}
	public void setAxialPressure(List<String> axialPressure) {
		this.axialPressure = axialPressure;
	}
	public List<String> getAxialShear() {
		return axialShear;
	}
	public void setAxialShear(List<String> axialShear) {
		this.axialShear = axialShear;
	}
	
	
}
