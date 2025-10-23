package br.unitins.hackathon.sismato.dto.snis;

public class DespesasPrestadorDTO {
    private String prestador;
    private Double totalDespesaPessoal;
    private Double totalDespesaQuimicos;
    private Double totalDespesaEnergia;
    private Double totalDespesaTerceiros;

    public DespesasPrestadorDTO(String prestador,
                                Double totalDespesaPessoal,
                                Double totalDespesaQuimicos,
                                Double totalDespesaEnergia,
                                Double totalDespesaTerceiros) {
        this.prestador = prestador;
        this.totalDespesaPessoal = totalDespesaPessoal;
        this.totalDespesaQuimicos = totalDespesaQuimicos;
        this.totalDespesaEnergia = totalDespesaEnergia;
        this.totalDespesaTerceiros = totalDespesaTerceiros;
    }

    public String getPrestador() { return prestador; }
    public Double getTotalDespesaPessoal() { return totalDespesaPessoal; }
    public Double getTotalDespesaQuimicos() { return totalDespesaQuimicos; }
    public Double getTotalDespesaEnergia() { return totalDespesaEnergia; }
    public Double getTotalDespesaTerceiros() { return totalDespesaTerceiros; }
}