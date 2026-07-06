package com.tecsup.mshistorial.repository;

import com.tecsup.mshistorial.model.HistorialEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialRepository extends JpaRepository<HistorialEntry, Long> {
    List<HistorialEntry> findByTicketIdOrderByFechaRegistroAsc(Long ticketId);
}