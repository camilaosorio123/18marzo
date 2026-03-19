package dev.cami.ticket.controller;

import dev.cami.ticket.model.Ticket;
import dev.cami.ticket.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickets")

public class TicketController {
    private TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }
    @GetMapping
    //para obtener/leer informacion
    public List<Ticket> getAllTickets() {
        return this.service.getTickets();
    }
}
