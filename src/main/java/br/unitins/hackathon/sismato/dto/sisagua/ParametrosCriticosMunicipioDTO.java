package br.unitins.hackathon.sismato.dto.sisagua;

public record ParametrosCriticosMunicipioDTO(
        String parametro,
        Long amostrasInconformes,
        Long totalAmostras,
        Double percentualInconformidade,
        String municipio,
        String codIbge
) {}
