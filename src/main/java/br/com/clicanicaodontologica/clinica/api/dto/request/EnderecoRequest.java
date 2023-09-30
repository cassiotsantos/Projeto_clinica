package br.com.clicanicaodontologica.clinica.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Setter
@Getter
public class EnderecoRequest {
    private String logradouro;
    private String bairro;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private String cidade;
    private String estado;
    private String cep;
}
