package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.repository.DentistaRepository;
import br.com.clicanicaodontologica.clinica.domain.service.DentistaService;
import org.springframework.stereotype.Service;

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

        return dentistaRepository.saveAll(dentista);
    }

    @Override
    public List<Dentista> buscarDentista() {
        return dentistaRepository.findAll();
    }

    @Override
    public Dentista buscarDentistaPorId(UUID id) {

        return dentistaRepository.findById(id).orElseThrow();
    }

    @Override
    public Dentista atualizarDentista(Dentista dentista) {

        return dentistaRepository.save(dentista);
    }

    @Override
    public void deleteDentista(UUID id) {
        dentistaRepository.deleteById(id);

    }
}
