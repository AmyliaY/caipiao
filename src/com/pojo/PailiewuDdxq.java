package com.pojo;



/**
 * PailiewuDdxq entity. @author MyEclipse Persistence Tools
 */

public class PailiewuDdxq  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Dingdan dingdan;
     private CaipiaobiaoDesc caipiaobiaoDesc;
     private String num1;
     private String num2;
     private String num3;
     private String num4;
     private String num5;
     private Integer zhushu;
     private Integer beishu;
     private Integer isZhongjiang;
     private Double zhongjiangjine;
     private Integer isLingjiang;
     private Double payMoney;


    // Constructors

    /** default constructor */
    public PailiewuDdxq() {
    }

    
    /** full constructor */
    public PailiewuDdxq(Dingdan dingdan, CaipiaobiaoDesc caipiaobiaoDesc, String num1, String num2, String num3, String num4, String num5, Integer zhushu, Integer beishu, Integer isZhongjiang, Double zhongjiangjine, Integer isLingjiang, Double payMoney) {
        this.dingdan = dingdan;
        this.caipiaobiaoDesc = caipiaobiaoDesc;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
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

    public String getNum1() {
        return this.num1;
    }
    
    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return this.num2;
    }
    
    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getNum3() {
        return this.num3;
    }
    
    public void setNum3(String num3) {
        this.num3 = num3;
    }

    public String getNum4() {
        return this.num4;
    }
    
    public void setNum4(String num4) {
        this.num4 = num4;
    }

    public String getNum5() {
        return this.num5;
    }
    
    public void setNum5(String num5) {
        this.num5 = num5;
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