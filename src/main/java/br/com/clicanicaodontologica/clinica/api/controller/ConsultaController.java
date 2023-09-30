package br.com.clicanicaodontologica.clinica.api.controller;


import br.com.clicanicaodontologica.clinica.api.dto.request.ClinicaRequest;
import br.com.clicanicaodontologica.clinica.api.dto.request.ConsultaRequest;
import br.com.clicanicaodontologica.clinica.api.dto.response.ConsultaResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.listResponse.ConsultaListResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.wrapperResponse.ConsultaWrapperResponse;
import br.com.clicanicaodontologica.clinica.domain.entity.Clinica;
import br.com.clicanicaodontologica.clinica.domain.entity.Consulta;
import br.com.clicanicaodontologica.clinica.domain.service.ConsultaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;
    private final ObjectMapper objectMapper;
    public ConsultaController(ConsultaService consultaService, ObjectMapper objectMapper) {
        this.consultaService = consultaService;
        this.objectMapper = objectMapper;
    };
    @PostMapping
    ResponseEntity<?> criarConsulta(@RequestBody @Valid List<ConsultaRequest> request) {

        List<Consulta> listaConsultas = new ArrayList<>();

        for (ConsultaRequest requestList : request) {
            Consulta consulta = objectMapper.convertValue(requestList, Consulta.class);
            listaConsultas.add(consulta);
        }

        return ResponseEntity.ok(consultaService.criarConsulta(listaConsultas));
    };

    @GetMapping
    ResponseEntity<ConsultaWrapperResponse> buscarConsulta(){
        List<Consulta> consultas = consultaService.buscarConsulta();
        ConsultaWrapperResponse consultaWrapperResponse = new ConsultaWrapperResponse();

        consultaWrapperResponse.setConsultas(consultas.stream().map( consulta -> {
            ConsultaListResponse consultaResponse = new ConsultaListResponse();

            consultaResponse.setId(consulta.getId());
            consultaResponse.setDataConsulta(consulta.getDataConsulta());
            return consultaResponse;

        }).toList());

        return ResponseEntity.ok(consultaWrapperResponse);
    };

    @GetMapping("{id}")
    ResponseEntity<ConsultaResponse> buscarConsultaPorId (@PathVariable UUID id) {

        Consulta consulta = consultaService.buscarConsultaPorId(id);
        ConsultaResponse response = consultaResponseByConsulta(consulta);
        return ResponseEntity.ok(response);
    };


    @PutMapping("{id}")
    ResponseEntity<ConsultaResponse> atualizarConsulta (@PathVariable UUID id, @RequestBody @Valid ConsultaRequest request) {

        Consulta consulta = consultaService.buscarConsultaPorId(id);
        consulta.setPaciente(request.getPaciente());
        consulta.setDentista(request.getDentista());
        consulta.setClinica(request.getClinica());
        consulta.setDataConsulta(request.getDataConsulta());
        consulta.setDescricao(request.getDescricao());
        consulta.setCancelada(request.getCancelada());
        consulta.setMotivoCancelamento(request.getMotivoCancelamento());

        Consulta atualizadaConsulta = consultaService.atualizarConsulta(id, consulta);
        ConsultaResponse responseConsulta = consultaResponseByConsulta(atualizadaConsulta);
        return ResponseEntity.ok(responseConsulta);

    };
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteConsulta (@PathVariable UUID id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.ok().build();
    };
    private ConsultaResponse consultaResponseByConsulta(Consulta consulta) {
        ConsultaResponse consultaResponse = new ConsultaResponse();
        consultaResponse.setId(consulta.getId());

        consultaResponse.setPaciente(consulta.getPaciente().getId());
        consultaResponse.setDentista(consulta.getDentista().getId());
        consultaResponse.setClinica(consulta.getDentista().getId());

        consultaResponse.setDataConsulta(consulta.getDataConsulta());
        consultaResponse.setCriadoEm(consulta.getCriadoEm());
        consultaResponse.setAtualizadoEm(consulta.getAtualizadoEm());
        consultaResponse.setDescricao(consulta.getDescricao());
        consultaResponse.setCancelada(consulta.getCancelada());
        consultaResponse.setMotivoCancelamento(consulta.getMotivoCancelamento());

        return consultaResponse;
    }




}
