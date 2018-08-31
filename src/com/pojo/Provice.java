package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Provice entity. @author MyEclipse Persistence Tools
 */

public class Provice implements java.io.Serializable {

	// Fields

	private Integer prId;
	private String prName;
	private Set cities = new HashSet(0);

	// Constructors

	/** default constructor */
	public Provice() {
	}

	/** minimal constructor */
	public Provice(String prName) {
		this.prName = prName;
	}

	/** full constructor */
	public Provice(String prName, Set cities) {
		this.prName = prName;
		this.cities = cities;
	}

	// Property accessors

	public Integer getPrId() {
		return this.prId;
	}

	public void setPrId(Integer prId) {
		this.prId = prId;
	}

	public String getPrName() {
		return this.prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public Set getCities() {
		return this.cities;
	}

	public void setCities(Set cities) {
		this.cities = cities;
	}

}