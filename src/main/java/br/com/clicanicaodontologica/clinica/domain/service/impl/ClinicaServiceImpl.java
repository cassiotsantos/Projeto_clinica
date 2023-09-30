package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.api.dto.request.ClinicaRequest;
import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinica.domain.exception.BadRequestContatoException;
import br.com.clicanicaodontologica.clinica.domain.exception.BadRequestResponseCNPJNotFound;
import br.com.clicanicaodontologica.clinica.domain.exception.NotFoundException;
import br.com.clicanicaodontologica.clinica.domain.repository.ClinicaRepository;
import br.com.clicanicaodontologica.clinica.domain.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

          for (Clinica clinicaAtual : clinica ){
             boolean cnpjCadastrado = clinicaRepository.existsByCnpj(clinicaAtual.getCnpj());
              if (cnpjCadastrado) {
                  throw new BadRequestResponseCNPJNotFound(clinicaAtual.getCnpj());
              }  if(clinicaAtual.getContato().getEmail() == null && clinicaAtual.getContato().getTelefone() == null){
                    throw new BadRequestContatoException();
              }
         }
        return clinicaRepository.saveAll(clinica); }

    @Override
    public List<Clinica> buscarClinica(String termo) {
        return clinicaRepository.findByNameStartingWith(termo);
    }
    @Override
    public Clinica buscarClinicaPorId(UUID id) {
        try{ return clinicaRepository.findById(id).orElseThrow();}
        catch (Exception e){throw new NotFoundException(id);
        }};

    @Override
    public Clinica atualizarClinica(UUID id, Clinica clinica) {
        try{ clinicaRepository.findById(id).orElseThrow();
        } catch (Exception e) {throw new NotFoundException(id);
        }
        return clinicaRepository.save(clinica);    }

    @Override
    public void deleteClinica(UUID id) {
        try{clinicaRepository.findById(id).orElseThrow();
            clinicaRepository.deleteById(id);}
        catch(Exception e){ throw new NotFoundException(id);}
    }
}
