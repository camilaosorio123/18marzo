package dev.cami.ticket.repository;

import dev.cami.ticket.model.Ticket;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository

public class TicketRepository {
    List<Ticket> tickets;

    long currentId = 1L;

    public TicketRepository() {
        tickets = new ArrayList<>();
        tickets.add(new Ticket(currentId++, "TICKET 1", "TICKET 1", "NEW", LocalDateTime.now(),
                null, null));
        tickets.add(new Ticket(currentId++, "TICKET 2", "TICKET 2", "NEW", LocalDateTime.now(),
                null, null));
    }


    public List<Ticket> getAll() {
        return tickets;
    }

    public Ticket save(Ticket newTicket) {
        newTicket.setId(currentId++);

        tickets.add(newTicket);
        return newTicket;
    }

    public boolean existByTitle(String aTitle) {
        for (Ticket ticket : tickets) {
            if (ticket.getTitle().equals(aTitle)) {
                return true;
            }

        }
        return false;
    }

}


