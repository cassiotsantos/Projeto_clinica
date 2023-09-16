package br.com.clicanicaodontologica.clinica.api.handler;

public record Problem(Integer status,
                      String message,
                      String detail) {
}
