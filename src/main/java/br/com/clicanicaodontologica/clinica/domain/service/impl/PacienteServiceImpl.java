package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Paciente;
import br.com.clicanicaodontologica.clinica.domain.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Override
    public List<Paciente> criarPaciente(Paciente paciente) {
        return null;
    }

    @Override
    public List<Paciente> buscarPaciente() {
        return null;
    }

    @Override
    public Paciente buscarPacientePorId(UUID id) {
        return null;
    }

    @Override
    public Paciente atualizarPaciente(UUID id) {
        return null;
    }

    @Override
    public void deletePaciente(UUID id) {

    }
}
