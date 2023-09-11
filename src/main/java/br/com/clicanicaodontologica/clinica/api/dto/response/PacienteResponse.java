package br.com.clicanicaodontologica.clinica.api.dto.response;

import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinica.domain.entity.SexoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class PacienteResponse {
    private String nome;
    private Instant dataNascimento;
    private Endereco endereco;
    private Instant criadoEm;
    private Instant atualizadoEm;
    private SexoEnum sexoEnum;
    private Contato contato;
    private Set<Consulta> consultas;
}
