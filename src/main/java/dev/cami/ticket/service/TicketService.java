package dev.cami.ticket.service;

import dev.cami.ticket.model.Ticket;
import dev.cami.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public List<Ticket> getTickets() {
        return this.repository.getAll();
    }

    public Ticket create(Ticket ticket) {

        boolean exists = this.repository.existsByTitle(ticket.getTitle());
        if (exists) {
            return null;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDate ldNow = LocalDate.now();
        LocalDate estimated = ldNow.plusDays(5L);

        ticket.setStatus("NEW");
        ticket.setCreatedAt(now);
        ticket.setEstimatedResolutionDate(estimated);
        return this.repository.save(ticket);
    }

    public Ticket getById(Long id) {
        return repository.getById(id);
    }

    public Ticket deleteById(Long id) {
        return repository.deleteById(id);
    }

    public Ticket updateById(Long id, Ticket ticket) {
        Optional<Ticket> optUpdate = this.repository.getById(id);
        if (optUpdate == null) {
            return null;
        }

        toUpdate.setTitle(ticket.getTitle());
        toUpdate.setDescription(ticket.getDescription());
        toUpdate.setStatus(ticket.getStatus());
        toUpdate.setEffectiveResolutionDate(ticket.getEffectiveResolutionDate());
        this.repository.update(toUpdate);
        return toUpdate;
    }
}