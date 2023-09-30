package br.com.clicanicaodontologica.clinica.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestResponseCNPJNotFound extends RuntimeException {
    public BadRequestResponseCNPJNotFound(String cnpj){
        super("O CNPJ: %s já existe".formatted(cnpj));}

}
