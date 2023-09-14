package br.com.clicanicaodontologica.clinica.api.dto.response;

import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class ClinicaResponse {
    private UUID id;
    private String name;
    @CNPJ
    private String cnpj;
    @Size(min = 5, message = "O campo deve ter pelo menos 5 caracteres.")
    private String razaoSocial;
    private Instant criadoEm;
    private Instant atualizadoEm;
    private String descricao;
    private EnderecoResponse endereco;
    private ContatoResponse contato;
}
