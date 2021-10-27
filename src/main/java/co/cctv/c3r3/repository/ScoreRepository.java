/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.repository;

import co.cctv.c3r3.entity.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cktv
 */
@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    //Get ALl
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    
    //SAVE
    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }
    
    //DELETE
    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
    
}
