package com.tecsup.mshistorial.client;

import com.tecsup.mshistorial.dto.TicketDTO;
import org.springframework.stereotype.Component;

@Component
public class TicketClientFallback implements TicketClient {

    @Override
    public TicketDTO obtenerTicketPorId(Long id) {
        System.out.println("FALLBACK ACTIVADO: No fue posible consultar el servicio de tickets. Intente nuevamente.");
        return null;
    }
}