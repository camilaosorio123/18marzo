package dev.cami.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class Ticket {
    private Long id;
    private String description;
    private String status;
    private String total;
}
