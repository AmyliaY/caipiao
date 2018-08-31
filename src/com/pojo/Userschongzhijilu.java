package com.pojo;

import java.sql.Timestamp;

/**
 * Userschongzhijilu entity. @author MyEclipse Persistence Tools
 */

public class Userschongzhijilu implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private Double money;
	private Integer status;
	private Timestamp time;
	private Integer type;
	private String did;
	private String returnId;

	// Constructors

	/** default constructor */
	public Userschongzhijilu() {
	}

	/** full constructor */
	public Userschongzhijilu(Users users, Double money, Integer status, Timestamp time, Integer type, String did,
			String returnId) {
		this.users = users;
		this.money = money;
		this.status = status;
		this.time = time;
		this.type = type;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
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