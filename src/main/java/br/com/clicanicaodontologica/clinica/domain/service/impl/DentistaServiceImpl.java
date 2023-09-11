package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.service.DentistaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DentistaServiceImpl implements DentistaService {
    @Override
    public List<Dentista> criarDentista(Dentista dentista) {
        return null;
    }

    @Override
    public List<Dentista> buscarDentista() {
        return null;
    }

    @Override
    public Dentista buscarDentistaPorId(UUID id) {
        return null;
    }

    @Override
    public Dentista atualizarDentista(UUID id) {
        return null;
    }

    @Override
    public void deleteDentista(UUID id) {

    }
}
