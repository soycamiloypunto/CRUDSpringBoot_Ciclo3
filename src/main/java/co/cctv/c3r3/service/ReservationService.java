/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.service;

import co.cctv.c3r3.entity.Client;
import co.cctv.c3r3.entity.Reservation;
import co.cctv.c3r3.entity.custom.StatusCount;
import co.cctv.c3r3.entity.custom.CountClient;
import co.cctv.c3r3.repository.ReservationRepository;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(reservation.getIdReservation()!=null){ //Valido si el Id es diferente de nulo y lo guardo como registro
            return reservationRepository.save(reservation); //Guardo el registro. 
        }else{
            Optional<Reservation> e=reservationRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){
                if(reservation.getStartDate()!=null){//Obtengo la fecha inicial
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){//Obtengo la fecha final
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getClient()!=null){//Obtengo el objeto cliente
                    e.get().setClient(reservation.getClient());
                }
                reservationRepository.save(e.get()); //Guardo la edición
                return e.get();
            }else{
                return reservation;//Devuelvo reservación
            }
        }
    }
    
    public boolean deleteReservation(int id){ //Método para borrar una reservación. 
        
        Boolean aBoolean=getReservation(id).map(reservation -> {//Busco la reservación por ID
            reservationRepository.delete(reservation);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
    public List<Reservation> getReservationsPeriod(String dateA, String dateB){//ENlisto todas las reservaciones en un período de tiempo
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date a=new Date();
        Date b=new Date();
        try{
            a=parser.parse(dateA);//parseo las fechas
            b=parser.parse(dateB);
        }catch (ParseException e){
            e.printStackTrace();
        }
        
        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a,b); //Ejecuto la clase repositorio trayendo todas las reservaciones en el intervalo de fechas
        }else{
            return new ArrayList<>(); 
        }
    }
    
    public StatusCount getStatusReport(){
        //Obtengo el estado de las reservaciones usando psql en la clase respositorio usando un string
        List<Reservation> completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled=reservationRepository.getReservationByStatus("cancelled");

        //Cuento cuantas reservaciones están en estado String Completado y Cancelado
        StatusCount descAmt=new StatusCount(completed.size(),cancelled.size());
        return descAmt;
    }
    
    public List<CountClient> getReservationByClient(){//Cuento el número de reservaciones por cliente
        List<CountClient> resultado=new ArrayList<>(); //Lista de cliente
        List<Object[]> report=reservationRepository.getReservationByClient(); //Objeto a recorrer
        for (int i = 0; i < report.size(); i++) {
            long val1=(long) report.get(i)[1];
            int value1=(int) val1;
            Client value2=(Client) report.get(i)[0];
            resultado.add(new CountClient(value1,value2));//agrego la cuenta al resultado
            
        }
        return resultado;//devuelvo el resultado. Objeto con la cuenta de reservaciones y las resaervaciones todo como un objeto
    }
    
}
