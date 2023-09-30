package br.com.clicanicaodontologica.clinica.domain.service;

import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinica.domain.entity.Paciente;

import java.util.List;
import java.util.UUID;

public interface PacienteService {

    List<Paciente> criarPaciente(List<Paciente> paciente);
    List<Paciente> buscarPaciente(String termo);
    Paciente buscarPacientePorId(UUID id);
    Paciente atualizarPaciente(Paciente paciente);
    void deletePaciente(UUID id);
}
