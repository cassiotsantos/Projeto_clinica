package br.com.clicanicaodontologica.clinica.api.controller;

import br.com.clicanicaodontologica.clinica.api.dto.request.ClinicaRequest;
import br.com.clicanicaodontologica.clinica.api.dto.response.ClinicaResponse;
import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinica.domain.service.ClinicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/clinicas")
public class ClinicaController {

private final ClinicaService clinicaService;

    @Autowired
    public ClinicaController(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }
    @PostMapping
    ResponseEntity<?> criarClinica(@RequestBody @Valid ClinicaRequest request) {

        Clinica clinica =new Clinica();
        clinica.setCnpj(request.getCnpj());
        clinica.setName(request.getName());
        clinica.setRazaoSocial(request.getRazaoSocial());
        clinica.setDescricao(request.getDescricao());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(request.getEndereco().getLogradouro());
        endereco.setBairro(request.getEndereco().getBairro());
        endereco.setCidade(request.getEndereco().getCidade());
        endereco.setEstado(request.getEndereco().getEstado());
        endereco.setCep(request.getEndereco().getCep());

        clinica.setContato(contato);
        clinica.setEndereco(endereco);

        List<Clinica> listaClinica = new ArrayList<Clinica>( );
        listaClinica.add(clinica);
        List<Clinica> clinicaCriada = clinicaService.criarClinica(listaClinica);

        return ResponseEntity.ok(clinicaCriada);

    }

}
