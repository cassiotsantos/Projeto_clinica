package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Paciente;
import br.com.clicanicaodontologica.clinica.domain.exception.BadRequestContatoException;
import br.com.clicanicaodontologica.clinica.domain.exception.NotFoundException;
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

         for(Paciente pacienteAtual: paciente) {

             if(pacienteAtual.getContato().getEmail() == null && pacienteAtual.getContato().getTelefone() == null) {

                 throw new BadRequestContatoException();
             }

         }

        return pacienteRepository.saveAll(paciente);
    }

    @Override
    public List<Paciente> buscarPaciente(String termo) {

        return pacienteRepository.findByNomeStartingWith(termo);
    }

    @Override
    public Paciente buscarPacientePorId(UUID id) {

        try{return pacienteRepository.findById(id).orElseThrow();}
        catch (Exception e){
            throw new NotFoundException(id);
        }

    }

    @Override
    public Paciente atualizarPaciente(UUID id, Paciente paciente) {

        try {
            pacienteRepository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new NotFoundException(id);
        }

        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletePaciente(UUID id) {
        try{
            pacienteRepository.findById(id).orElseThrow();
            pacienteRepository.deleteById(id);

        } catch (Exception e){
            throw new NotFoundException(id);
        }

    }
}
