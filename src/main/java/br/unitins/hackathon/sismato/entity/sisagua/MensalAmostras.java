package br.unitins.hackathon.sismato.entity.sisagua;

import java.math.BigDecimal;

import br.unitins.hackathon.sismato.entity.geo.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mensal_amostras_sisagua")
public class MensalAmostras extends DefaultEntity {

    @Column(name = "uf", length = 2)
    public String uf;

    @Column(name = "municipio", length = 100)
    public String municipio;

    @Column(name = "sigla_instituicao", length = 10)
    public String siglaInstituicao;

    @Column(name = "instituicao", length = 255)
    public String instituicao;

    @Column(name = "tipo_abastecimento", length = 5)
    public String tipoAbastecimento;

    @Column(name = "codigo_nome_saa_sac", length = 20)
    public String codigoNomeSaaSac;

    @Column(name = "nome_saa_sac", length = 100)
    public String nomeSaaSac;

    @Column(name = "nome_eta_uta", length = 100)
    public String nomeEtaUta;

    @Column(name = "ponto_monitoramento", length = 255)
    public String pontoMonitoramento;

    @Column(name = "parametro", length = 100)
    public String parametro;

    @Column(name = "ano")
    public Integer ano;

    @Column(name = "mes_referencia", length = 10)
    public String mesReferencia;

    @Column(name = "num_amostras_obrigatorias")
    public Integer numAmostrasObrigatorias;

    @Column(name = "num_amostras_analisadas")
    public Integer numAmostrasAnalisadas;

    @Column(name = "num_amostras_fora_do_padrao")
    public Integer numAmostrasForaDoPadrao;

    @Column(name = "perc_amostras_fora_do_padrao", precision = 38, scale = 2)
    public BigDecimal percAmostrasForaDoPadrao;

    @Column(name = "perc_cumprimento_amostras_obrigatorias", precision = 38, scale = 2)
    public BigDecimal percCumprimentoAmostrasObrigatorias;

    @Column(name = "cod_mun_ibge", length = 10)
    public String codMunIbge;

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

    public String getSiglaInstituicao() {
        return siglaInstituicao;
    }

    public void setSiglaInstituicao(String siglaInstituicao) {
        this.siglaInstituicao = siglaInstituicao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTipoAbastecimento() {
        return tipoAbastecimento;
    }

    public void setTipoAbastecimento(String tipoAbastecimento) {
        this.tipoAbastecimento = tipoAbastecimento;
    }

    public String getCodigoNomeSaaSac() {
        return codigoNomeSaaSac;
    }

    public void setCodigoNomeSaaSac(String codigoNomeSaaSac) {
        this.codigoNomeSaaSac = codigoNomeSaaSac;
    }

    public String getNomeSaaSac() {
        return nomeSaaSac;
    }

    public void setNomeSaaSac(String nomeSaaSac) {
        this.nomeSaaSac = nomeSaaSac;
    }

    public String getNomeEtaUta() {
        return nomeEtaUta;
    }

    public void setNomeEtaUta(String nomeEtaUta) {
        this.nomeEtaUta = nomeEtaUta;
    }

    public String getPontoMonitoramento() {
        return pontoMonitoramento;
    }

    public void setPontoMonitoramento(String pontoMonitoramento) {
        this.pontoMonitoramento = pontoMonitoramento;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public Integer getNumAmostrasObrigatorias() {
        return numAmostrasObrigatorias;
    }

    public void setNumAmostrasObrigatorias(Integer numAmostrasObrigatorias) {
        this.numAmostrasObrigatorias = numAmostrasObrigatorias;
    }

    public Integer getNumAmostrasAnalisadas() {
        return numAmostrasAnalisadas;
    }

    public void setNumAmostrasAnalisadas(Integer numAmostrasAnalisadas) {
        this.numAmostrasAnalisadas = numAmostrasAnalisadas;
    }

    public Integer getNumAmostrasForaDoPadrao() {
        return numAmostrasForaDoPadrao;
    }

    public void setNumAmostrasForaDoPadrao(Integer numAmostrasForaDoPadrao) {
        this.numAmostrasForaDoPadrao = numAmostrasForaDoPadrao;
    }

    public BigDecimal getPercAmostrasForaDoPadrao() {
        return percAmostrasForaDoPadrao;
    }

    public void setPercAmostrasForaDoPadrao(BigDecimal percAmostrasForaDoPadrao) {
        this.percAmostrasForaDoPadrao = percAmostrasForaDoPadrao;
    }

    public BigDecimal getPercCumprimentoAmostrasObrigatorias() {
        return percCumprimentoAmostrasObrigatorias;
    }

    public void setPercCumprimentoAmostrasObrigatorias(BigDecimal percCumprimentoAmostrasObrigatorias) {
        this.percCumprimentoAmostrasObrigatorias = percCumprimentoAmostrasObrigatorias;
    }

    public String getCodMunIbge() {
        return codMunIbge;
    }
    
    public void setCodMunIbge(String codMunIbge) {
        this.codMunIbge = codMunIbge;
    }
}