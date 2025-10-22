package br.unitins.hackathon.sismato.dto.sisagua;

import java.math.BigDecimal;

public record EvolucaoVazaoDTO(
        Integer ano,
        BigDecimal vazaoMedia,
        Long quantidadePontos
) {}
