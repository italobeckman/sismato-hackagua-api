package br.unitins.hackathon.sismato.dto.snis;

public class InvestimentoNaturezaDTO {
    private String naturezaJuridica;
    private Double totalInvestimentoAgua;
    private Double totalInvestimentoEsgoto;

    public InvestimentoNaturezaDTO(String naturezaJuridica, Double totalInvestimentoAgua, Double totalInvestimentoEsgoto) {
        this.naturezaJuridica = naturezaJuridica;
        this.totalInvestimentoAgua = totalInvestimentoAgua;
        this.totalInvestimentoEsgoto = totalInvestimentoEsgoto;
    }

    public String getNaturezaJuridica() { return naturezaJuridica; }
    public Double getTotalInvestimentoAgua() { return totalInvestimentoAgua; }
    public Double getTotalInvestimentoEsgoto() { return totalInvestimentoEsgoto; }
}