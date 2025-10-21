package br.unitins.hackathon.sismato.entity.sisagua;

import br.unitins.hackathon.sismato.entity.geo.DefaultEntity;
import br.unitins.hackathon.sismato.entity.geo.Municipio;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

@MappedSuperclass
public abstract class BaseControle extends DefaultEntity {

    @ManyToOne
    @JoinColumn(name = "ibge_code")
    private Municipio municipioCod;

    @Column(name = "regiao_geografica")
    private String regiaoGeografica;

    @Column(name = "uf")
    private String uf;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "tipo_instituicao")
    private String tipoInstituicao;

    @Column(name = "sigla_instituicao")
    private String siglaInstituicao;

    @Column(name = "nome_instituicao")
    private String nomeInstituicao;

    @Column(name = "cnpj_instituicao")
    private String cnpjInstituicao;

    @Column(name = "nome_escritorio")
    private String nomeEscritorio;

    @Column(name = "cnpj_escritorio")
    private String cnpjEscritorio;

    @Column(name = "cod_forma_abastecimento")
    private String codFormaAbastecimento;

    @Column(name = "tipo_abastecimento")
    private String tipoAbastecimento;

    @Column(name = "nome_forma_abastecimento")
    private String nomeFormaAbastecimento;

    @Column(name = "nome_eta_uta")
    private String nomeEtaUta;

    @Column(name = "captacao_superficial")
    private String captacaoSuperficial;

    @Column(name = "captacao_subterranea")
    private String captacaoSubterranea;

    @Column(name = "captacao_agua_chuva")
    private String captacaoAguaChuva;

    @Column(name = "area_urbana")
    private String areaUrbana;

    @Column(name = "area_rural")
    private String areaRural;

    @Column(name = "ano_referencia")
    private Integer anoReferencia;

    @Column(name = "semestre_coleta")
    private Integer semestreColeta;

    @Column(name = "mes_coleta")
    private String mesColeta;

    @Column(name = "data_coleta")
    private String dataColeta;

    @Column(name = "data_analise")
    private String dataAnalise;

    @Column(name = "ponto_monitoramento")
    private String pontoMonitoramento;

    @Column(name = "grupo_parametros")
    private String grupoParametros;

    @Column(name = "parametro")
    private String parametro;

    @Column(name = "atendimento_padrao")
    private String atendimentoPadrao;

    @Column(name = "tipo_resultado")
    private String tipoResultado;

    @Column(name = "valor_resultado")
    private String valorResultado;

    @Column(name = "valor_lq")
    private String valorLq;

    @Column(name = "valor_ld")
    private String valorLd;

    public String getRegiaoGeografica() {
        return regiaoGeografica;
    }

    public void setRegiaoGeografica(String regiaoGeografica) {
        this.regiaoGeografica = regiaoGeografica;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTipoInstituicao() {
        return tipoInstituicao;
    }

    public void setTipoInstituicao(String tipoInstituicao) {
        this.tipoInstituicao = tipoInstituicao;
    }

    public String getSiglaInstituicao() {
        return siglaInstituicao;
    }

    public void setSiglaInstituicao(String siglaInstituicao) {
        this.siglaInstituicao = siglaInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getCnpjInstituicao() {
        return cnpjInstituicao;
    }

    public void setCnpjInstituicao(String cnpjInstituicao) {
        this.cnpjInstituicao = cnpjInstituicao;
    }

    public String getNomeEscritorio() {
        return nomeEscritorio;
    }

    public void setNomeEscritorio(String nomeEscritorio) {
        this.nomeEscritorio = nomeEscritorio;
    }

    public String getCnpjEscritorio() {
        return cnpjEscritorio;
    }

    public void setCnpjEscritorio(String cnpjEscritorio) {
        this.cnpjEscritorio = cnpjEscritorio;
    }

    public String getCodFormaAbastecimento() {
        return codFormaAbastecimento;
    }

    public void setCodFormaAbastecimento(String codFormaAbastecimento) {
        this.codFormaAbastecimento = codFormaAbastecimento;
    }

    public String getTipoAbastecimento() {
        return tipoAbastecimento;
    }

    public void setTipoAbastecimento(String tipoAbastecimento) {
        this.tipoAbastecimento = tipoAbastecimento;
    }

    public String getNomeFormaAbastecimento() {
        return nomeFormaAbastecimento;
    }

    public void setNomeFormaAbastecimento(String nomeFormaAbastecimento) {
        this.nomeFormaAbastecimento = nomeFormaAbastecimento;
    }

    public String getNomeEtaUta() {
        return nomeEtaUta;
    }

    public void setNomeEtaUta(String nomeEtaUta) {
        this.nomeEtaUta = nomeEtaUta;
    }

    public String getCaptacaoSuperficial() {
        return captacaoSuperficial;
    }

    public void setCaptacaoSuperficial(String captacaoSuperficial) {
        this.captacaoSuperficial = captacaoSuperficial;
    }

    public String getCaptacaoSubterranea() {
        return captacaoSubterranea;
    }

    public void setCaptacaoSubterranea(String captacaoSubterranea) {
        this.captacaoSubterranea = captacaoSubterranea;
    }

    public String getCaptacaoAguaChuva() {
        return captacaoAguaChuva;
    }

    public void setCaptacaoAguaChuva(String captacaoAguaChuva) {
        this.captacaoAguaChuva = captacaoAguaChuva;
    }

    public String getAreaUrbana() {
        return areaUrbana;
    }

    public void setAreaUrbana(String areaUrbana) {
        this.areaUrbana = areaUrbana;
    }

    public String getAreaRural() {
        return areaRural;
    }

    public void setAreaRural(String areaRural) {
        this.areaRural = areaRural;
    }

    public Integer getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(Integer anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    public Integer getSemestreColeta() {
        return semestreColeta;
    }

    public void setSemestreColeta(Integer semestreColeta) {
        this.semestreColeta = semestreColeta;
    }

    public String getMesColeta() {
        return mesColeta;
    }

    public void setMesColeta(String mesColeta) {
        this.mesColeta = mesColeta;
    }

    public String getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(String dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public String getPontoMonitoramento() {
        return pontoMonitoramento;
    }

    public void setPontoMonitoramento(String pontoMonitoramento) {
        this.pontoMonitoramento = pontoMonitoramento;
    }

    public String getGrupoParametros() {
        return grupoParametros;
    }

    public void setGrupoParametros(String grupoParametros) {
        this.grupoParametros = grupoParametros;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getAtendimentoPadrao() {
        return atendimentoPadrao;
    }

    public void setAtendimentoPadrao(String atendimentoPadrao) {
        this.atendimentoPadrao = atendimentoPadrao;
    }

    public String getTipoResultado() {
        return tipoResultado;
    }

    public void setTipoResultado(String tipoResultado) {
        this.tipoResultado = tipoResultado;
    }

    public String getValorResultado() {
        return valorResultado;
    }

    public void setValorResultado(String valorResultado) {
        this.valorResultado = valorResultado;
    }

    public String getValorLq() {
        return valorLq;
    }

    public void setValorLq(String valorLq) {
        this.valorLq = valorLq;
    }

    public String getValorLd() {
        return valorLd;
    }

    public void setValorLd(String valorLd) {
        this.valorLd = valorLd;
    }
}
