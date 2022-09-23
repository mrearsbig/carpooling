package com.mrearsbig.carpooling.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class AvisoCorreoNoEncontrado {
    @ResponseBody
    @ExceptionHandler(ExcepcionCorreoNoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String avisoCorreoNoEncontrado(ExcepcionCorreoNoEncontrado correoNoEncontrado) {
        return correoNoEncontrado.getMessage();
    }
}
