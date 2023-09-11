package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinica.domain.repository.ClinicaRepository;
import br.com.clicanicaodontologica.clinica.domain.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClinicaServiceImpl implements ClinicaService {

    private final ClinicaRepository clinicaRepository;
    @Autowired
    public ClinicaServiceImpl(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    @Override
    public List<Clinica> criarClinica(List<Clinica> clinica) {
        return clinicaRepository.saveAll(clinica);
    }

    @Override
    public List<Clinica> buscarClinica() {
        return clinicaRepository.findAll();
    }
    @Override
    public Clinica buscarClinicaPorId(UUID id) {

        return clinicaRepository.findById(id).orElseThrow();
    }
    @Override
    public Clinica atualizarClinica(Clinica clinica) {

        return clinicaRepository.save(clinica);
    }
    @Override
    public void deleteClinica(UUID id) {
        clinicaRepository.deleteById(id);
    }
}
