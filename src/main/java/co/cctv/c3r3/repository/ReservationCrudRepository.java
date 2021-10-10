/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.repository;


import co.cctv.c3r3.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cktv
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
}
