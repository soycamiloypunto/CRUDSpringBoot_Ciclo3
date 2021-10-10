/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.repository;


import co.cctv.c3r3.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cktv
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer>{
    
}
