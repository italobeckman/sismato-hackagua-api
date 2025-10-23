package br.unitins.hackathon.sismato.dto;

import java.math.BigDecimal;

/**
 * DTO para dados geoespaciais de pontos de captação com informações de qualidade da água
 * Usado no endpoint de mapa que cruza dados de infraestrutura com amostras mensais
 */
public record MapaPontosCaptacaoComAmostrasDTO(
    String codigoPontoCaptacao,
    String nomePontoCaptacao,
    BigDecimal latitude,
    BigDecimal longitude,
    String tipoCaptacao,
    String statusOutorga,
    String nomeInstituicao,
    String nomeEta,
    BigDecimal vazaoCaptada,
    Long totalAmostras,
    Long amostrasInconformes,
    Double percentualInconformidade,
    String municipio,
    Integer codigoIbge,
    Integer ano
) {}
