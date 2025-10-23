package br.unitins.hackathon.sismato.dto.snis;

public class EvolucaoAtendimentoMunicipioDTO {
    private Integer ano;
    private String siglaUf;
    private Long idMunicipio;
    private Double percentualAtendimentoAguaUrbana;
    private Double percentualAtendimentoEsgotoUrbano;

    public EvolucaoAtendimentoMunicipioDTO(Integer ano, String siglaUf, Long idMunicipio,
                                           Double percentualAtendimentoAguaUrbana,
                                           Double percentualAtendimentoEsgotoUrbano) {
        this.ano = ano;
        this.siglaUf = siglaUf;
        this.idMunicipio = idMunicipio;
        this.percentualAtendimentoAguaUrbana = percentualAtendimentoAguaUrbana;
        this.percentualAtendimentoEsgotoUrbano = percentualAtendimentoEsgotoUrbano;
    }

    public Integer getAno() { return ano; }
    public String getSiglaUf() { return siglaUf; }
    public Long getIdMunicipio() { return idMunicipio; }
    public Double getPercentualAtendimentoAguaUrbana() { return percentualAtendimentoAguaUrbana; }
    public Double getPercentualAtendimentoEsgotoUrbano() { return percentualAtendimentoEsgotoUrbano; }
}