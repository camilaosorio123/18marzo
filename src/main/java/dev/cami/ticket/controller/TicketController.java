package dev.cami.ticket.controller;

import dev.cami.ticket.model.Ticket;
import dev.cami.ticket.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return this.service.getTickets();
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody Ticket ticket) {
        Ticket created = this.service.create(ticket);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Ticket Creado");
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/by-id/{id}")
    public ResponseEntity<Ticket> getTicketById(
            @PathVariable Long id,
            @RequestBody Ticket ticket) {
        Ticket updated = this.service.updateById(id, ticket);
        if (updated != null) {
            return ResponseEntity.status(200).body(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket found = this.service.getById(id);
        if (found != null) {
            return ResponseEntity.status(200).body(found);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/by-id/{id}")
    public ResponseEntity<Ticket> deleteTicketById(@PathVariable Long id) {
        Ticket found = this.service.deleteById(id);
        if (found != null) {
            return ResponseEntity.status(200).body(found);
        }
        return ResponseEntity.notFound().build();
    }
}