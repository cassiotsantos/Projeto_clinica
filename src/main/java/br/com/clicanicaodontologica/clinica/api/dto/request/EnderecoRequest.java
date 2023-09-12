package br.com.clicanicaodontologica.clinica.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class EnderecoRequest {
    private String logradouro;
    private String bairro;
    private Instant criadoEm;
    private Instant atualizadoEm;
    private String cidade;
    private String estado;
    private String cep;
}
