package br.com.clicanicaodontologica.clinica.domain.service;

import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;

import java.util.List;
import java.util.UUID;

public interface ConsultaService {

    List<Consulta> criarConsulta(List<Consulta> consulta);
    List<Consulta> buscarConsulta();
    Consulta buscarConsultaPorId(UUID id);
    Consulta atualizarConsulta(UUID id, Consulta consulta);
    void deleteConsulta(UUID id);
}
