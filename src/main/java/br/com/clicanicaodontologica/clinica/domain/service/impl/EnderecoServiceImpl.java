package br.com.clicanicaodontologica.clinica.domain.service.impl;

import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinica.domain.repository.EnderecoRepository;
import br.com.clicanicaodontologica.clinica.domain.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<Endereco> criarEndereco(List<Endereco> endereco) {
        return enderecoRepository.saveAll(endereco);
    }

    @Override
    public List<Endereco> buscarEndereco() {

        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarEnderecoPorId(UUID id) {
        return enderecoRepository.findById(id).orElseThrow();
    }

    @Override
    public Endereco atualizarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void deleteEndereco(UUID id) {
        enderecoRepository.deleteById(id);

    }
}
