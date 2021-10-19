/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.service;

import co.cctv.c3r3.entity.Reservation;
import co.cctv.c3r3.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author cktv
 */
@Service//Etiqueta de Servicio
public class ReservationService {
    
    @Autowired //Etiqueta
    private ReservationRepository reservationRepository; 
    
    public List<Reservation> getAll(){ //Lista de Reservaciones
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){ //Método para obtener 1 reservación especifica
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation reservation){ //Método para guardar la reservación nueva
        if(reservation.getIdReservation()==null){ //Valido si el id existe.
            return reservationRepository.save(reservation); 
        }else{
            Optional<Reservation> e=reservationRepository.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation){ //Metodo para actualizar una reservaciṕn.
        if(reservation.getIdReservation()!=null){ //Valido si existe.
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
    
    public boolean deleteReservation(int id){ //Método para borrar una reservación. 
        
        Boolean aBoolean=getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
    public List<Reservation> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date a=new Date();
        Date b=new Date();
        try{
            a=parser.parse(dateA);
            b=parser.parse(dateB);
        }catch (ParseException e){
            e.printStackTrace();
        }
        
        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }
    }
    
}
