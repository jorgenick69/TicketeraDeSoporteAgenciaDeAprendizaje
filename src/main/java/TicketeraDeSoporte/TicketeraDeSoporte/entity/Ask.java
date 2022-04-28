/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;





/**
 *
 * @author Jorge Dominguez
 */
@Data
@Entity
@Table(name = "ask")
public class Ask implements Serializable{
private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    //@OneToOne
    //private Archive archive;
    @OneToOne
    private Answer answer;
  @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfDischarge=new Date();
   @ManyToOne
  @JoinColumn(name="ticket_id", nullable=false)
   private TicketSupport ticketsupport;
}
