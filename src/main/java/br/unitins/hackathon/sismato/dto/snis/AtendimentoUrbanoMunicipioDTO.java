package br.unitins.hackathon.sismato.dto.snis;

public class AtendimentoUrbanoMunicipioDTO {
    private String siglaUf;
    private Long idMunicipio;
    private Double percentualAtendimentoAguaUrbana;
    private Double percentualAtendimentoEsgotoUrbano;

    public AtendimentoUrbanoMunicipioDTO(String siglaUf, Long idMunicipio,
                                         Double percentualAtendimentoAguaUrbana,
                                         Double percentualAtendimentoEsgotoUrbano) {
        this.siglaUf = siglaUf;
        this.idMunicipio = idMunicipio;
        this.percentualAtendimentoAguaUrbana = percentualAtendimentoAguaUrbana;
        this.percentualAtendimentoEsgotoUrbano = percentualAtendimentoEsgotoUrbano;
    }

    public String getSiglaUf() { return siglaUf; }
    public Long getIdMunicipio() { return idMunicipio; }
    public Double getPercentualAtendimentoAguaUrbana() { return percentualAtendimentoAguaUrbana; }
    public Double getPercentualAtendimentoEsgotoUrbano() { return percentualAtendimentoEsgotoUrbano; }
}