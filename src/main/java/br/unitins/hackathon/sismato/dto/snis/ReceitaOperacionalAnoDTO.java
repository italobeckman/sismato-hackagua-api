package br.unitins.hackathon.sismato.dto.snis;

public class ReceitaOperacionalAnoDTO {
    private Integer ano;
    private Double receitaTotalAgua;
    private Double receitaTotalEsgoto;
    private Double receitaOperacionalTotal;

    public ReceitaOperacionalAnoDTO(Integer ano, Double receitaTotalAgua,
                                    Double receitaTotalEsgoto,
                                    Double receitaOperacionalTotal) {
        this.ano = ano;
        this.receitaTotalAgua = receitaTotalAgua;
        this.receitaTotalEsgoto = receitaTotalEsgoto;
        this.receitaOperacionalTotal = receitaOperacionalTotal;
    }

    public Integer getAno() { return ano; }
    public Double getReceitaTotalAgua() { return receitaTotalAgua; }
    public Double getReceitaTotalEsgoto() { return receitaTotalEsgoto; }
    public Double getReceitaOperacionalTotal() { return receitaOperacionalTotal; }
}