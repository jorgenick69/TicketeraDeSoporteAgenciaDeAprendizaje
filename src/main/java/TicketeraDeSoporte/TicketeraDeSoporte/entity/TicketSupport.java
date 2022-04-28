/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Jorge Dominguez
 */
@Data
@Entity
@Table(name = "ticket")
public class TicketSupport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String rol;
    private String institute;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketsupport")
    private List<Ask> ask = new ArrayList<>();
    private String status = "pendiente";
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfDischarge = new Date();

}
