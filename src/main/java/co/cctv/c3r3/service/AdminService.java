/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.service;

import co.cctv.c3r3.entity.Admin;
import co.cctv.c3r3.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cktv
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    public Admin save(Admin admin){
        if(admin.getId()==null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> e=adminRepository.getAdmin(admin.getId());
            if(e.isEmpty()){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
        }
    }
    
    public Admin update(Admin admin){
        if(admin.getId()!=null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> e=adminRepository.getAdmin(admin.getId());
            if(!e.isEmpty()){
                if(admin.getName()!=null){
                    e.get().setName(admin.getName());
                }
                if(admin.getPassword()!=null){
                    e.get().setPassword(admin.getPassword());
                }
                if(admin.getEmail()!=null){
                    e.get().setEmail(admin.getEmail());
                }
                return e.get();
            }else{
                return admin;
            }
        }
    }
    
    public boolean deleteAdmin(int id){
        
        
        Boolean aBoolean=getAdmin(id).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
}
