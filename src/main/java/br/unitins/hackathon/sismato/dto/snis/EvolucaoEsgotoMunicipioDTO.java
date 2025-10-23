package br.unitins.hackathon.sismato.dto.snis;

public class EvolucaoEsgotoMunicipioDTO {
    private Integer ano;
    private Long idMunicipio;
    private Double volumeEsgotoColetado;
    private Double volumeEsgotoTratado;
    private Double percentualEsgotoTratado;

    public EvolucaoEsgotoMunicipioDTO(Integer ano, Long idMunicipio,
                                      Double volumeEsgotoColetado,
                                      Double volumeEsgotoTratado,
                                      Double percentualEsgotoTratado) {
        this.ano = ano;
        this.idMunicipio = idMunicipio;
        this.volumeEsgotoColetado = volumeEsgotoColetado;
        this.volumeEsgotoTratado = volumeEsgotoTratado;
        this.percentualEsgotoTratado = percentualEsgotoTratado;
    }

    public Integer getAno() { return ano; }
    public Long getIdMunicipio() { return idMunicipio; }
    public Double getVolumeEsgotoColetado() { return volumeEsgotoColetado; }
    public Double getVolumeEsgotoTratado() { return volumeEsgotoTratado; }
    public Double getPercentualEsgotoTratado() { return percentualEsgotoTratado; }
}