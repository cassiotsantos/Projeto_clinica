package br.com.clicanicaodontologica.clinica.api.dto.response;

import br.com.clicanicaodontologica.clinica.domain.entity.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
public class DentistaResponse {
    private UUID id;
    private String cro;
    private String nome;
    private LocalDate dataNascimento;
    private EspecialidadeEnum especialidadeEnum;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private SexoEnum sexoEnum;
    private ContatoResponse contato;
    private Set<Clinica> consultas;
}
