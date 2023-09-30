package br.com.clicanicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDate dataNascimento;
    @Column(length = 80)
    private EspecialidadeEnum especialidadeEnum;
    @Column(updatable = false)
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
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

    @PrePersist
    public void naCriacao() {
        this.criadoEm = LocalDateTime.now();
    }
    @PreUpdate
    public void naAtualizacao() {
        this.atualizadoEm = LocalDateTime.now();
    }

}
