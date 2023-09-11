package br.com.clicanicaodontologica.clinica.domain.service;

import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinica.domain.entity.Paciente;

import java.util.List;
import java.util.UUID;

public interface PacienteService {

    List<Paciente> criarPaciente(Paciente paciente);
    List<Paciente> buscarPaciente();
    Paciente buscarPacientePorId(UUID id);
    Paciente atualizarPaciente(UUID id);
    void deletePaciente(UUID id);
}
