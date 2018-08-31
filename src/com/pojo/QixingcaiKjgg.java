package com.pojo;

import java.sql.Timestamp;


/**
 * QixingcaiKjgg entity. @author MyEclipse Persistence Tools
 */

public class QixingcaiKjgg  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String qihao;
     private Timestamp kaijiangTime;
     private String num1;
     private String num2;
     private String num3;
     private String num4;
     private String num5;
     private String num6;
     private String num7;


    // Constructors

    /** default constructor */
    public QixingcaiKjgg() {
    }

    
    /** full constructor */
    public QixingcaiKjgg(String qihao, Timestamp kaijiangTime, String num1, String num2, String num3, String num4, String num5, String num6, String num7) {
        this.qihao = qihao;
        this.kaijiangTime = kaijiangTime;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
        this.num7 = num7;
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

    public String getNum6() {
        return this.num6;
    }
    
    public void setNum6(String num6) {
        this.num6 = num6;
    }

    public String getNum7() {
        return this.num7;
    }
    
    public void setNum7(String num7) {
        this.num7 = num7;
    }
   








}