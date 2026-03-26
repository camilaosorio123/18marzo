package dev.cami.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt; //recomendada para el manejo de fechas
    private LocalDate estimatedResolutionTime;
    private LocalDateTime effectiveResolutionTime;
}
