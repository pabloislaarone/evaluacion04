package com.tecsup.mshistorial.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "historial")
public class HistorialEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El id del ticket es obligatorio")
    @Column(name = "ticket_id", nullable = false)
    private Long ticketId;

    @NotNull(message = "El id del agente es obligatorio")
    @Column(name = "agente_id", nullable = false)
    private Long agenteId;

    @NotBlank(message = "El comentario es obligatorio")
    @Column(nullable = false, length = 1000)
    private String comentario;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    public HistorialEntry() {}

    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }

    public Long getAgenteId() { return agenteId; }
    public void setAgenteId(Long agenteId) { this.agenteId = agenteId; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}