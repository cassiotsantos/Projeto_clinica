package br.com.clicanicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name= "contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 100)
    @Email
    private String email;
    @Column(length = 15)
    private String telefone;
    private Instant criadoEm;
    private Instant atualizadoEm;

    @PreUpdate
    public void naAtualizacao() {
        this.atualizadoEm = Instant.now();
    }
}
