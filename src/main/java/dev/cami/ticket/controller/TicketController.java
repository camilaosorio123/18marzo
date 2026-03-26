package dev.cami.ticket.controller;

import dev.cami.ticket.model.Ticket;
import dev.cami.ticket.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")

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

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
       Ticket created = this.service.create(ticket);
       if (created != null) {
           return created ;
       }
       return null ;
    }
}
