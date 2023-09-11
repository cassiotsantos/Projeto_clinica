package br.com.clicanicaodontologica.clinica.domain.entity;
public enum SexoEnum {
    F("Feminino"),
    M("Masculino");
    private String genero;
    SexoEnum(String genero) {
        this.genero = genero;
    }
    public String getGenero(){
        return genero;
    }
};


