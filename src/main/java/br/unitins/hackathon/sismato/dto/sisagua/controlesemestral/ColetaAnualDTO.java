package br.unitins.hackathon.sismato.dto.sisagua.controlesemestral;

public class ColetaAnualDTO {
    private Integer ano;
    private Long qtdTotal;
    private Long qtdCaptacaoSuperficial;
    private Long qtdCaptcaoSubterranea;
    private Long qtdCaptacaoAguaChuva;
    private Long qtdAreaUrbana;
    private Long qtdAreaRural;

    public ColetaAnualDTO() {
    }

    public ColetaAnualDTO(Integer ano, Long qtdTotal, Long qtdCaptacaoSuperficial, Long qtdCaptcaoSubterranea, Long qtdCaptacaoAguaChuva, Long qtdAreaUrbana, Long qtdAreaRural) {
        this.ano = ano;
        this.qtdTotal = qtdTotal;
        this.qtdCaptacaoSuperficial = qtdCaptacaoSuperficial;
        this.qtdCaptcaoSubterranea = qtdCaptcaoSubterranea;
        this.qtdCaptacaoAguaChuva = qtdCaptacaoAguaChuva;
        this.qtdAreaUrbana = qtdAreaUrbana;
        this.qtdAreaRural = qtdAreaRural;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Long getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(Long qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    public Long getQtdCaptacaoSuperficial() {
        return qtdCaptacaoSuperficial;
    }

    public void setQtdCaptacaoSuperficial(Long qtdCaptacaoSuperficial) {
        this.qtdCaptacaoSuperficial = qtdCaptacaoSuperficial;
    }

    public Long getQtdCaptcaoSubterranea() {
        return qtdCaptcaoSubterranea;
    }

    public void setQtdCaptcaoSubterranea(Long qtdCaptcaoSubterranea) {
        this.qtdCaptcaoSubterranea = qtdCaptcaoSubterranea;
    }

    public Long getQtdCaptacaoAguaChuva() {
        return qtdCaptacaoAguaChuva;
    }

    public void setQtdCaptacaoAguaChuva(Long qtdCaptacaoAguaChuva) {
        this.qtdCaptacaoAguaChuva = qtdCaptacaoAguaChuva;
    }

    public Long getQtdAreaUrbana() {
        return qtdAreaUrbana;
    }

    public void setQtdAreaUrbana(Long qtdAreaUrbana) {
        this.qtdAreaUrbana = qtdAreaUrbana;
    }

    public Long getQtdAreaRural() {
        return qtdAreaRural;
    }

    public void setQtdAreaRural(Long qtdAreaRural) {
        this.qtdAreaRural = qtdAreaRural;
    }
}
