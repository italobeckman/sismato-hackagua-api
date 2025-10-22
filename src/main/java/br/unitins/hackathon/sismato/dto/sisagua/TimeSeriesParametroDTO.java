package br.unitins.hackathon.sismato.dto.sisagua;

import java.time.LocalDate;

public record TimeSeriesParametroDTO(
        LocalDate dataAnalise,
        String parametro,
        Double percentualInconformidade
) {}