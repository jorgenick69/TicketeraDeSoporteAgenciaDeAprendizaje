/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.service;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.TicketSupport;
import java.util.List;

/**
 *
 * @author Jorge Dominguez
 */
public interface TicketSupportService {
//    public  TicketSupport create(TicketSupport ticket,String description);
    public List<TicketSupport> findAllTicket();
    public TicketSupport save(TicketSupport ticket);
    public void delete(TicketSupport ticket);
    public TicketSupport findTicket(TicketSupport ticket); 
    public TicketSupport findTicketByid(String id);
}
