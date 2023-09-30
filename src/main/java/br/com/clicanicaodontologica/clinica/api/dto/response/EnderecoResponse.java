package br.com.clicanicaodontologica.clinica.api.dto.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class EnderecoResponse {
    private String logradouro;
    private String bairro;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private String cidade;
    private String estado;
    private String cep;
}
