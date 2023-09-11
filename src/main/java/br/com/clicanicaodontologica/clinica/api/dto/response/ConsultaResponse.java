package br.com.clicanicaodontologica.clinica.api.dto.response;

import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinica.domain.entity.Paciente;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ConsultaResponse {
    private Paciente paciente;
    private Clinica clinica;
    private Instant dataConsulta;
    private Instant criadoEm;
    private Instant atualizadoEm;
    private String descricao;
    private Boolean cancelada;
    private String motivoCancelamento;
}
