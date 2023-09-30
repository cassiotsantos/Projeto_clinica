package br.com.clicanicaodontologica.clinica.api.dto.response.wrapperResponse;

import br.com.clicanicaodontologica.clinica.api.dto.response.listResponse.ConsultaListResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.listResponse.DentistaListResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DentistaWrapperResponse {
    private List<DentistaListResponse> dentistas;
}
