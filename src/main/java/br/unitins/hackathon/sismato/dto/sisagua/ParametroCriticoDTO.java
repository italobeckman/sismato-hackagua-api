package br.unitins.hackathon.sismato.dto.sisagua;

public record ParametroCriticoDTO(
        String parametro,
        Long totalAmostrasInconformes
) {}