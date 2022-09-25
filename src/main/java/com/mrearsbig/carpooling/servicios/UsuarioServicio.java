package com.mrearsbig.carpooling.servicios;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.mrearsbig.carpooling.excepciones.ExcepcionCampoInvalido;
import com.mrearsbig.carpooling.excepciones.ExcepcionCorreoNoEncontrado;
import com.mrearsbig.carpooling.modelos.Usuario;
import com.mrearsbig.carpooling.repositorios.UsuarioRepositorioInterfaz;

@Service
public class UsuarioServicio {
    private UsuarioRepositorioInterfaz usuarioRepositorioInterfaz;

    public UsuarioServicio(UsuarioRepositorioInterfaz usuarioRepositorioInterfaz) {
        super();
        this.usuarioRepositorioInterfaz = usuarioRepositorioInterfaz;
    }

    public Usuario crearUsuario(Usuario usuario) {
        Boolean esValidoCorreo = Pattern.compile(
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
            ).matcher(usuario.getCorreo()).matches();

        Boolean esValidaContraseña = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,15}$"
            ).matcher(usuario.getContraseña()).matches();

        if (!esValidoCorreo) {
            throw new ExcepcionCampoInvalido("El correo no es valido");
        }

        if (!esValidaContraseña) {
            throw new ExcepcionCampoInvalido("La contraseña no es valida");
        }

        return usuarioRepositorioInterfaz.save(usuario);
    }

    public Optional<Usuario> obtenerUsuario(String correo) {
        Optional<Usuario> usuario = usuarioRepositorioInterfaz.findByCorreo(correo);

        if (!usuario.isPresent()) {
            throw new ExcepcionCorreoNoEncontrado("No existe un usuario con ese correo");
        }
        
        return usuario;
    }
}
