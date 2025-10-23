package br.unitins.hackathon.sismato.dto.sisagua;

import java.math.BigDecimal;

/**
 * DTO para mapa de pontos de captação com dados de amostras mensais
 * Usado para visualizações geoespaciais com tooltips ricos
 */
public record MapaPontosCaptacaoComAmostrasDTO(
    String codigoPontoCaptacao,           // Código do ponto de captação
    String nomePontoCaptacao,             // Nome do ponto de captação
    BigDecimal latitude,                  // Latitude do ponto
    BigDecimal longitude,                 // Longitude do ponto
    String tipoCaptacao,                  // Tipo: Subterrâneo/Superficial
    String statusOutorga,                 // Status da outorga: S/N
    String nomeInstituicao,               // Nome da instituição responsável
    String nomeEta,                       // Nome da ETA/UTA
    BigDecimal vazaoCaptada,              // Vazão captada
    Long totalAmostras,                   // Total de amostras analisadas
    Long amostrasInconformes,             // Amostras fora do padrão
    Double percentualInconformidade,      // Percentual de inconformidade
    String municipio,                     // Nome do município
    Integer codigoIbge,                   // Código IBGE do município
    Integer ano                           // Ano de referência
) {}
