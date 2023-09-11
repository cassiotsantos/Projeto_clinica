package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.repository.ConsultaRepository;
import br.com.clicanicaodontologica.clinica.domain.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public List<Consulta> criarConsulta(List<Consulta> consulta) {

        return consultaRepository.saveAll(consulta);
    }

    @Override
    public List<Consulta> buscarConsulta() {

        return consultaRepository.findAll();
    }

    @Override
    public Consulta buscarConsultaPorId(UUID id) {

        return consultaRepository.findById(id).orElseThrow();
    }

    @Override
    public Consulta atualizarConsulta(Consulta consulta) {

        return consultaRepository.save(consulta);
    }

    @Override
    public void deleteConsulta(UUID id) {
        consultaRepository.deleteById(id);

    }
}
