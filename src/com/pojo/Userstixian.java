package com.pojo;

import java.sql.Timestamp;

/**
 * Userstixian entity. @author MyEclipse Persistence Tools
 */

public class Userstixian implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private Double money;
	private Integer status;
	private Timestamp time;
	private Timestamp endtime;
	private String did;
	private String returnId;

	// Constructors

	/** default constructor */
	public Userstixian() {
	}

	/** full constructor */
	public Userstixian(Users users, Double money, Integer status, Timestamp time, Timestamp endtime, String did,
			String returnId) {
		this.users = users;
		this.money = money;
		this.status = status;
		this.time = time;
		this.endtime = endtime;
		this.did = did;
		this.returnId = returnId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getReturnId() {
		return this.returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}

}