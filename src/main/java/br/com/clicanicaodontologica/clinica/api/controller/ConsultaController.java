package br.com.clicanicaodontologica.clinica.api.controller;


import br.com.clicanicaodontologica.clinica.api.dto.request.ClinicaRequest;
import br.com.clicanicaodontologica.clinica.api.dto.request.ConsultaRequest;
import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.service.ConsultaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;
    private final ObjectMapper objectMapper;
    public ConsultaController(ConsultaService consultaService, ObjectMapper objectMapper) {
        this.consultaService = consultaService;
        this.objectMapper = objectMapper;
    }
    @PostMapping
    ResponseEntity<?> criarConsulta(@RequestBody @Valid List<ConsultaRequest> request) {

        List<Consulta> listaConsultas = new ArrayList<>();

        for (ConsultaRequest requestList : request) {
            Consulta consulta = objectMapper.convertValue(requestList, Consulta.class);
            listaConsultas.add(consulta);
        }

        return ResponseEntity.ok(consultaService.criarConsulta(listaConsultas));
    }




}
