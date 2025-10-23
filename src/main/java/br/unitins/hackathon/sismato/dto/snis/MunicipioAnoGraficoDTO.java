package br.unitins.hackathon.sismato.dto.snis;

import java.util.List;

public record MunicipioAnoGraficoDTO(
    List<String> prestadores,
    List<Double> populacaoAtendidaAgua,
    List<Double> volumeAguaProduzido,
    List<Double> indicePerdaDistribuicao,
    List<Double> receitaOperacional,
    List<Double> investimentoAgua,
    List<Double> investimentoEsgoto
) {}
