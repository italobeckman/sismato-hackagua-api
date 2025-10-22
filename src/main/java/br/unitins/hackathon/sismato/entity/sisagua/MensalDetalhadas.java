package br.unitins.hackathon.sismato.entity.sisagua;

import br.unitins.hackathon.sismato.entity.geo.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mensal_detalhadas_sisagua", schema = "public")
public class MensalDetalhadas extends DefaultEntity {

    @Column(name = "uf", length = 2)
    private String uf;

    @Column(name = "municipio", length = 100)
    private String municipio;

    @Column(name = "cod_mun_ibge", length = 10)
    private String codMunIbge;

    @Column(name = "tipo_abastecimento", length = 5)
    private String tipoAbastecimento;

    @Column(name = "codigo_nome_saa_sac", length = 20)
    private String codigoNomeSaaSac;

    @Column(name = "nome_saa_sac", length = 100)
    private String nomeSaaSac;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "mes_referencia", length = 10)
    private String mesReferencia;

    @Column(name = "ponto_monitoramento", length = 255)
    private String pontoMonitoramento;

    @Column(name = "nome_eta_uta", length = 100)
    private String nomeEtaUta;

    @Column(name = "parametro", length = 100)
    private String parametro;

    @Column(name = "campo", length = 100)
    private String campo;

    @Column(name = "num_amostras")
    private Integer numAmostras;

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

    public String getCodMunIbge() {
        return codMunIbge;
    }

    public void setCodMunIbge(String codMunIbge) {
        this.codMunIbge = codMunIbge;
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

    public String getPontoMonitoramento() {
        return pontoMonitoramento;
    }

    public void setPontoMonitoramento(String pontoMonitoramento) {
        this.pontoMonitoramento = pontoMonitoramento;
    }

    public String getNomeEtaUta() {
        return nomeEtaUta;
    }

    public void setNomeEtaUta(String nomeEtaUta) {
        this.nomeEtaUta = nomeEtaUta;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Integer getNumAmostras() {
        return numAmostras;
    }

    public void setNumAmostras(Integer numAmostras) {
        this.numAmostras = numAmostras;
    }
}