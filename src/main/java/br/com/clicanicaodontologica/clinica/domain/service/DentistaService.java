package br.com.clicanicaodontologica.clinica.domain.service;

import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;

import java.util.List;
import java.util.UUID;

public interface DentistaService {
    List<Dentista> criarDentista(Dentista dentista);
    List<Dentista> buscarDentista();
    Dentista buscarDentistaPorId(UUID id);
    Dentista atualizarDentista(UUID id);
    void deleteDentista(UUID id);
}
