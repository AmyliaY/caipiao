package com.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * SoccerGame entity. @author MyEclipse Persistence Tools
 */

public class SoccerGame  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String saishiName;
     private Timestamp closingDate;
     private String zhuchangName;
     private String kechangName;
     private Double zhushengPl;
     private Double keshengPl;
     private Double pingjuPl;
     private Set zucaishengfuDdxqs = new HashSet(0);


    // Constructors

    /** default constructor */
    public SoccerGame() {
    }

    
    /** full constructor */
    public SoccerGame(String saishiName, Timestamp closingDate, String zhuchangName, String kechangName, Double zhushengPl, Double keshengPl, Double pingjuPl, Set zucaishengfuDdxqs) {
        this.saishiName = saishiName;
        this.closingDate = closingDate;
        this.zhuchangName = zhuchangName;
        this.kechangName = kechangName;
        this.zhushengPl = zhushengPl;
        this.keshengPl = keshengPl;
        this.pingjuPl = pingjuPl;
        this.zucaishengfuDdxqs = zucaishengfuDdxqs;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSaishiName() {
        return this.saishiName;
    }
    
    public void setSaishiName(String saishiName) {
        this.saishiName = saishiName;
    }

    public Timestamp getClosingDate() {
        return this.closingDate;
    }
    
    public void setClosingDate(Timestamp closingDate) {
        this.closingDate = closingDate;
    }

    public String getZhuchangName() {
        return this.zhuchangName;
    }
    
    public void setZhuchangName(String zhuchangName) {
        this.zhuchangName = zhuchangName;
    }

    public String getKechangName() {
        return this.kechangName;
    }
    
    public void setKechangName(String kechangName) {
        this.kechangName = kechangName;
    }

    public Double getZhushengPl() {
        return this.zhushengPl;
    }
    
    public void setZhushengPl(Double zhushengPl) {
        this.zhushengPl = zhushengPl;
    }

    public Double getKeshengPl() {
        return this.keshengPl;
    }
    
    public void setKeshengPl(Double keshengPl) {
        this.keshengPl = keshengPl;
    }

    public Double getPingjuPl() {
        return this.pingjuPl;
    }
    
    public void setPingjuPl(Double pingjuPl) {
        this.pingjuPl = pingjuPl;
    }

    public Set getZucaishengfuDdxqs() {
        return this.zucaishengfuDdxqs;
    }
    
    public void setZucaishengfuDdxqs(Set zucaishengfuDdxqs) {
        this.zucaishengfuDdxqs = zucaishengfuDdxqs;
    }
   








}