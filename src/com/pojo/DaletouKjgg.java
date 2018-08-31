package com.pojo;

import java.sql.Timestamp;


/**
 * DaletouKjgg entity. @author MyEclipse Persistence Tools
 */

public class DaletouKjgg  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String qihao;
     private Timestamp kaijiangTime;
     private String hongqiu1;
     private String hongqiu2;
     private String hongqiu3;
     private String hongqiu4;
     private String hongqiu5;
     private String lanqiu1;
     private String lanqiu2;


    // Constructors

    /** default constructor */
    public DaletouKjgg() {
    }

    
    /** full constructor */
    public DaletouKjgg(String qihao, Timestamp kaijiangTime, String hongqiu1, String hongqiu2, String hongqiu3, String hongqiu4, String hongqiu5, String lanqiu1, String lanqiu2) {
        this.qihao = qihao;
        this.kaijiangTime = kaijiangTime;
        this.hongqiu1 = hongqiu1;
        this.hongqiu2 = hongqiu2;
        this.hongqiu3 = hongqiu3;
        this.hongqiu4 = hongqiu4;
        this.hongqiu5 = hongqiu5;
        this.lanqiu1 = lanqiu1;
        this.lanqiu2 = lanqiu2;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getQihao() {
        return this.qihao;
    }
    
    public void setQihao(String qihao) {
        this.qihao = qihao;
    }

    public Timestamp getKaijiangTime() {
        return this.kaijiangTime;
    }
    
    public void setKaijiangTime(Timestamp kaijiangTime) {
        this.kaijiangTime = kaijiangTime;
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

    public String getLanqiu1() {
        return this.lanqiu1;
    }
    
    public void setLanqiu1(String lanqiu1) {
        this.lanqiu1 = lanqiu1;
    }

    public String getLanqiu2() {
        return this.lanqiu2;
    }
    
    public void setLanqiu2(String lanqiu2) {
        this.lanqiu2 = lanqiu2;
    }
   








}