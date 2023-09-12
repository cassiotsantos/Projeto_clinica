package br.com.clicanicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name= "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    private String nome;
    private Instant dataNascimento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco" ,
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_endereco_paciente"))
    private Endereco endereco;
    private Instant criadoEm;
    private Instant atualizadoEm;
    private SexoEnum sexoEnum;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato" ,
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_contato_paciente"))
    private Contato contato;
}
