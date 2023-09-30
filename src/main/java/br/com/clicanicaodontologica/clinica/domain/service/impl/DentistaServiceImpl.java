package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.exception.BadRequestContatoException;
import br.com.clicanicaodontologica.clinica.domain.exception.BadRequestResponseConsultaException;
import br.com.clicanicaodontologica.clinica.domain.exception.NotFoundException;
import br.com.clicanicaodontologica.clinica.domain.repository.DentistaRepository;
import br.com.clicanicaodontologica.clinica.domain.service.DentistaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class DentistaServiceImpl implements DentistaService {

    private final DentistaRepository dentistaRepository;

    public DentistaServiceImpl(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    @Override
    public List<Dentista> criarDentista(List<Dentista> dentista) {

        for(Dentista dentistaAtual : dentista) {

            if(dentistaAtual.getContato().getEmail() == null && dentistaAtual.getContato().getTelefone() == null){

                throw new BadRequestContatoException();
            }
        }

        return dentistaRepository.saveAll(dentista);
    }

    @Override
    public List<Dentista> buscarDentista(String termo) {
        return dentistaRepository.findByNomeStartingWith(termo);
    }

    @Override
    public Dentista buscarDentistaPorId(UUID id) {

        try{return dentistaRepository.findById(id).orElseThrow();}
        catch (Exception e){
            throw new NotFoundException(id);
        }
    }

    @Override
    public Dentista atualizarDentista(UUID id, Dentista dentista) {

        try {
            dentistaRepository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new NotFoundException(id);
        }

        return dentistaRepository.save(dentista);
    }

    @Override
    public void deleteDentista(UUID id) {

        try{
            dentistaRepository.findById(id).orElseThrow();
            dentistaRepository.deleteById(id);

        } catch (Exception e){
            throw new NotFoundException(id);
        }

    }
}
