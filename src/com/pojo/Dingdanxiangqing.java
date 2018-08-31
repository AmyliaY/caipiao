package com.pojo;

/**
 * Dingdanxiangqing entity. @author MyEclipse Persistence Tools
 */

public class Dingdanxiangqing implements java.io.Serializable {

	// Fields

	private Integer id;
	private Dingdan dingdan;
	private CaipiaobiaoDesc caipiaobiaoDesc;
	private String hongqiu1;
	private String hongqiu2;
	private String hongqiu3;
	private String hongqiu4;
	private String hongqiu5;
	private String hongqiu6;
	private String lanqiu;
	private Integer zhushu;
	private Integer beishu;
	private Integer isZhongjiang;
	private Double zhongjiangjine;
	private Integer isLingjiang;
	private Double payMoney;

	// Constructors

	/** default constructor */
	public Dingdanxiangqing() {
	}

	/** full constructor */
	public Dingdanxiangqing(Dingdan dingdan, CaipiaobiaoDesc caipiaobiaoDesc, String hongqiu1, String hongqiu2,
			String hongqiu3, String hongqiu4, String hongqiu5, String hongqiu6, String lanqiu, Integer zhushu,
			Integer beishu, Integer isZhongjiang, Double zhongjiangjine, Integer isLingjiang, Double payMoney) {
		this.dingdan = dingdan;
		this.caipiaobiaoDesc = caipiaobiaoDesc;
		this.hongqiu1 = hongqiu1;
		this.hongqiu2 = hongqiu2;
		this.hongqiu3 = hongqiu3;
		this.hongqiu4 = hongqiu4;
		this.hongqiu5 = hongqiu5;
		this.hongqiu6 = hongqiu6;
		this.lanqiu = lanqiu;
		this.zhushu = zhushu;
		this.beishu = beishu;
		this.isZhongjiang = isZhongjiang;
		this.zhongjiangjine = zhongjiangjine;
		this.isLingjiang = isLingjiang;
		this.payMoney = payMoney;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dingdan getDingdan() {
		return this.dingdan;
	}

	public void setDingdan(Dingdan dingdan) {
		this.dingdan = dingdan;
	}

	public CaipiaobiaoDesc getCaipiaobiaoDesc() {
		return this.caipiaobiaoDesc;
	}

	public void setCaipiaobiaoDesc(CaipiaobiaoDesc caipiaobiaoDesc) {
		this.caipiaobiaoDesc = caipiaobiaoDesc;
	}

	public String getHongqiu1() {
		return this.hongqiu1;
	}

	public void setHongqiu1(String hongqiu1) {
		this.hongqiu1 = hongqiu1;
	}

	public String getHongqiu2() {
		return this.hongqiu2;
	}

	public void setHongqiu2(String hongqiu2) {
		this.hongqiu2 = hongqiu2;
	}

	public String getHongqiu3() {
		return this.hongqiu3;
	}

	public void setHongqiu3(String hongqiu3) {
		this.hongqiu3 = hongqiu3;
	}

	public String getHongqiu4() {
		return this.hongqiu4;
	}

	public void setHongqiu4(String hongqiu4) {
		this.hongqiu4 = hongqiu4;
	}

	public String getHongqiu5() {
		return this.hongqiu5;
	}

	public void setHongqiu5(String hongqiu5) {
		this.hongqiu5 = hongqiu5;
	}

	public String getHongqiu6() {
		return this.hongqiu6;
	}

	public void setHongqiu6(String hongqiu6) {
		this.hongqiu6 = hongqiu6;
	}

	public String getLanqiu() {
		return this.lanqiu;
	}

	public void setLanqiu(String lanqiu) {
		this.lanqiu = lanqiu;
	}

	public Integer getZhushu() {
		return this.zhushu;
	}

	public void setZhushu(Integer zhushu) {
		this.zhushu = zhushu;
	}

	public Integer getBeishu() {
		return this.beishu;
	}

	public void setBeishu(Integer beishu) {
		this.beishu = beishu;
	}

	public Integer getIsZhongjiang() {
		return this.isZhongjiang;
	}

	public void setIsZhongjiang(Integer isZhongjiang) {
		this.isZhongjiang = isZhongjiang;
	}

	public Double getZhongjiangjine() {
		return this.zhongjiangjine;
	}

	public void setZhongjiangjine(Double zhongjiangjine) {
		this.zhongjiangjine = zhongjiangjine;
	}

	public Integer getIsLingjiang() {
		return this.isLingjiang;
	}

	public void setIsLingjiang(Integer isLingjiang) {
		this.isLingjiang = isLingjiang;
	}

	public Double getPayMoney() {
		return this.payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

}