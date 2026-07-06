package com.tecsup.mshistorial.client;

import com.tecsup.mshistorial.dto.TicketDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-tickets", fallback = TicketClientFallback.class)
public interface TicketClient {

    @GetMapping("/api/tickets/{id}")
    TicketDTO obtenerTicketPorId(@PathVariable("id") Long id);
}