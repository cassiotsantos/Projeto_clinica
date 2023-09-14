package br.com.clicanicaodontologica.clinica.api.controller;

import br.com.clicanicaodontologica.clinica.api.dto.request.ClinicaRequest;
import br.com.clicanicaodontologica.clinica.api.dto.response.ClinicaResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.ContatoResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.EnderecoResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.listResponse.ClinicaListResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.wrapperResponse.ClinicaWrapperResponse;
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
import java.util.UUID;

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

    @GetMapping("{id}")
    ResponseEntity<ClinicaResponse> buscarClinicaPorId(@PathVariable UUID id){
        Clinica clinica = clinicaService.buscarClinicaPorId(id);
        ClinicaResponse response = clinicaResponseByClinica(clinica);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    ResponseEntity<ClinicaWrapperResponse> buscarClinica(){
        List<Clinica> clinicas = clinicaService.buscarClinica();
        ClinicaWrapperResponse clinicaWrapperResponse = new ClinicaWrapperResponse();
        clinicaWrapperResponse.setClinicas(clinicas.stream().map( clinica -> {
            ClinicaListResponse clinicaListResponse = new ClinicaListResponse();
            clinicaListResponse.setId(clinica.getId());
            clinicaListResponse.setName(clinica.getName());
            clinicaListResponse.setCnpj(clinica.getCnpj());
            return clinicaListResponse;
        }).toList());
        return ResponseEntity.ok(clinicaWrapperResponse);    }

        @PutMapping("{id}")
        ResponseEntity<?>atualizarClinica(@PathVariable UUID id,@RequestBody @Valid ClinicaRequest request){

        Clinica clinica = clinicaService.buscarClinicaPorId(id);
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

        Clinica atualizarClinica = clinicaService.atualizarClinica(clinica);
        return ResponseEntity.ok(atualizarClinica);
        }

        @DeleteMapping("{id}")
        ResponseEntity<Void> deleteClinica(@PathVariable UUID id){
        clinicaService.deleteClinica(id);
        return ResponseEntity.ok().build();
        }



    private ClinicaResponse clinicaResponseByClinica(Clinica clinica) {

        ClinicaResponse clinicaResponse = new ClinicaResponse();
        clinicaResponse.setName(clinica.getName());;
        clinicaResponse.setCnpj(clinica.getCnpj());
        clinicaResponse.setRazaoSocial(clinica.getRazaoSocial());
        clinicaResponse.setDescricao(clinica.getDescricao());
        clinicaResponse.setId(clinica.getId());

        ContatoResponse contatoResponse = new ContatoResponse();
        contatoResponse.setEmail(clinica.getContato().getEmail());
        contatoResponse.setTelefone(clinica.getContato().getTelefone());

        EnderecoResponse enderecoResponse = new EnderecoResponse();
        enderecoResponse.setLogradouro(clinica.getEndereco().getLogradouro());
        enderecoResponse.setBairro(clinica.getEndereco().getBairro());
        enderecoResponse.setCidade(clinica.getEndereco().getCidade());
        enderecoResponse.setEstado(clinica.getEndereco().getEstado());
        enderecoResponse.setCep(clinica.getEndereco().getCep());

        clinicaResponse.setContato(contatoResponse);
        clinicaResponse.setEndereco(enderecoResponse);
        return clinicaResponse;

    }







}
