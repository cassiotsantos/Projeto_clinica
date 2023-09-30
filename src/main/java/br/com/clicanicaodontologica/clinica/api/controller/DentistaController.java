package br.com.clicanicaodontologica.clinica.api.controller;

import br.com.clicanicaodontologica.clinica.api.dto.request.ClinicaRequest;
import br.com.clicanicaodontologica.clinica.api.dto.response.ClinicaResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.ConsultaResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.ContatoResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.DentistaResponse;
import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import lombok.extern.log4j.Log4j;


import br.com.clicanicaodontologica.clinica.api.dto.request.ConsultaRequest;
import br.com.clicanicaodontologica.clinica.api.dto.request.DentistaRequest;
import br.com.clicanicaodontologica.clinica.api.dto.response.listResponse.DentistaListResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.wrapperResponse.DentistaWrapperResponse;
import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.service.DentistaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/dentistas")
public class DentistaController {

    private final DentistaService dentistaService;
    private final ObjectMapper objectMapper;

    @Autowired
    public DentistaController(DentistaService dentistaService, ObjectMapper objectMapper) {
        this.dentistaService = dentistaService;
        this.objectMapper = objectMapper;
    };

    @PostMapping
    ResponseEntity<?> criarDentista(@RequestBody @Valid List<DentistaRequest> request) {
        List<Dentista> listaDentistas = new ArrayList<>();

        for (DentistaRequest requestList : request) {
            Dentista dentista = objectMapper.convertValue(requestList, Dentista.class);
            listaDentistas.add(dentista);
        };
        return ResponseEntity.ok(dentistaService.criarDentista(listaDentistas));
    }

    @GetMapping
    ResponseEntity<DentistaWrapperResponse> buscarDentista (@RequestParam(required = false) String termo) {

        List<Dentista> dentistas = dentistaService.buscarDentista(termo);
        DentistaWrapperResponse dentistaWrapperResponse = new DentistaWrapperResponse();
        dentistaWrapperResponse.setDentistas(dentistas.stream().map(dentista -> {

            DentistaListResponse dentistaListResponse = new DentistaListResponse();
            dentistaListResponse.setId(dentista.getId());
            dentistaListResponse.setCro(dentista.getCro());
            dentistaListResponse.setNome(dentista.getNome());
            return dentistaListResponse;
        }).toList());

        return ResponseEntity.ok(dentistaWrapperResponse);
    }

    @GetMapping ("{id}")
    ResponseEntity<DentistaResponse> buscarDentistaPorId (@PathVariable UUID id) {

        Dentista dentista = dentistaService.buscarDentistaPorId(id);
        DentistaResponse dentistaResponse = dentistaResponseByDentista(dentista);
        return ResponseEntity.ok(dentistaResponse);
    }

    @PutMapping("{id}")
    ResponseEntity<DentistaResponse> atualizarDentista(@PathVariable UUID id, @RequestBody @Valid DentistaRequest request) {

       Dentista dentista = dentistaService.buscarDentistaPorId(id);

       dentista.setNome(request.getNome());
       dentista.setCro(request.getCro());
       dentista.setDataNascimento(request.getDataNascimento());
       dentista.setEspecialidadeEnum(request.getEspecialidadeEnum());
       dentista.setSexoEnum(request.getSexoEnum());

       Contato contato = dentista.getContato();
       contato.setEmail(request.getContato().getEmail());
       contato.setTelefone(request.getContato().getTelefone());
       dentista.setContato(contato);

       dentista.setDentistasClinicas(request.getConsultas());

       Dentista atualizadoDentista = dentistaService.atualizarDentista(id, dentista);
       DentistaResponse dentistaResponse = dentistaResponseByDentista (atualizadoDentista);
       return ResponseEntity.ok(dentistaResponse);

    }

        @DeleteMapping ("{id}")
        ResponseEntity<Void> deleteDentista(@PathVariable UUID id) {

        dentistaService.deleteDentista(id);
        return ResponseEntity.ok().build();
        }

    private DentistaResponse dentistaResponseByDentista(Dentista dentista) {

        DentistaResponse dentistaResponse = new DentistaResponse();

        dentistaResponse.setId(dentista.getId());
        dentistaResponse.setCro(dentista.getCro());
        dentistaResponse.setNome(dentista.getNome());
        dentistaResponse.setDataNascimento(dentista.getDataNascimento());
        dentistaResponse.setEspecialidadeEnum(dentista.getEspecialidadeEnum());
        dentistaResponse.setSexoEnum(dentista.getSexoEnum());
        dentistaResponse.setCriadoEm(dentista.getCriadoEm());
        dentistaResponse.setAtualizadoEm(dentista.getAtualizadoEm());

        ContatoResponse contatoResponse = new ContatoResponse();
        contatoResponse.setId(dentista.getContato().getId());
        contatoResponse.setEmail(dentista.getContato().getEmail());
        contatoResponse.setTelefone(dentista.getContato().getTelefone());
        contatoResponse.setCriadoEm(dentista.getContato().getCriadoEm());
        contatoResponse.setAtualizadoEm(dentista.getContato().getAtualizadoEm());

        dentistaResponse.setContato(contatoResponse);
        dentistaResponse.setConsultas(dentista.getDentistasClinicas());

        return dentistaResponse;
    }



}

