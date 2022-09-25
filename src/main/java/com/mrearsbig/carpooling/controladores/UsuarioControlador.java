package com.mrearsbig.carpooling.controladores;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrearsbig.carpooling.modelos.Usuario;
import com.mrearsbig.carpooling.servicios.UsuarioServicio;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioControlador {
    private UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.crearUsuario(usuario);
    }

    @GetMapping("/{correo}")
    public Optional<Usuario> obtenerUsuario(@PathVariable String correo) {
        return usuarioServicio.obtenerUsuario(correo);
    }
}
