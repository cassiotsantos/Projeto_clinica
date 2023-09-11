package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.service.ConsultaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    @Override
    public List<Consulta> criarConsulta(Consulta consulta) {
        return null;
    }

    @Override
    public List<Consulta> buscarConsulta() {
        return null;
    }

    @Override
    public Consulta buscarConsultaPorId(UUID id) {
        return null;
    }

    @Override
    public Consulta atualizarConsulta(UUID id) {
        return null;
    }

    @Override
    public void deleteConsulta(UUID id) {

    }
}
