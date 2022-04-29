/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Jorge Dominguez
 */
@Data
@Entity
@Table
public class UserNew implements Serializable{
private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    @OneToMany
    @JoinColumn(name="id_user")
    private List<Rol> rol; 
    private String dependencia;
    private String position;
    private String email;
    private String username;
    private String password;
    private Boolean status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfDischarge=new Date();

}
