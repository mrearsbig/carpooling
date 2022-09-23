package com.mrearsbig.carpooling.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class AvisoCampoInvalido {
    @ResponseBody
    @ExceptionHandler(ExcepcionCampoInvalido.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String avisoCampoInvalido(ExcepcionCampoInvalido campoInvalido) {
        return campoInvalido.getMessage();
    }
}
