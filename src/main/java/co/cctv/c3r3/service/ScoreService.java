/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.service;

import co.cctv.c3r3.entity.Score;
import co.cctv.c3r3.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cktv
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    public Score save(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }else{
             Optional<Score> e=scoreRepository.getScore(score.getIdScore());
            if(e.isEmpty()){
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }
    
    public Score update(Score score){
        if(score.getIdScore()!=null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> e=scoreRepository.getScore(score.getIdScore());
            if(!e.isEmpty()){
                if(score.getMessageText()!=null){
                    e.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    e.get().setStars(score.getStars());
                }
                if(score.getReservation()!=null){
                    e.get().setReservation(score.getReservation());
                }
                
                return e.get();
            }else{
                return score;
            }
        }
    }
    
    public boolean deleteScore(int id){
        
        
        Boolean aBoolean=getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
}
