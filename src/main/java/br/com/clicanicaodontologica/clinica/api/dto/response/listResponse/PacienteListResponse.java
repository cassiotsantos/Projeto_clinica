package br.com.clicanicaodontologica.clinica.api.dto.response.listResponse;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class PacienteListResponse {
    private UUID id;
    private String nome;
}
