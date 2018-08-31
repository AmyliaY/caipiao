package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private Integer arId;
	private City city;
	private String arName;
	private Set caipiaodianshenqings = new HashSet(0);
	private Set caipiaodians = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** minimal constructor */
	public Area(City city, String arName) {
		this.city = city;
		this.arName = arName;
	}

	/** full constructor */
	public Area(City city, String arName, Set caipiaodianshenqings,
			Set caipiaodians) {
		this.city = city;
		this.arName = arName;
		this.caipiaodianshenqings = caipiaodianshenqings;
		this.caipiaodians = caipiaodians;
	}

	// Property accessors

	public Integer getArId() {
		return this.arId;
	}

	public void setArId(Integer arId) {
		this.arId = arId;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getArName() {
		return this.arName;
	}

	public void setArName(String arName) {
		this.arName = arName;
	}

	public Set getCaipiaodianshenqings() {
		return this.caipiaodianshenqings;
	}

	public void setCaipiaodianshenqings(Set caipiaodianshenqings) {
		this.caipiaodianshenqings = caipiaodianshenqings;
	}

	public Set getCaipiaodians() {
		return this.caipiaodians;
	}

	public void setCaipiaodians(Set caipiaodians) {
		this.caipiaodians = caipiaodians;
	}

}