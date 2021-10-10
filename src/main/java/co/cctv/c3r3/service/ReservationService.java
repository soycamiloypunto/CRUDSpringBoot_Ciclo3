/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.service;

import co.cctv.c3r3.entity.Reservation;
import co.cctv.c3r3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cktv
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation message){
        if(message.getIdReservation()==null){
            return reservationRepository.save(message);
        }else{
            Optional<Reservation> e=reservationRepository.getReservation(message.getIdReservation());
            if(e.isEmpty()){
                return reservationRepository.save(message);
            }else{
                return message;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> e=reservationRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){
                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getClient()!=null){
                    e.get().setClient(reservation.getClient());
                }
                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }
    }
    
    public boolean deleteReservation(int id){
        
        Boolean aBoolean=getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
}
