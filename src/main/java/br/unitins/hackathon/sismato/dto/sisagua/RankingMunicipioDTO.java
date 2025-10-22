package br.unitins.hackathon.sismato.dto.sisagua;

public record RankingMunicipioDTO(
        String municipio,
        String codMunIbge,
        Long totalAmostrasAnalisadas,
        Long totalAmostrasInconformes,
        Double percentualInconformidadeGeral
) {}