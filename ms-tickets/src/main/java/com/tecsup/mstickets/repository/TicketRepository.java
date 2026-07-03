package com.tecsup.mstickets.repository;

import com.tecsup.mstickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByEstado(String estado);
    List<Ticket> findByResponsableId(Long responsableId);
}