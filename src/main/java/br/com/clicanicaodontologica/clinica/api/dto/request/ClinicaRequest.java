package br.com.clicanicaodontologica.clinica.api.dto.request;

import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.Instant;
import java.util.Set;


@Setter
@Getter
public class ClinicaRequest {
    private String name;
    @CNPJ
    private String cnpj;
    private String razaoSocial;
    private String descricao;
    private EnderecoRequest endereco;
    private ContatoRequest contato;
}
