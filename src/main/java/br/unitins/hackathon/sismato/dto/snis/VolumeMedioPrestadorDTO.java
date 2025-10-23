package br.unitins.hackathon.sismato.dto.snis;

public class VolumeMedioPrestadorDTO {
    private String prestador;
    private Double mediaVolumeProduzido;
    private Double mediaVolumeTratado;
    private Double mediaVolumeFaturado;

    public VolumeMedioPrestadorDTO(String prestador, Double mediaVolumeProduzido,
                                   Double mediaVolumeTratado, Double mediaVolumeFaturado) {
        this.prestador = prestador;
        this.mediaVolumeProduzido = mediaVolumeProduzido;
        this.mediaVolumeTratado = mediaVolumeTratado;
        this.mediaVolumeFaturado = mediaVolumeFaturado;
    }

    public String getPrestador() { return prestador; }
    public Double getMediaVolumeProduzido() { return mediaVolumeProduzido; }
    public Double getMediaVolumeTratado() { return mediaVolumeTratado; }
    public Double getMediaVolumeFaturado() { return mediaVolumeFaturado; }
}