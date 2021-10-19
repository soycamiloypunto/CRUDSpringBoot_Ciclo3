/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c3r3.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author cktv
 */
@Entity//Etiqueta Entidad
@Table (name = "skate")//Nombre de la tabla
public class Skate implements Serializable {//Serializable por JSON
    @Id//identificador unico
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Valor incremental
    private Integer id;//Identificador unico
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String brand;
    @Column(length = 4)
    private Integer year;
    @Column(length = 250)
    private String description;
    
    //Relacion con Categoría
    @ManyToOne
    @JoinColumn(name = "categoryId", updatable = false)
    @JsonIgnoreProperties(value="skates")
    private Category category;
    //Relacion con Message
    @OneToMany(cascade ={CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties(value={"skate","client"})
    private List<Message> messages;
    //Relacion con Reservation
    @OneToMany(cascade ={CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties(value="skate")
    private List<Reservation> reservations;
    
    //@JsonGetter("messages")
    //@JsonGetter("reservations")
    //Constructor vacío
    public Skate(){
        
    }
    //Constructor inicial atributos
    public Skate(Integer id, String name, String brand, Integer year, String description, Category category, List<Message> messages, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.category = category;
        this.messages = messages;
        this.reservations = reservations;
    }
    //Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    
    
    
}
