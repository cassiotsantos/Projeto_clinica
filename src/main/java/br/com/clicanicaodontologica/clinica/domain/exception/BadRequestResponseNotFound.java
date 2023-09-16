package br.com.clicanicaodontologica.clinica.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestResponseNotFound extends RuntimeException {

    public BadRequestResponseNotFound (String cnpj){super("CNPJ: %s já existe".formatted(cnpj));}

}
