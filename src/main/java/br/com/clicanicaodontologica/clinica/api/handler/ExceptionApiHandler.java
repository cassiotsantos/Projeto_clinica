package br.com.clicanicaodontologica.clinica.api.handler;

import br.com.clicanicaodontologica.clinica.domain.exception.BadRequestResponseNotFound;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionApiHandler {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Problem> notFoundExpeptionHandler(NoHandlerFoundException e) {
        String message = "ID não encontrado";
        Problem problem = new Problem(HttpStatus.NOT_FOUND.value(), message, e.getMessage());
        return ResponseEntity.ok().body(problem);
    }

    @ExceptionHandler(BadRequestResponseNotFound.class)
    public ResponseEntity<Problem> badRequestResponseNotFound(BadRequestResponseNotFound e) {
        String message = "CNPJ não encontrado";
        Problem problem = new Problem(HttpStatus.BAD_REQUEST.value(), message,e.getMessage());
        return ResponseEntity.ok().body(problem);
    }


}
