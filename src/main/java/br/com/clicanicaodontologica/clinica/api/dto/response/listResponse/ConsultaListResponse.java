package br.com.clicanicaodontologica.clinica.api.dto.response.listResponse;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ConsultaListResponse {
    private UUID id;
    private LocalDate dataConsulta;

}
