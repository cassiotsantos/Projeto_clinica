package br.com.clicanicaodontologica.clinica.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ContatoRequest {
    @Email
    private String email;
    @Pattern(regexp = "\\((\\d{2})\\) (\\d{4,5})-(\\d{4})")
    private String telefone;
}
