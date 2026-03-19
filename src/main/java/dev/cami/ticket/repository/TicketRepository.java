package dev.cami.ticket.repository;

import dev.cami.ticket.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class TicketRepository {
    List<Ticket> tickets;

    public  TicketRepository(){
        tickets = new ArrayList<>();
        tickets.add(new Ticket(1L,"TICKET 1","TICKET 1","NEW"));
        tickets.add(new Ticket(2L,"TICKET 2","TICKET 2","NEW"));



    }
    public List<Ticket> getAll(){
        return tickets;
    }


}
