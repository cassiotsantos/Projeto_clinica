package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinica.domain.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Override
    public List<Endereco> criarEndereco(Endereco endereco) {
        return null;
    }

    @Override
    public List<Endereco> buscarEndereco() {
        return null;
    }

    @Override
    public Endereco buscarEnderecoPorId(UUID id) {
        return null;
    }

    @Override
    public Endereco atualizarEndereco(UUID id) {
        return null;
    }

    @Override
    public void deleteEndereco(UUID id) {

    }
}
