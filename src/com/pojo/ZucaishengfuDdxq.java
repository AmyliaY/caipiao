package com.pojo;



/**
 * ZucaishengfuDdxq entity. @author MyEclipse Persistence Tools
 */

public class ZucaishengfuDdxq  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Dingdan dingdan;
     private SoccerGame soccerGame;
     private CaipiaobiaoDesc caipiaobiaoDesc;
     private Integer result;
     private Integer zhushu;
     private Integer beishu;
     private Integer isZhongjiang;
     private Double zhongjiangjine;
     private Integer isLingjiang;
     private Double payMoney;


    // Constructors

    /** default constructor */
    public ZucaishengfuDdxq() {
    }

    
    /** full constructor */
    public ZucaishengfuDdxq(Dingdan dingdan, SoccerGame soccerGame, CaipiaobiaoDesc caipiaobiaoDesc, Integer result, Integer zhushu, Integer beishu, Integer isZhongjiang, Double zhongjiangjine, Integer isLingjiang, Double payMoney) {
        this.dingdan = dingdan;
        this.soccerGame = soccerGame;
        this.caipiaobiaoDesc = caipiaobiaoDesc;
        this.result = result;
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

    public SoccerGame getSoccerGame() {
        return this.soccerGame;
    }
    
    public void setSoccerGame(SoccerGame soccerGame) {
        this.soccerGame = soccerGame;
    }

    public CaipiaobiaoDesc getCaipiaobiaoDesc() {
        return this.caipiaobiaoDesc;
    }
    
    public void setCaipiaobiaoDesc(CaipiaobiaoDesc caipiaobiaoDesc) {
        this.caipiaobiaoDesc = caipiaobiaoDesc;
    }

    public Integer getResult() {
        return this.result;
    }
    
    public void setResult(Integer result) {
        this.result = result;
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