package com.pojo;

import java.sql.Timestamp;

/**
 * Appversion entity. @author MyEclipse Persistence Tools
 */

public class Appversion implements java.io.Serializable {

	// Fields

	private Integer avid;
	private String avappid;
	private String avurl;
	private String aversion;
	private Integer avtype;
	private Timestamp avtime;

	// Constructors

	/** default constructor */
	public Appversion() {
	}

	/** full constructor */
	public Appversion(String avappid, String avurl, String aversion,
			Integer avtype, Timestamp avtime) {
		this.avappid = avappid;
		this.avurl = avurl;
		this.aversion = aversion;
		this.avtype = avtype;
		this.avtime = avtime;
	}

	// Property accessors

	public Integer getAvid() {
		return this.avid;
	}

	public void setAvid(Integer avid) {
		this.avid = avid;
	}

	public String getAvappid() {
		return this.avappid;
	}

	public void setAvappid(String avappid) {
		this.avappid = avappid;
	}

	public String getAvurl() {
		return this.avurl;
	}

	public void setAvurl(String avurl) {
		this.avurl = avurl;
	}

	public String getAversion() {
		return this.aversion;
	}

	public void setAversion(String aversion) {
		this.aversion = aversion;
	}

	public Integer getAvtype() {
		return this.avtype;
	}

	public void setAvtype(Integer avtype) {
		this.avtype = avtype;
	}

	public Timestamp getAvtime() {
		return this.avtime;
	}

	public void setAvtime(Timestamp avtime) {
		this.avtime = avtime;
	}

}