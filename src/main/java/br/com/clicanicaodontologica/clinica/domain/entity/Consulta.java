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
    @ManyToOne
    @JoinColumn(
            name = "paciente_id",
            foreignKey =
            @ForeignKey(name = "fk_consulta_paciente")
    )
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(
            name = "clinica_id",
            foreignKey =
            @ForeignKey(name = "fk_consulta_clinica")
    )
    private Clinica clinica;
    @ManyToOne
    @JoinColumn(
            name = "dentista_id",
            foreignKey =
            @ForeignKey(name = "fk_consulta_dentista")
    )
    private Dentista dentista;
    private Instant dataConsulta;
    private Instant criadoEm;
    private Instant atualizadoEm;
    private String descricao;
    private Boolean cancelada;
    @Column(length = 80)
    private String motivoCancelamento;
}
