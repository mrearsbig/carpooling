package com.mrearsbig.carpooling.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrearsbig.carpooling.modelos.Usuario;

public interface UsuarioRepositorioInterfaz extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}
