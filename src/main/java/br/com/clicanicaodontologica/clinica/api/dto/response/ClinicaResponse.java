package br.com.clicanicaodontologica.clinica.api.dto.response;

import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class ClinicaResponse {
    private Set<Dentista> clinicaDentista;
    private String name;
    @CNPJ
    private String cnpj;
    private String razaoSocial;
    private Instant criadoEm;
    private String descricao;
    private Endereco endereco;
    private Contato contato;
}
