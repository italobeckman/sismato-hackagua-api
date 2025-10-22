package br.unitins.hackathon.sismato.dto.sisagua;

public record QualidadeAguaMunicipioDTO(
        String municipio,
        String codIbge,
        Long totalAmostras,
        Long amostrasInconformes,
        Double percentualInconformidade,
        Integer ano
) {}
