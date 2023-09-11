package br.com.clicanicaodontologica.clinica.domain.service;

import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {
    List<Endereco> criarEndereco(List<Endereco> endereco);
    List<Endereco> buscarEndereco();
    Endereco buscarEnderecoPorId(UUID id);
    Endereco atualizarEndereco(Endereco endereco);
    void deleteEndereco(UUID id);
}
