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
@Table(name= "dentistas")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cro;
    private String nome;
    private Instant dataNascimento;
    @Column(length = 80)
    private EspecialidadeEnum especialidadeEnum;
    private Instant criadoEm;
    private Instant atualizadoEm;
    private SexoEnum sexoEnum;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato" ,
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_contato_dentista"))
    private Contato contato;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dentistas_clinicas",
         joinColumns =
         @JoinColumn(name = "id_dentista"),
         inverseJoinColumns =
         @JoinColumn(name="id_clinica")
    )
    private Set<Clinica> dentistasClinicas;

}
