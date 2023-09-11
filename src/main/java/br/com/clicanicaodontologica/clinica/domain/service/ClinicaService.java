package br.com.clicanicaodontologica.clinica.domain.service;

import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClinicaService {
    List<Clinica> criarClinica(List<Clinica> clinica);
    List<Clinica> buscarClinica();
    Clinica buscarClinicaPorId(UUID id);
    Clinica atualizarClinica(Clinica clinica);
    void deleteClinica(UUID id);

}
