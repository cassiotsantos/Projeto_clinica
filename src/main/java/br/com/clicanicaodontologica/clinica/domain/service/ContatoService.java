package br.com.clicanicaodontologica.clinica.domain.service;

import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;

import java.util.List;
import java.util.UUID;

public interface ContatoService {

    List<Contato> criarContato(List<Contato> contato);
    List<Contato> buscarContato();
    Contato buscarContatoPorId(UUID id);
    Contato atualizarContato(Contato contato);
    void deleteContato(UUID id);
}
