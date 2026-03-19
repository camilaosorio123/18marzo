package dev.cami.ticket.service;

import dev.cami.ticket.model.Ticket;
import dev.cami.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    //inyeccion de dependencias
    //instanciamos el ticket repository
    private TicketRepository repository;

    //constructor del repositorio para poder usarlo en el package repository
    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }


    public List<Ticket> getTickets() {
        return this.repository.getAll();

    }
}
