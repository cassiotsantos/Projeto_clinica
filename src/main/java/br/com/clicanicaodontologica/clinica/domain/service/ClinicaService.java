package br.com.clicanicaodontologica.clinica.domain.service;

import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.UUID;

public interface ClinicaService {
    List<Clinica> criarClinica(Clinica clinica);
    List<Clinica> buscarClinica();
    Clinica buscarClinicaPorId(UUID id);
    Clinica atualizarClinica(UUID id);
    void deleteClinica(UUID id);

}
