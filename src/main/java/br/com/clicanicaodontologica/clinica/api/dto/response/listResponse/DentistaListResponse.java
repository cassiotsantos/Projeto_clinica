package br.com.clicanicaodontologica.clinica.api.dto.response.listResponse;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DentistaListResponse {

    private UUID id;
    private String cro;
    private String nome;

}
