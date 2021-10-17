/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.repository;

import co.cctv.c3r3.entity.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cktv
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    //Get ALl
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    //SAVE
    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }
    
    //DELETE
    public void delete(Category category){
        categoryCrudRepository.delete(category);
    }
    
}
