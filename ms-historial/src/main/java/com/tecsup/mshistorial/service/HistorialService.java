package com.tecsup.mshistorial.service;

import com.tecsup.mshistorial.client.TicketClient;
import com.tecsup.mshistorial.dto.TicketDTO;
import com.tecsup.mshistorial.model.HistorialEntry;
import com.tecsup.mshistorial.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    private TicketClient ticketClient;

    public HistorialEntry registrarEntrada(HistorialEntry entrada) {
        // Valida que el ticket exista en ms-tickets via Feign
        TicketDTO ticket = ticketClient.obtenerTicketPorId(entrada.getTicketId());
        if (ticket == null) {
            throw new RuntimeException("El ticket especificado no existe");
        }
        return historialRepository.save(entrada);
    }

    public List<HistorialEntry> listarPorTicket(Long ticketId) {
        return historialRepository.findByTicketIdOrderByFechaRegistroAsc(ticketId);
    }

    public List<HistorialEntry> listarTodos() {
        return historialRepository.findAll();
    }
}