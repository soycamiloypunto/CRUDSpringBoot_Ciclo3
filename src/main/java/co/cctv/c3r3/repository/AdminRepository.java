/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.repository;

import co.cctv.c3r3.entity.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cktv
 */
@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    //Get ALl
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    
    //SAVE
    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }
    
    //DELETE
    public void delete(Admin admin){
        adminCrudRepository.delete(admin);
    }
    
}
