/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.serviceIMPL;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.Ask;
import TicketeraDeSoporte.TicketeraDeSoporte.entity.TicketSupport;
import TicketeraDeSoporte.TicketeraDeSoporte.repository.AskRepository;
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
public class AskServiceIMPL implements AskService {

    @Autowired
    private AskRepository askRepository;
    @Autowired
    private TicketSupportService ticketSupportService;

    @Override
    public Ask createAsk(String description,String id) {
    Ask ask=new Ask();
    ask.setDescription(description);
    ask.setTicketsupport(ticketSupportService.findTicketByid(id));
    return ask;
    }
    
    @Override
    public List<Ask> findAllAsk() {
        return (List<Ask>) askRepository.findAll();
    }
    
    @Override
    public Ask save(Ask ask) {
        return askRepository.save(ask);
    }
    
    @Override
    public void delete(Ask ask) {
        askRepository.delete(ask);
    }
    
    @Override
    public Ask findAsk(Ask ask) {
     return askRepository.findById(ask.getId()).orElse(null);
    }
    
}
