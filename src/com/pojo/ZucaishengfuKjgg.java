package com.pojo;

import java.sql.Timestamp;


/**
 * ZucaishengfuKjgg entity. @author MyEclipse Persistence Tools
 */

public class ZucaishengfuKjgg  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private SoccerGame soccerGame;
     private Timestamp kaijiangTime;
     private Integer result;
     private String score;


    // Constructors

    /** default constructor */
    public ZucaishengfuKjgg() {
    }

    
    /** full constructor */
    public ZucaishengfuKjgg(SoccerGame soccerGame, Timestamp kaijiangTime, Integer result, String score) {
        this.soccerGame = soccerGame;
        this.kaijiangTime = kaijiangTime;
        this.result = result;
        this.score = score;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public SoccerGame getSoccerGame() {
        return this.soccerGame;
    }
    
    public void setSoccerGame(SoccerGame soccerGame) {
        this.soccerGame = soccerGame;
    }

    public Timestamp getKaijiangTime() {
        return this.kaijiangTime;
    }
    
    public void setKaijiangTime(Timestamp kaijiangTime) {
        this.kaijiangTime = kaijiangTime;
    }

    public Integer getResult() {
        return this.result;
    }
    
    public void setResult(Integer result) {
        this.result = result;
    }

    public String getScore() {
        return this.score;
    }
    
    public void setScore(String score) {
        this.score = score;
    }
   








}