package br.unitins.hackathon.sismato.dto.sisagua;

import java.math.BigDecimal;

import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacaoV2;

public record PontoCaptacaoMapaDTO(
    Long id,
    String noPontoCaptacao,
    String tipoCaptacao,
    String noManancial,
    String noInstituicao,
    String stOutorga,
    BigDecimal nuVazaoCaptada,
    String nuLatitude,
    String nuLongitude,
    Integer ano,
    String municipio
) { 
    public static PontoCaptacaoMapaDTO toDto(PontoCaptacaoV2 entity) {
        return new PontoCaptacaoMapaDTO(
            entity.getId(), 
            entity.getNoPontoCaptacao(),
            entity.getTpCaptacao(),   
            entity.getNoManancial(),
            entity.getNoInstituicao(),
            entity.getStOutorga(),
            entity.getNuVazaoCaptada(),
            entity.getNuLatitude(),
            entity.getNuLongitude(),
            entity.getNuAno()  ,
            entity.getNoMunicipio()      
        );
    }
}
