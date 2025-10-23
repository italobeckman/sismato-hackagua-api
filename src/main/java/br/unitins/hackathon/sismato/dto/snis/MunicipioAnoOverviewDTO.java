package br.unitins.hackathon.sismato.dto.snis;

public record MunicipioAnoOverviewDTO(
    Long idMunicipio,
    String siglaUf,
    Integer ano,
    Double populacaoUrbanaTotal,
    Double populacaoAtendidaAguaTotal,
    Double populacaoAtendidaEsgotoTotal,
    Double volumeAguaProduzidoTotal,
    Double volumeEsgotoColetadoTotal,
    Double indicePerdaDistribuicaoMedio,
    Double receitaOperacionalTotal,
    Double investimentoAguaTotal,
    Double investimentoEsgotoTotal
) {}
