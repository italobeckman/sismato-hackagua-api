package br.unitins.hackathon.sismato.dto.sisagua;

import java.math.BigDecimal;

public record PontoCaptacaoDetalhesDTO(
    long totalPontos,
    BigDecimal vazaoTotalCaptada,
    long totalSuperficial,
    long totalSubterraneo,
    long totalComOutorga,
    long totalSemOutorga,
    long totalOutorgaNaoInformada   
) {


}