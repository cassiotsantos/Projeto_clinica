package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.exception.BadRequestResponseConsultaException;
import br.com.clicanicaodontologica.clinica.domain.exception.NotFoundException;
import br.com.clicanicaodontologica.clinica.domain.repository.ConsultaRepository;
import br.com.clicanicaodontologica.clinica.domain.service.ConsultaService;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        for(Consulta consultaAtual : consulta) {
            if (consultaAtual.getDataConsulta().isBefore(LocalDate.now())) {
                throw new BadRequestResponseConsultaException(consultaAtual.getDataConsulta());
            }
        }
        return consultaRepository.saveAll(consulta);
    }

    @Override
    public List<Consulta> buscarConsulta() {
        return consultaRepository.findAll();
    }

    @Override
    public Consulta buscarConsultaPorId(UUID id) {
        try {
            return consultaRepository.findById(id).orElseThrow();
        }catch (Exception e){
            throw new NotFoundException(id);
        }
    }

    @Override
    public Consulta atualizarConsulta(UUID id, Consulta consulta) {

        try {
            consultaRepository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new NotFoundException(id);
        }
        return consultaRepository.save(consulta);
    }

    @Override
    public void deleteConsulta(UUID id) {
        try{
            consultaRepository.findById(id).orElseThrow();
            consultaRepository.deleteById(id);

        }catch (Exception e){
            throw new NotFoundException(id);
        }
    }
}
