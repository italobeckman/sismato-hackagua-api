package br.unitins.hackathon.sismato.dto.sisagua;

public record RankingMunicipioAnoDTO(
        Integer ano,
        String municipio,
        String codMunIbge,
        Long totalAmostrasAnalisadas,
        Long totalAmostrasInconformes,
        Double percentualInconformidadeAnual
) {}