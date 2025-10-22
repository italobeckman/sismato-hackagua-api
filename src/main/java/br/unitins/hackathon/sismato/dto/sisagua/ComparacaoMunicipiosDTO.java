package br.unitins.hackathon.sismato.dto.sisagua;

public record ComparacaoMunicipiosDTO(
        String municipio,
        String codIbge,
        Double percentualInconformidade,
        Long totalAmostras,
        Integer ranking
) {}
