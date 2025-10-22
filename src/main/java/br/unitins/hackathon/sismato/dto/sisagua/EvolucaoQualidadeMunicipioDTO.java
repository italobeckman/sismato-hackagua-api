package br.unitins.hackathon.sismato.dto.sisagua;

public record EvolucaoQualidadeMunicipioDTO(
        Integer ano,
        String municipio,
        String codIbge,
        Long totalAmostras,
        Long amostrasInconformes,
        Double percentualInconformidade
) {}
