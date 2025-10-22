package br.unitins.hackathon.sismato.entity.sisagua;

import br.unitins.hackathon.sismato.entity.geo.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "pontos_de_captacao_sisagua_v2")
public class PontoCaptacaoV2 extends DefaultEntity {

    @Column(name = "no_regiao")
    private String noRegiao;

    @Column(name = "sg_uf", length = 2)
    private String sgUf;

    @Column(name = "no_regional")
    private String noRegional;

    @Column(name = "no_municipio")
    public String municipio;

    @Column(name = "co_municipio_ibge")
    public Integer codigoIbge;

    @Column(name = "tp_abrangencia")
    private String tpAbrangencia;

    @Column(name = "sg_instituicao")
    private String sgInstituicao;

    @Column(name = "no_instituicao")
    private String noInstituicao;

    @Column(name = "nu_cnpj_instituicao", length = 20)
    private String nuCnpjInstituicao;

    @Column(name = "no_escritorio_regional_local")
    private String noEscritorioRegionalLocal;

    @Column(name = "nu_cnpj_escritorio_regional_local", length = 20)
    private String nuCnpjEscritorioRegionalLocal;

    @Column(name = "tp_abastecimento")
    private String tpAbastecimento;

    @Column(name = "nu_solucao_abastecimento")
    private String nuSolucaoAbastecimento;

    @Column(name = "no_solucao_abastecimento")
    private String noSolucaoAbastecimento;

    @Column(name = "no_eta")
    private String noEta;

    @Column(name = "nu_ano")
    public Integer ano;

    @Column(name = "tp_captacao")
    public String tipoCaptacao;

    @Column(name = "no_categoria_manancial")
    private String noCategoriaManancial;

    @Column(name = "no_manancial")
    private String noManancial;

    @Column(name = "tp_categoria_capt_sub")
    private String tpCategoriaCaptSub;

    @Column(name = "no_ponto_captacao")
    private String noPontoCaptacao;

    @Column(name = "st_outorga", length = 1)
    private String stOutorga;

    @Column(name = "nu_latitude")
    private String nuLatitude;

    @Column(name = "nu_longitude")
    private String nuLongitude;

    @Column(name = "nu_vazao_captada")
    private BigDecimal nuVazaoCaptada;

    public String getNoRegiao() {
        return noRegiao;
    }

    public void setNoRegiao(String noRegiao) {
        this.noRegiao = noRegiao;
    }

    public String getSgUf() {
        return sgUf;
    }

    public void setSgUf(String sgUf) {
        this.sgUf = sgUf;
    }

    public String getNoRegional() {
        return noRegional;
    }

    public void setNoRegional(String noRegional) {
        this.noRegional = noRegional;
    }

    public String getNoMunicipio() {
        return municipio;
    }

    public void setNoMunicipio(String noMunicipio) {
        this.municipio = noMunicipio;
    }

    public Integer getCoMunicipioIbge() {
        return codigoIbge;
    }

    public void setCoMunicipioIbge(Integer coMunicipioIbge) {
        this.codigoIbge = coMunicipioIbge;
    }

    public String getTpAbrangencia() {
        return tpAbrangencia;
    }

    public void setTpAbrangencia(String tpAbrangencia) {
        this.tpAbrangencia = tpAbrangencia;
    }

    public String getSgInstituicao() {
        return sgInstituicao;
    }

    public void setSgInstituicao(String sgInstituicao) {
        this.sgInstituicao = sgInstituicao;
    }

    public String getNoInstituicao() {
        return noInstituicao;
    }

    public void setNoInstituicao(String noInstituicao) {
        this.noInstituicao = noInstituicao;
    }

    public String getNuCnpjInstituicao() {
        return nuCnpjInstituicao;
    }

    public void setNuCnpjInstituicao(String nuCnpjInstituicao) {
        this.nuCnpjInstituicao = nuCnpjInstituicao;
    }

    public String getNoEscritorioRegionalLocal() {
        return noEscritorioRegionalLocal;
    }

    public void setNoEscritorioRegionalLocal(String noEscritorioRegionalLocal) {
        this.noEscritorioRegionalLocal = noEscritorioRegionalLocal;
    }

    public String getNuCnpjEscritorioRegionalLocal() {
        return nuCnpjEscritorioRegionalLocal;
    }

    public void setNuCnpjEscritorioRegionalLocal(String nuCnpjEscritorioRegionalLocal) {
        this.nuCnpjEscritorioRegionalLocal = nuCnpjEscritorioRegionalLocal;
    }

    public String getTpAbastecimento() {
        return tpAbastecimento;
    }

    public void setTpAbastecimento(String tpAbastecimento) {
        this.tpAbastecimento = tpAbastecimento;
    }

    public String getNuSolucaoAbastecimento() {
        return nuSolucaoAbastecimento;
    }

    public void setNuSolucaoAbastecimento(String nuSolucaoAbastecimento) {
        this.nuSolucaoAbastecimento = nuSolucaoAbastecimento;
    }

    public String getNoSolucaoAbastecimento() {
        return noSolucaoAbastecimento;
    }

    public void setNoSolucaoAbastecimento(String noSolucaoAbastecimento) {
        this.noSolucaoAbastecimento = noSolucaoAbastecimento;
    }

    public String getNoEta() {
        return noEta;
    }

    public void setNoEta(String noEta) {
        this.noEta = noEta;
    }

    public Integer getNuAno() {
        return ano;
    }

    public void setNuAno(Integer nuAno) {
        this.ano = nuAno;
    }

    public String getTpCaptacao() {
        return tipoCaptacao;
    }

    public void setTpCaptacao(String tpCaptacao) {
        this.tipoCaptacao = tpCaptacao;
    }

    public String getNoCategoriaManancial() {
        return noCategoriaManancial;
    }

    public void setNoCategoriaManancial(String noCategoriaManancial) {
        this.noCategoriaManancial = noCategoriaManancial;
    }

    public String getNoManancial() {
        return noManancial;
    }

    public void setNoManancial(String noManancial) {
        this.noManancial = noManancial;
    }

    public String getTpCategoriaCaptSub() {
        return tpCategoriaCaptSub;
    }

    public void setTpCategoriaCaptSub(String tpCategoriaCaptSub) {
        this.tpCategoriaCaptSub = tpCategoriaCaptSub;
    }

    public String getNoPontoCaptacao() {
        return noPontoCaptacao;
    }

    public void setNoPontoCaptacao(String noPontoCaptacao) {
        this.noPontoCaptacao = noPontoCaptacao;
    }

    public String getStOutorga() {
        return stOutorga;
    }

    public void setStOutorga(String stOutorga) {
        this.stOutorga = stOutorga;
    }

    public String getNuLatitude() {
        return nuLatitude;
    }

    public void setNuLatitude(String nuLatitude) {
        this.nuLatitude = nuLatitude;
    }

    public String getNuLongitude() {
        return nuLongitude;
    }

    public void setNuLongitude(String nuLongitude) {
        this.nuLongitude = nuLongitude;
    }

    public BigDecimal getNuVazaoCaptada() {
        return nuVazaoCaptada;
    }

    public void setNuVazaoCaptada(BigDecimal nuVazaoCaptada) {
        this.nuVazaoCaptada = nuVazaoCaptada;
    }
}