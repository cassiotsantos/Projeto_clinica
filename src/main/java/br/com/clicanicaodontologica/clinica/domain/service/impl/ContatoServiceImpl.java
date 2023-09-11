package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.service.ContatoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContatoServiceImpl implements ContatoService {
    @Override
    public List<Contato> criarContato(Contato contato) {
        return null;
    }

    @Override
    public List<Contato> buscarContato() {
        return null;
    }

    @Override
    public Contato buscarContatoPorId(UUID id) {
        return null;
    }

    @Override
    public Contato atualizarContato(UUID id) {
        return null;
    }

    @Override
    public void deleteContato(UUID id) {

    }
}
