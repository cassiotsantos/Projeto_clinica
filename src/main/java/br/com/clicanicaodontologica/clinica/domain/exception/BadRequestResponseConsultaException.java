package br.com.clicanicaodontologica.clinica.domain.exception;

import java.time.LocalDate;

public class BadRequestResponseConsultaException extends RuntimeException{
    public BadRequestResponseConsultaException (LocalDate dataConsulta){
        super("A data: %s é anterior a data atual".formatted(dataConsulta));
    }
}
