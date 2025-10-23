package br.unitins.hackathon.sismato.dto.snis;

public class MediasIndicesAnoDTO {
    private Integer ano;
    private Double mediaPerdaFaturamento;
    private Double mediaColetaEsgoto;
    private Double mediaTratamentoEsgoto;
    private Double mediaAtendimentoAgua;

    public MediasIndicesAnoDTO(Integer ano, Double mediaPerdaFaturamento,
                               Double mediaColetaEsgoto,
                               Double mediaTratamentoEsgoto,
                               Double mediaAtendimentoAgua) {
        this.ano = ano;
        this.mediaPerdaFaturamento = mediaPerdaFaturamento;
        this.mediaColetaEsgoto = mediaColetaEsgoto;
        this.mediaTratamentoEsgoto = mediaTratamentoEsgoto;
        this.mediaAtendimentoAgua = mediaAtendimentoAgua;
    }

    public Integer getAno() { return ano; }
    public Double getMediaPerdaFaturamento() { return mediaPerdaFaturamento; }
    public Double getMediaColetaEsgoto() { return mediaColetaEsgoto; }
    public Double getMediaTratamentoEsgoto() { return mediaTratamentoEsgoto; }
    public Double getMediaAtendimentoAgua() { return mediaAtendimentoAgua; }
}