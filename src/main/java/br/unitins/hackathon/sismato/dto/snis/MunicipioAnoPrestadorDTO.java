package br.unitins.hackathon.sismato.dto.snis;

public record MunicipioAnoPrestadorDTO(
    String prestador,
    Double populacaoAtendidaAgua,
    Double volumeAguaProduzido,
    Double indicePerdaDistribuicao,
    Double receitaOperacional,
    Double investimentoAgua,
    Double investimentoEsgoto
) {}
