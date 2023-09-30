package br.com.clicanicaodontologica.clinica.api.dto.response.wrapperResponse;

import br.com.clicanicaodontologica.clinica.api.dto.response.listResponse.DentistaListResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.listResponse.PacienteListResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PacienteWrapperResponse {
    private List<PacienteListResponse> pacientes;
}

