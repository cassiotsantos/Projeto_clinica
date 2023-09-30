package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Paciente;
import br.com.clicanicaodontologica.clinica.domain.repository.PacienteRepository;
import br.com.clicanicaodontologica.clinica.domain.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> criarPaciente(List<Paciente> paciente) {

        return pacienteRepository.saveAll(paciente);
    }

    @Override
    public List<Paciente> buscarPaciente(String termo) {
        return pacienteRepository.findByNomeStartingWith(termo);
    }

    @Override
    public Paciente buscarPacientePorId(UUID id) {
        return pacienteRepository.findById(id).orElseThrow();
    }

    @Override
    public Paciente atualizarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletePaciente(UUID id) {
        pacienteRepository.deleteById(id);

    }
}
