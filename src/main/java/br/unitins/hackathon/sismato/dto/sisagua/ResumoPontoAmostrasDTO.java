package br.unitins.hackathon.sismato.dto.sisagua;

public class ResumoPontoAmostrasDTO {
    private String codigoPonto;
    private Long totalAmostras;
    private Long amostrasInconformes;
    private Double percentualInconformidade;
    private Integer ano;
    private Integer codIbge;

    public ResumoPontoAmostrasDTO(String codigoPonto, Long totalAmostras, Long amostrasInconformes,
                                  Double percentualInconformidade, Integer ano, Integer codIbge) {
        this.codigoPonto = codigoPonto;
        this.totalAmostras = totalAmostras;
        this.amostrasInconformes = amostrasInconformes;
        this.percentualInconformidade = percentualInconformidade;
        this.ano = ano;
        this.codIbge = codIbge;
    }

    public String getCodigoPonto() { return codigoPonto; }
    public Long getTotalAmostras() { return totalAmostras; }
    public Long getAmostrasInconformes() { return amostrasInconformes; }
    public Double getPercentualInconformidade() { return percentualInconformidade; }
    public Integer getAno() { return ano; }
    public Integer getCodIbge() { return codIbge; }
}