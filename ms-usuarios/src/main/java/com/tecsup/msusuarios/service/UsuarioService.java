package com.tecsup.msusuarios.service;

import com.tecsup.msusuarios.model.Usuario;
import com.tecsup.msusuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario datosNuevos) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(datosNuevos.getNombre());
            usuario.setEmail(datosNuevos.getEmail());
            usuario.setRol(datosNuevos.getRol());
            if (datosNuevos.getPassword() != null && !datosNuevos.getPassword().isBlank()) {
                usuario.setPassword(datosNuevos.getPassword());
            }
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Usuario> login(String email, String password) {
        return usuarioRepository.findByEmail(email)
                .filter(usuario -> usuario.getPassword().equals(password));
    }
}