/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.service;

import co.cctv.c3r3.entity.Category;
import co.cctv.c3r3.entity.Skate;
import co.cctv.c3r3.repository.SkateRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cktv
 */
@Service
public class SkateService {
    
    @Autowired
    private SkateRepository skateboardRepository;
    
    public List<Skate> getAll(){
        return skateboardRepository.getAll();
    }
    
    public Optional<Skate> getSkateboard(int id){
        return skateboardRepository.getSkateboard(id);
    }
    
    public Skate save(Skate skateboard){
        if(skateboard.getId()==null){
            return skateboardRepository.save(skateboard);
        }else{
            Optional<Skate> e=skateboardRepository.getSkateboard(skateboard.getId());
            if(e.isEmpty()){
                return skateboardRepository.save(skateboard);
            }else{
                return skateboard;
            }
        }
    }
    
    public Skate update(Skate skateboard){
        if(skateboard.getId()!=null){
            return skateboardRepository.save(skateboard);
        }else{
            Optional<Skate> e=skateboardRepository.getSkateboard(skateboard.getId());
            if(!e.isEmpty()){
                if(skateboard.getName()!=null){
                    e.get().setName(skateboard.getName());
                }
                if(skateboard.getBrand()!=null){
                    e.get().setBrand(skateboard.getBrand());
                }
                if(skateboard.getYear()!=null){
                    e.get().setYear(skateboard.getYear());
                }
                if(skateboard.getDescription()!=null){
                    e.get().setDescription(skateboard.getDescription());
                }
                if(skateboard.getCategory()!=null){
                    e.get().setCategory(skateboard.getCategory());
                }
                if(skateboard.getMessages()!=null){
                    e.get().setMessages(skateboard.getMessages());
                }
                if(skateboard.getReservations()!=null){
                    e.get().setReservations(skateboard.getReservations());
                }
                skateboardRepository.save(e.get());
                return e.get();
            }else{
                return skateboard;
            }
        }
    }
    
    public boolean deleteSkateboard(int id){
        
        
        Boolean aBoolean=getSkateboard(id).map(skateboard -> {
            skateboardRepository.delete(skateboard);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
}
