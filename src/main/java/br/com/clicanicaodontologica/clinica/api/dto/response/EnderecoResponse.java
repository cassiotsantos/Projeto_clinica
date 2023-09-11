package br.com.clicanicaodontologica.clinica.api.dto.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class EnderecoResponse {
    private String logradouro;
    private String bairro;
    private Instant criadoEm;
    private Instant atualizadoEm;
    private String cidade;
    private String estado;
    private String cep;
}
