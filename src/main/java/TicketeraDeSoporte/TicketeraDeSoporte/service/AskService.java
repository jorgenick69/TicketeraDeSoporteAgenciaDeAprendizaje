/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.service;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.Ask;
import TicketeraDeSoporte.TicketeraDeSoporte.entity.TicketSupport;
import java.util.List;

/**
 *
 * @author Jorge Dominguez
 */
public interface AskService {
   public Ask createAsk(String description,String id);
    public List<Ask> findAllAsk();
    public Ask save(Ask ask);
    public void delete(Ask ask);
    public Ask findAsk(Ask ask);  
}
