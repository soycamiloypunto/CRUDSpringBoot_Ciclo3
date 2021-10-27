/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.repository;

import co.cctv.c3r3.entity.Reservation;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cktv
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    //Get ALl
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    //SAVE
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    
    //DELETE
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    //Lista de revervaciones por intervalo de fechas
    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
    
    public int getStatusForStatusCompleted(){
         return reservationCrudRepository.countTotalStatusForCompleted();
    }
    
    public int getStatusForStatusCancelled(){
         return reservationCrudRepository.countTotalStatusForCancelled();
    }
    
    public List<Object[]> getReservationByClient(){
         return reservationCrudRepository.countTotalReservationByClient();
    }
}
