package br.com.clicanicaodontologica.clinica.api.controller;

import br.com.clicanicaodontologica.clinica.api.dto.request.DentistaRequest;
import br.com.clicanicaodontologica.clinica.api.dto.request.PacienteRequest;
import br.com.clicanicaodontologica.clinica.api.dto.response.ContatoResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.DentistaResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.EnderecoResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.PacienteResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.listResponse.DentistaListResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.listResponse.PacienteListResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.wrapperResponse.DentistaWrapperResponse;
import br.com.clicanicaodontologica.clinica.api.dto.response.wrapperResponse.PacienteWrapperResponse;
import br.com.clicanicaodontologica.clinica.domain.entity.Contato;
import br.com.clicanicaodontologica.clinica.domain.entity.Dentista;
import br.com.clicanicaodontologica.clinica.domain.entity.Endereco;
import br.com.clicanicaodontologica.clinica.domain.entity.Paciente;
import br.com.clicanicaodontologica.clinica.domain.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/pacientes")
@Tag(name = "Pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private final ObjectMapper objectMapper;

    @Autowired
    public PacienteController(PacienteService pacienteService, ObjectMapper objectMapper) {
        this.pacienteService = pacienteService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    ResponseEntity<?> criarPaciente(@RequestBody @Valid List<PacienteRequest> request) {
        List<Paciente> listaPaciente = new ArrayList<>();

        for (PacienteRequest requestList : request) {
            Paciente paciente = objectMapper.convertValue(requestList, Paciente.class);
            listaPaciente.add(paciente);
        };
        return ResponseEntity.ok(pacienteService.criarPaciente(listaPaciente));
    }

    @GetMapping
    ResponseEntity<PacienteWrapperResponse> buscarPaciente (@RequestParam(required = false) String termo) {

        List<Paciente> pacientes = pacienteService.buscarPaciente(termo);
        PacienteWrapperResponse pacienteWrapperResponse = new PacienteWrapperResponse();
        pacienteWrapperResponse.setPacientes(pacientes.stream().map(paciente -> {

            PacienteListResponse pacienteListResponse = new PacienteListResponse();
            pacienteListResponse.setId(paciente.getId());
            pacienteListResponse.setId(paciente.getId());
            pacienteListResponse.setNome(paciente.getNome());
            return pacienteListResponse;
        }).toList());
        return ResponseEntity.ok(pacienteWrapperResponse);
    }

    @GetMapping ("{id}")
    ResponseEntity<PacienteResponse> buscarPacientePorId (@PathVariable UUID id) {

        Paciente paciente = pacienteService.buscarPacientePorId(id);
        PacienteResponse pacienteResponse = pacienteResponseByPaciente(paciente);
        return ResponseEntity.ok(pacienteResponse);
    }


    @PutMapping("{id}")
    ResponseEntity<PacienteResponse> atualizarPaciente(@PathVariable UUID id, @RequestBody @Valid PacienteRequest request) {

        Paciente paciente = pacienteService.buscarPacientePorId(id);

        paciente.setNome(request.getNome());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setSexoEnum(request.getSexoEnum());

        Contato contato = paciente.getContato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());
        paciente.setContato(contato);

        Endereco endereco = paciente.getEndereco();
        endereco.setLogradouro(request.getEndereco().getLogradouro());
        endereco.setBairro(request.getEndereco().getBairro());
        endereco.setCidade(request.getEndereco().getCidade());
        endereco.setEstado(request.getEndereco().getEstado());
        endereco.setCep(request.getEndereco().getCep());
        paciente.setEndereco(endereco);

        Paciente atualizadoPaciente = pacienteService.atualizarPaciente(id, paciente);
        PacienteResponse pacienteResponse = pacienteResponseByPaciente (atualizadoPaciente);
        return ResponseEntity.ok(pacienteResponse);

    }


    @DeleteMapping ("{id}")
    ResponseEntity<Void> deletePaciente(@PathVariable UUID id) {

        pacienteService.deletePaciente(id);
        return ResponseEntity.ok().build();
    }

    private PacienteResponse pacienteResponseByPaciente(Paciente paciente) {

        PacienteResponse pacienteResponse = new PacienteResponse();

        pacienteResponse.setId(paciente.getId());
        pacienteResponse.setNome(paciente.getNome());
        pacienteResponse.setDataNascimento(paciente.getDataNascimento());
        pacienteResponse.setSexoEnum(paciente.getSexoEnum());
        pacienteResponse.setCriadoEm(paciente.getCriadoEm());
        pacienteResponse.setAtualizadoEm(paciente.getAtualizadoEm());

        ContatoResponse contatoResponse = new ContatoResponse();
        contatoResponse.setId(paciente.getContato().getId());
        contatoResponse.setEmail(paciente.getContato().getEmail());
        contatoResponse.setTelefone(paciente.getContato().getTelefone());
        contatoResponse.setCriadoEm(paciente.getContato().getCriadoEm());
        contatoResponse.setAtualizadoEm(paciente.getContato().getAtualizadoEm());

        EnderecoResponse enderecoResponse = new EnderecoResponse();
        enderecoResponse.setLogradouro(paciente.getEndereco().getLogradouro());
        enderecoResponse.setBairro(paciente.getEndereco().getBairro());
        enderecoResponse.setCidade(paciente.getEndereco().getCidade());
        enderecoResponse.setEstado(paciente.getEndereco().getEstado());
        enderecoResponse.setCep(paciente.getEndereco().getCep());
        enderecoResponse.setAtualizadoEm(paciente.getAtualizadoEm());
        enderecoResponse.setCriadoEm(paciente.getCriadoEm());

        pacienteResponse.setContato(contatoResponse);
        pacienteResponse.setEndereco(enderecoResponse);

        return pacienteResponse;
    }
}
