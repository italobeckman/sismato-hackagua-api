package br.unitins.hackathon.sismato.dto.snis;

public class PerdasDistribuicaoPrestadorDTO {
    private String prestador;
    private Double mediaPerdaDistribuicao;

    public PerdasDistribuicaoPrestadorDTO(String prestador, Double mediaPerdaDistribuicao) {
        this.prestador = prestador;
        this.mediaPerdaDistribuicao = mediaPerdaDistribuicao;
    }

    public String getPrestador() { return prestador; }
    public Double getMediaPerdaDistribuicao() { return mediaPerdaDistribuicao; }
}