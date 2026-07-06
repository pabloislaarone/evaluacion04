package com.tecsup.mshistorial.controller;

import com.tecsup.mshistorial.model.HistorialEntry;
import com.tecsup.mshistorial.service.HistorialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping
    public List<HistorialEntry> listarTodos() {
        return historialService.listarTodos();
    }

    @GetMapping("/ticket/{ticketId}")
    public List<HistorialEntry> listarPorTicket(@PathVariable Long ticketId) {
        return historialService.listarPorTicket(ticketId);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody HistorialEntry entrada) {
        try {
            HistorialEntry creada = historialService.registrarEntrada(entrada);
            return ResponseEntity.status(HttpStatus.CREATED).body(creada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("mensaje", e.getMessage()));
        }
    }
}