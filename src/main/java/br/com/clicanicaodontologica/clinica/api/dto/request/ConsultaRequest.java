package br.com.clicanicaodontologica.clinica.api.dto.request;

import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.entity.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
public class ConsultaRequest {
    @NotNull
    private Paciente paciente;
    @NotNull
    private Clinica clinica;
    @NotNull
    private Dentista dentista;
    @NotNull
    private LocalDate dataConsulta;
    @NotEmpty
    private String descricao;
    @NotNull
    private Boolean cancelada;
    @NotNull
    private String motivoCancelamento;



}
