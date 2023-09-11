package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinica.domain.service.ClinicaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicaServiceImpl implements ClinicaService {
    @Override
    public List<Clinica> criarClinica(Clinica clinica) {
        return null;
    }

    @Override
    public List<Clinica> buscarClinica() {
        return null;
    }

    @Override
    public Clinica buscarClinicaPorId(UUID id) {
        return null;
    }

    @Override
    public Clinica atualizarClinica(UUID id) {
        return null;
    }

    @Override
    public void deleteClinica(UUID id) {

    }
}
