package br.com.clicanicaodontologica.clinica.api.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ContatoRequest {
    private UUID id;
    private String email;
    private String telefone;
    private Instant criadoEm;
    private Instant atualizadoEm;


}
