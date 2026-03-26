package dev.cami.ticket.service;

import dev.cami.ticket.model.Ticket;
import dev.cami.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public Ticket create(Ticket ticket) {
        boolean exists = this.repository.existByTitle(ticket.getTitle());
        if (exists) {
            return null;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDate ldNow = LocalDate.now();
        ldNow = ldNow.plusDays(5);

        ticket.setStatus("NEW");
        ticket.setCreatedAt(now);
        ticket.setEstimatedResolutionTime(ldNow);
        return this.repository.save(ticket);
    }
}
