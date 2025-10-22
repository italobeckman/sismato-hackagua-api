package br.unitins.hackathon.sismato.dto.sisagua;

public record MensalAmostrasResumoPorAnoDTO(
        Integer ano,
        Long totalAmostrasAnalisadas,
        Long totalAmostrasInconformes,
        Double percentualInconformidadeGeral
) {}