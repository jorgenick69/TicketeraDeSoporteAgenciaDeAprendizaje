/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.controller;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.Ask;
import TicketeraDeSoporte.TicketeraDeSoporte.entity.TicketSupport;
import TicketeraDeSoporte.TicketeraDeSoporte.entity.User;
import TicketeraDeSoporte.TicketeraDeSoporte.service.AskService;
import TicketeraDeSoporte.TicketeraDeSoporte.service.TicketSupportService;
import TicketeraDeSoporte.TicketeraDeSoporte.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Jorge Dominguez
 */
@Controller

@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketSupportService ticketSupportService;
    @Autowired
    private AskService askService;

    @GetMapping("")
    public String listTicket(Model model) {
        var ticket = ticketSupportService.findAllTicket();
        model.addAttribute("ticket", ticket);
        return "index";
    }

    @GetMapping("/add")
    public String add(TicketSupport ticketSupport, @RequestParam(required = false) String description) {

        return "new_ticket";
    }

    @PostMapping("/save")
    public String save(TicketSupport ticket, @RequestParam(required = true) String description) {
        ticket = ticketSupportService.save(ticket);
        Ask ask = askService.createAsk(description, ticket.getId());
        ticket.getAsk().add(askService.save(ask));
        ticketSupportService.save(ticket);

        return "index";
    }
    @PostMapping("/modify")
    public String modify(@RequestParam(required = true) String id, @RequestParam(required = true) String description) {
        TicketSupport ticket = ticketSupportService.findTicketByid(id);
        ticket = ticketSupportService.save(ticket);
        Ask ask = askService.createAsk(description, ticket.getId());
        ticket.getAsk().add(askService.save(ask));
        ticketSupportService.save(ticket);

        return "index";
    }

    @GetMapping("/edit/{id}")
    public String edit(TicketSupport ticket, Model model) {
        ticket = ticketSupportService.findTicket(ticket);
        model.addAttribute("ticket", ticket);
        return "new_ticket";

    }

    @GetMapping("/delete/{id}")
    public String delete(TicketSupport ticket) {
        ticketSupportService.delete(ticket);

        return "redirect:/ticket/";

    }
    @GetMapping("/getTicket")
    public String getTicket(@RequestParam(required = true) String id, Model model) {
       
       TicketSupport ticket = ticketSupportService.findTicketByid(id);
        model.addAttribute("ticket", ticket);
        return "segimiento_ticket";

    }
}
