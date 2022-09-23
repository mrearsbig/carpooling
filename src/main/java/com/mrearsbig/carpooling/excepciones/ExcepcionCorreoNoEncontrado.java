package com.mrearsbig.carpooling.excepciones;

public class ExcepcionCorreoNoEncontrado extends RuntimeException {
    public ExcepcionCorreoNoEncontrado(String mensaje) {
        super(mensaje);
    }
}
