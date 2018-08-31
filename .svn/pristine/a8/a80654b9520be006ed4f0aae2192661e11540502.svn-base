package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	private Integer ctId;
	private Provice provice;
	private String ctName;
	private Double ctYunfei;
	private Double cityYunfei;
	private Set areas = new HashSet(0);

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(Provice provice, String ctName) {
		this.provice = provice;
		this.ctName = ctName;
	}

	/** full constructor */
	public City(Provice provice, String ctName, Double ctYunfei,
			Double cityYunfei, Set areas) {
		this.provice = provice;
		this.ctName = ctName;
		this.ctYunfei = ctYunfei;
		this.cityYunfei = cityYunfei;
		this.areas = areas;
	}

	// Property accessors

	public Integer getCtId() {
		return this.ctId;
	}

	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}

	public Provice getProvice() {
		return this.provice;
	}

	public void setProvice(Provice provice) {
		this.provice = provice;
	}

	public String getCtName() {
		return this.ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public Double getCtYunfei() {
		return this.ctYunfei;
	}

	public void setCtYunfei(Double ctYunfei) {
		this.ctYunfei = ctYunfei;
	}

	public Double getCityYunfei() {
		return this.cityYunfei;
	}

	public void setCityYunfei(Double cityYunfei) {
		this.cityYunfei = cityYunfei;
	}

	public Set getAreas() {
		return this.areas;
	}

	public void setAreas(Set areas) {
		this.areas = areas;
	}

}