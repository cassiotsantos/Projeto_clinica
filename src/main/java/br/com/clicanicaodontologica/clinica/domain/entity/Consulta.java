package br.com.clicanicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name= "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Paciente paciente;
    private Clinica clinica;
    private Instant dataConsulta;
    private Instant criadoEm;
    private Instant atualizadoEm;
    private String descricao;
    private Boolean cancelada;
    @Column(length = 80)
    private String motivoCancelamento;
}
