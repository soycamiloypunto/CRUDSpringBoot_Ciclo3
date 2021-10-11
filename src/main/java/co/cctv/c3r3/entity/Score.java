/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author cktv
 */
@Entity
@Table(name = "score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private Integer scoreq;    
    private String messageScore;
    
//    @ManyToOne
//    @JoinColumn(name = "reservationId")
//    @JsonIgnoreProperties(value="scores")
//    private Reservation reservation;
    
    public Score(){
        
    }

    public Score(Integer idScore, Integer scoreq, String messageScore) {
        this.idScore = idScore;
        this.scoreq = scoreq;
        this.messageScore = messageScore;
    }

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public Integer getScoreq() {
        return scoreq;
    }

    public void setScoreq(Integer scoreq) {
        this.scoreq = scoreq;
    }

    public String getMessageScore() {
        return messageScore;
    }

    public void setMessageScore(String messageScore) {
        this.messageScore = messageScore;
    }

    
    
    
    
    
    
    
    
    
}
