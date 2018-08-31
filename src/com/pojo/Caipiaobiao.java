package com.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

/**
 * Caipiaobiao entity. @author MyEclipse Persistence Tools
 */

public class Caipiaobiao implements java.io.Serializable {

	// Fields

	private Integer id;
	private CaipiaoLeixing caipiaoLeixing;
	private String name;
	private Integer status;
	private Set caipiaobiaoDescs = new HashSet(0);
	private Set dingdans = new HashSet(0);

	// Constructors

	/** default constructor */
	public Caipiaobiao() {
	}

	/** full constructor */
	public Caipiaobiao(CaipiaoLeixing caipiaoLeixing, String name, Integer status, Set caipiaobiaoDescs, Set dingdans) {
		this.caipiaoLeixing = caipiaoLeixing;
		this.name = name;
		this.status = status;
		this.caipiaobiaoDescs = caipiaobiaoDescs;
		this.dingdans = dingdans;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CaipiaoLeixing getCaipiaoLeixing() {
		return this.caipiaoLeixing;
	}

	public void setCaipiaoLeixing(CaipiaoLeixing caipiaoLeixing) {
		this.caipiaoLeixing = caipiaoLeixing;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getCaipiaobiaoDescs() {
		return this.caipiaobiaoDescs;
	}

	public void setCaipiaobiaoDescs(Set caipiaobiaoDescs) {
		this.caipiaobiaoDescs = caipiaobiaoDescs;
	}

	public Set getDingdans() {
		return this.dingdans;
	}

	public void setDingdans(Set dingdans) {
		this.dingdans = dingdans;
	}

}