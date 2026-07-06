package com.tecsup.mstickets.client;

import com.tecsup.mstickets.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioClientFallback implements UsuarioClient {

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Long id) {
        System.out.println("FALLBACK ACTIVADO: No fue posible consultar el servicio de usuarios. Intente nuevamente.");
        return null;
    }
}