package br.unitins.hackathon.sismato.dto.snis;

public class RankingPopulacaoMunicipioDTO {
    private Long idMunicipio;
    private String prestador;
    private Double populacaoAtendidaAgua;

    public RankingPopulacaoMunicipioDTO(Long idMunicipio, String prestador, Double populacaoAtendidaAgua) {
        this.idMunicipio = idMunicipio;
        this.prestador = prestador;
        this.populacaoAtendidaAgua = populacaoAtendidaAgua;
    }

    public Long getIdMunicipio() { return idMunicipio; }
    public String getPrestador() { return prestador; }
    public Double getPopulacaoAtendidaAgua() { return populacaoAtendidaAgua; }
}