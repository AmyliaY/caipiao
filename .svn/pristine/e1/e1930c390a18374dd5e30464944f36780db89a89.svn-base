package com.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CaipiaobiaoDesc entity. @author MyEclipse Persistence Tools
 */

public class CaipiaobiaoDesc implements java.io.Serializable {

	// Fields

	private Integer id;
	
	private Caipiaobiao caipiaobiao;
	private String name;
	private Double price;
	private Timestamp begintime;
	private Timestamp endtime;
	private Integer status;
	private Timestamp kaijiangtime;
	private Double jiangchi;
	private Set dingdanxiangqings = new HashSet(0);

	// Constructors

	/** default constructor */
	public CaipiaobiaoDesc() {
	}

	/** full constructor */
	public CaipiaobiaoDesc(Caipiaobiao caipiaobiao, String name, Double price, Timestamp begintime, Timestamp endtime,
			Integer status, Timestamp kaijiangtime, Double jiangchi, Set dingdanxiangqings) {
		this.caipiaobiao = caipiaobiao;
		this.name = name;
		this.price = price;
		this.begintime = begintime;
		this.endtime = endtime;
		this.status = status;
		this.kaijiangtime = kaijiangtime;
		this.jiangchi = jiangchi;
		this.dingdanxiangqings = dingdanxiangqings;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Caipiaobiao getCaipiaobiao() {
		return this.caipiaobiao;
	}

	public void setCaipiaobiao(Caipiaobiao caipiaobiao) {
		this.caipiaobiao = caipiaobiao;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Timestamp getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Timestamp begintime) {
		this.begintime = begintime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getKaijiangtime() {
		return this.kaijiangtime;
	}

	public void setKaijiangtime(Timestamp kaijiangtime) {
		this.kaijiangtime = kaijiangtime;
	}

	public Double getJiangchi() {
		return this.jiangchi;
	}

	public void setJiangchi(Double jiangchi) {
		this.jiangchi = jiangchi;
	}

	public Set getDingdanxiangqings() {
		return this.dingdanxiangqings;
	}

	public void setDingdanxiangqings(Set dingdanxiangqings) {
		this.dingdanxiangqings = dingdanxiangqings;
	}

}