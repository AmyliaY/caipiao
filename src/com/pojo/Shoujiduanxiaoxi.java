package com.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Shoujiduanxiaoxi entity. @author MyEclipse Persistence Tools
 */

public class Shoujiduanxiaoxi implements java.io.Serializable {

	// Fields

	private Integer id;
	private String phone;
	private String message;
	private Timestamp time;
	private Set caipiandianyuangongs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shoujiduanxiaoxi() {
	}

	/** full constructor */
	public Shoujiduanxiaoxi(String phone, String message, Timestamp time,
			Set caipiandianyuangongs) {
		this.phone = phone;
		this.message = message;
		this.time = time;
		this.caipiandianyuangongs = caipiandianyuangongs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Set getCaipiandianyuangongs() {
		return this.caipiandianyuangongs;
	}

	public void setCaipiandianyuangongs(Set caipiandianyuangongs) {
		this.caipiandianyuangongs = caipiandianyuangongs;
	}

}