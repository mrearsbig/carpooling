package com.mrearsbig.carpooling.servicios;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mrearsbig.carpooling.excepciones.ExcepcionCampoInvalido;
import com.mrearsbig.carpooling.excepciones.ExcepcionCorreoNoEncontrado;
import com.mrearsbig.carpooling.fabrica.UsuarioFabrica;
import com.mrearsbig.carpooling.modelos.Usuario;
import com.mrearsbig.carpooling.repositorios.UsuarioRepositorioInterfaz;

@ExtendWith(SpringExtension.class)
public class UsuarioServicioTest {
    @InjectMocks
    private UsuarioServicio usuarioServicio;

    @Mock
    private UsuarioRepositorioInterfaz usuarioRepositorioInterfaz;

    @Test
    void debeCrearUnUsuario() {
        // Given
        Usuario usuario = UsuarioFabrica.usuario();

        // When
        when(usuarioRepositorioInterfaz.save(any())).thenReturn(usuario);

        usuarioServicio.crearUsuario(usuario);

        // Then
        verify(usuarioRepositorioInterfaz).save(any());
    }

    @Test
    void lanzaExcepcionCampoInvalidoCuandoElUsuarioTieneCamposInvalidos() {
        // Given
        Usuario usuario = UsuarioFabrica.usuarioInvalido();

        // When
        when(usuarioRepositorioInterfaz.save(any())).thenReturn(usuario);

        // Then
        assertThrows(
            ExcepcionCampoInvalido.class,
            () -> {
                usuarioServicio.crearUsuario(usuario);
            }
        );
    }

    @Test
    void debeObtenerUnUsuario() {
        // Given
        Usuario usuario = UsuarioFabrica.usuario();

        // When
        when(usuarioRepositorioInterfaz.findByCorreo(anyString())).thenReturn(Optional.of(usuario));

        usuarioServicio.obtenerUsuario(anyString());

        // Then
        verify(usuarioRepositorioInterfaz).findByCorreo(anyString());
    }

    @Test
    void lanzaExcepcionCorreoNoEncontradoCuandoNoExisteUsuario() {
        // When
        when(usuarioRepositorioInterfaz.findByCorreo(anyString())).thenReturn(Optional.empty());

        // Then
        assertThrows(
            ExcepcionCorreoNoEncontrado.class,
            () -> {
                usuarioServicio.obtenerUsuario(anyString());
            }
        );
    }
}
