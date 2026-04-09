package dev.cami.ticket.repository;

import dev.cami.ticket.model.Ticket;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class TicketRepository {

    Map<Long, Ticket> tickets;

    long currentId = 0L;

    public TicketRepository() {
        tickets = new HashMap<>();
        tickets.put(currentId,
                new Ticket(currentId++,
                "Ticket 1",
                "Ticket 1",
                "NEW",
                LocalDateTime.now(),
                null,
                null));
        tickets.put(currentId,
                new Ticket(currentId++,
                "Ticket 2",
                "Ticket 2",
                "NEW",
                LocalDateTime.now(),
                null,
                null));
    }

    public List<Ticket> getAll() {
        return tickets
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .toList();
    }

    public Ticket save(Ticket newTicket) {
        newTicket.setId(currentId);
        tickets.put(currentId++, newTicket);
        return newTicket;
    }

    public boolean existsByTitle(String aTitle) {
//        for (Ticket ticket : tickets) {
//            if (ticket.getTitle().equals(aTitle)) {
//                return true;
//            }
//        }

        return tickets.entrySet()
                .stream()
                .anyMatch(e -> e.getValue().getTitle().equals(aTitle));
    }

    public Optional<Ticket> getById(Long id) {
//        for (Ticket ticket : tickets) {
//            if (ticket.getId().equals(id)) {
//                return ticket;
//            }
//        }
//        return null;

        //optional : se usa para metodos que podrían retornar nulo
        return Optional.ofNullable(tickets.get(id));
    }

    public Optional<Ticket> deleteById(Long id) {
//        for (Ticket ticket : tickets) {
//            if (ticket.getId().equals(id)) {
//                tickets.remove(ticket);
//                return ticket;
//            }
//        }
//        return null;
        return Optional.ofNullable(tickets.remove(id));

    }

    public void update(Ticket toUpdate) {
//        Ticket f = getById(toUpdate.getId());
//        int index = tickets.indexOf(f);
//        tickets.set(index, toUpdate);

        Optional<Ticket> found = getById(toUpdate.getId());
        if (found.isPresent()) {
            tickets.replace(found.get().getId(), toUpdate);
        }
    }
}