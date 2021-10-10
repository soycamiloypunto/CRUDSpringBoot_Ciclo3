/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.repository;

import co.cctv.c3r3.entity.Skate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cktv
 */
@Repository
public class SkateRepository {
    @Autowired
    private SkateCrudRepository skateboardCrudRepository;
    
    //Get ALl
    public List<Skate> getAll(){
        return (List<Skate>) skateboardCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Skate> getSkateboard(int id){
        return skateboardCrudRepository.findById(id);
    }
    
    //SAVE
    public Skate save(Skate skateboard){
        return skateboardCrudRepository.save(skateboard);
    }
    
    //DELETE
    public void delete(Skate skateboard){
        skateboardCrudRepository.delete(skateboard);
    }
    
}
