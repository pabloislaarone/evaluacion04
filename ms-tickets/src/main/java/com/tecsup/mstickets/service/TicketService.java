package com.tecsup.mstickets.service;

import com.tecsup.mstickets.client.UsuarioClient;
import com.tecsup.mstickets.dto.UsuarioDTO;
import com.tecsup.mstickets.model.Ticket;
import com.tecsup.mstickets.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public List<Ticket> listarTodos() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> buscarPorId(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket crear(Ticket ticket) {
        // Valida que el creador exista en ms-usuarios via Feign
        UsuarioDTO creador = usuarioClient.obtenerUsuarioPorId(ticket.getCreadorId());
        if (creador == null) {
            throw new RuntimeException("El usuario creador no existe");
        }
        return ticketRepository.save(ticket);
    }

    public Ticket actualizarEstado(Long id, String nuevoEstado) {
        return ticketRepository.findById(id).map(ticket -> {
            ticket.setEstado(nuevoEstado);
            return ticketRepository.save(ticket);
        }).orElse(null);
    }

    public Ticket asignarResponsable(Long id, Long responsableId) {
        // Valida que el responsable exista en ms-usuarios via Feign
        UsuarioDTO responsable = usuarioClient.obtenerUsuarioPorId(responsableId);
        if (responsable == null) {
            throw new RuntimeException("El usuario responsable no existe");
        }
        return ticketRepository.findById(id).map(ticket -> {
            ticket.setResponsableId(responsableId);
            ticket.setEstado("EN_PROCESO");
            return ticketRepository.save(ticket);
        }).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Ticket> listarPorEstado(String estado) {
        return ticketRepository.findByEstado(estado);
    }
}