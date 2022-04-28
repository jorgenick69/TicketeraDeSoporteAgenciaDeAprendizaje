/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.serviceIMPL;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.Ask;
import TicketeraDeSoporte.TicketeraDeSoporte.entity.TicketSupport;
import TicketeraDeSoporte.TicketeraDeSoporte.entity.User;
import TicketeraDeSoporte.TicketeraDeSoporte.repository.TicketSupportRepository;
import TicketeraDeSoporte.TicketeraDeSoporte.service.AskService;
import TicketeraDeSoporte.TicketeraDeSoporte.service.TicketSupportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge Dominguez
 */
@Service
public class TicketSupportServiceIMPL implements TicketSupportService {

    @Autowired
    private TicketSupportRepository ticketSupportRepository;
    @Autowired
    private AskService askService;

//    @Override
//    public TicketSupport create(TicketSupport ticket, String description) {
//     TicketSupport ticket1= ticket;
//     Ask ask=askService.save(askService.createAsk(description));
//     ticket1.getAsk().add(ask);
//     return ticket1;
//    }
    @Override
    public List<TicketSupport> findAllTicket() {
        return (List<TicketSupport>) ticketSupportRepository.findAll();
    }

    @Override
    public TicketSupport save(TicketSupport ticket) {
        return ticketSupportRepository.save(ticket);
    }

    @Override
    public void delete(TicketSupport ticket) {
        ticketSupportRepository.delete(ticket);
    }

    @Override
    public TicketSupport findTicket(TicketSupport ticket) {
    return ticketSupportRepository.findById(ticket.getId()).orElse(null);
    }
    @Override
    public TicketSupport findTicketByid(String id) {
    return ticketSupportRepository.findById(id).orElse(null);
    }

    

}
