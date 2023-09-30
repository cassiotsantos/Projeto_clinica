package br.com.clicanicaodontologica.clinica.api.controller;


import br.com.clicanicaodontologica.clinica.api.dto.request.ConsultaRequest;
import br.com.clicanicaodontologica.clinica.api.dto.request.DentistaRequest;
import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.service.DentistaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

            return ResponseEntity.ok(dentistaService.criarDentista(listaDentistas));
        };
        return null;
    }
}

