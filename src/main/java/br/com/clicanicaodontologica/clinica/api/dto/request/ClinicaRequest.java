package br.com.clicanicaodontologica.clinica.api.dto.request;

import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.Instant;
import java.util.Set;


@Setter
@Getter
public class ClinicaRequest {
    @NotBlank
    private String name;
    @CNPJ
    private String cnpj;
    @NotNull
    @JsonAlias(value = "razao_social")
    private String razaoSocial;
    @NotNull
    private String descricao;
    @NotNull
    private EnderecoRequest endereco;
    @NotNull
    private ContatoRequest contato;
}
