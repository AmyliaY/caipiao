package com.pojo;

import java.sql.Timestamp;


/**
 * ShiyixuanwuKjgg entity. @author MyEclipse Persistence Tools
 */

public class ShiyixuanwuKjgg  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String qihao;
     private Timestamp kaijiangTime;
     private String qiu1;
     private String qiu2;
     private String qiu3;
     private String qiu4;
     private String qiu5;


    // Constructors

    /** default constructor */
    public ShiyixuanwuKjgg() {
    }

    
    /** full constructor */
    public ShiyixuanwuKjgg(String qihao, Timestamp kaijiangTime, String qiu1, String qiu2, String qiu3, String qiu4, String qiu5) {
        this.qihao = qihao;
        this.kaijiangTime = kaijiangTime;
        this.qiu1 = qiu1;
        this.qiu2 = qiu2;
        this.qiu3 = qiu3;
        this.qiu4 = qiu4;
        this.qiu5 = qiu5;
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

    public String getQiu1() {
        return this.qiu1;
    }
    
    public void setQiu1(String qiu1) {
        this.qiu1 = qiu1;
    }

    public String getQiu2() {
        return this.qiu2;
    }
    
    public void setQiu2(String qiu2) {
        this.qiu2 = qiu2;
    }

    public String getQiu3() {
        return this.qiu3;
    }
    
    public void setQiu3(String qiu3) {
        this.qiu3 = qiu3;
    }

    public String getQiu4() {
        return this.qiu4;
    }
    
    public void setQiu4(String qiu4) {
        this.qiu4 = qiu4;
    }

    public String getQiu5() {
        return this.qiu5;
    }
    
    public void setQiu5(String qiu5) {
        this.qiu5 = qiu5;
    }
   








}