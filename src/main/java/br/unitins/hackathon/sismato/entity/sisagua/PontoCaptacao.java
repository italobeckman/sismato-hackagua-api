package br.unitins.hackathon.sismato.entity.sisagua;

import br.unitins.hackathon.sismato.entity.geo.DefaultEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.math.BigDecimal;

@Entity
@Table(name = "pontos_de_captacao_sisagua")
public class PontoCaptacao extends DefaultEntity {

    @Column(name = "codigo_forma_de_abastecimento", length = 50)
    public String codigoFormaDeAbastecimento;

    @Column(name = "nome_da_forma_de_abastecimento")
    public String nomeDaFormaDeAbastecimento;

    @Column(name = "municipio", length = 255)
    public String municipio;

    @Column(name = "regional_de_saude")
    public String regionalDeSaude;

    @Column(name = "codigo_ibge", length = 10)
    public String codigoIbge;

    @Column(name = "tipo_da_forma_de_abastecimento", length = 50)
    public String tipoDaFormaDeAbastecimento;

    @Column(name = "nome_do_escritorio_regional_local")
    public String nomeDoEscritorioRegionalLocal;

    @Column(name = "cnpj_do_escritorio_regional_local", length = 20)
    public String cnpjDoEscritorioRegionalLocal;

    @Column(name = "categoria_do_manancial_superficial")
    public String categoriaDoManancialSuperficial;

    @Column(name = "longitude")
    public BigDecimal longitude;

    @Column(name = "vazao")
    public BigDecimal vazao;

    @Column(name = "latitude")
    public BigDecimal latitude;

    @Column(name = "nome_da_instiuicao")
    public String nomeDaInstiuicao;

    @Column(name = "regiao_geografica", length = 50)
    public String regiaoGeografica;

    @Column(name = "categoria_do_ponto_de_captacao_subterraneo")
    public String categoriaDoPontoDeCaptacaoSubterraneo;

    @Column(name = "tipo_da_instituicao", length = 50)
    public String tipoDaInstituicao;

    @Column(name = "nome_do_manancial_superficial")
    public String nomeDoManancialSuperficial;

    @Column(name = "tipo_de_captacao", length = 50)
    public String tipoDeCaptacao;

    @Column(name = "nome_do_ponto_de_captacao_subterraneo")
    public String nomeDoPontoDeCaptacaoSubterraneo;

    @Column(name = "uf", length = 2)
    public String uf;

    @Column(name = "nome_da_eta_uta")
    public String nomeDaEtaUta;

    @Column(name = "ano_de_referencia")
    public Integer anoDeReferencia;

    @Column(name = "sigla_da_instituicao", length = 50)
    public String siglaDaInstituicao;

    @Column(name = "outorga", length = 1)
    public String outorga;

    public String getCodigoFormaDeAbastecimento() {
        return codigoFormaDeAbastecimento;
    }

    public void setCodigoFormaDeAbastecimento(String codigoFormaDeAbastecimento) {
        this.codigoFormaDeAbastecimento = codigoFormaDeAbastecimento;
    }

    public String getNomeDaFormaDeAbastecimento() {
        return nomeDaFormaDeAbastecimento;
    }

    public void setNomeDaFormaDeAbastecimento(String nomeDaFormaDeAbastecimento) {
        this.nomeDaFormaDeAbastecimento = nomeDaFormaDeAbastecimento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getRegionalDeSaude() {
        return regionalDeSaude;
    }

    public void setRegionalDeSaude(String regionalDeSaude) {
        this.regionalDeSaude = regionalDeSaude;
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getTipoDaFormaDeAbastecimento() {
        return tipoDaFormaDeAbastecimento;
    }

    public void setTipoDaFormaDeAbastecimento(String tipoDaFormaDeAbastecimento) {
        this.tipoDaFormaDeAbastecimento = tipoDaFormaDeAbastecimento;
    }

    public String getNomeDoEscritorioRegionalLocal() {
        return nomeDoEscritorioRegionalLocal;
    }

    public void setNomeDoEscritorioRegionalLocal(String nomeDoEscritorioRegionalLocal) {
        this.nomeDoEscritorioRegionalLocal = nomeDoEscritorioRegionalLocal;
    }

    public String getCnpjDoEscritorioRegionalLocal() {
        return cnpjDoEscritorioRegionalLocal;
    }

    public void setCnpjDoEscritorioRegionalLocal(String cnpjDoEscritorioRegionalLocal) {
        this.cnpjDoEscritorioRegionalLocal = cnpjDoEscritorioRegionalLocal;
    }

    public String getCategoriaDoManancialSuperficial() {
        return categoriaDoManancialSuperficial;
    }

    public void setCategoriaDoManancialSuperficial(String categoriaDoManancialSuperficial) {
        this.categoriaDoManancialSuperficial = categoriaDoManancialSuperficial;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getVazao() {
        return vazao;
    }

    public void setVazao(BigDecimal vazao) {
        this.vazao = vazao;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getNomeDaInstiuicao() {
        return nomeDaInstiuicao;
    }

    public void setNomeDaInstiuicao(String nomeDaInstiuicao) {
        this.nomeDaInstiuicao = nomeDaInstiuicao;
    }

    public String getRegiaoGeografica() {
        return regiaoGeografica;
    }

    public void setRegiaoGeografica(String regiaoGeografica) {
        this.regiaoGeografica = regiaoGeografica;
    }

    public String getCategoriaDoPontoDeCaptacaoSubterraneo() {
        return categoriaDoPontoDeCaptacaoSubterraneo;
    }

    public void setCategoriaDoPontoDeCaptacaoSubterraneo(String categoriaDoPontoDeCaptacaoSubterraneo) {
        this.categoriaDoPontoDeCaptacaoSubterraneo = categoriaDoPontoDeCaptacaoSubterraneo;
    }

    public String getTipoDaInstituicao() {
        return tipoDaInstituicao;
    }

    public void setTipoDaInstituicao(String tipoDaInstituicao) {
        this.tipoDaInstituicao = tipoDaInstituicao;
    }

    public String getNomeDoManancialSuperficial() {
        return nomeDoManancialSuperficial;
    }

    public void setNomeDoManancialSuperficial(String nomeDoManancialSuperficial) {
        this.nomeDoManancialSuperficial = nomeDoManancialSuperficial;
    }

    public String getTipoDeCaptacao() {
        return tipoDeCaptacao;
    }

    public void setTipoDeCaptacao(String tipoDeCaptacao) {
        this.tipoDeCaptacao = tipoDeCaptacao;
    }

    public String getNomeDoPontoDeCaptacaoSubterraneo() {
        return nomeDoPontoDeCaptacaoSubterraneo;
    }

    public void setNomeDoPontoDeCaptacaoSubterraneo(String nomeDoPontoDeCaptacaoSubterraneo) {
        this.nomeDoPontoDeCaptacaoSubterraneo = nomeDoPontoDeCaptacaoSubterraneo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNomeDaEtaUta() {
        return nomeDaEtaUta;
    }

    public void setNomeDaEtaUta(String nomeDaEtaUta) {
        this.nomeDaEtaUta = nomeDaEtaUta;
    }

    public Integer getAnoDeReferencia() {
        return anoDeReferencia;
    }

    public void setAnoDeReferencia(Integer anoDeReferencia) {
        this.anoDeReferencia = anoDeReferencia;
    }

    public String getSiglaDaInstituicao() {
        return siglaDaInstituicao;
    }

    public void setSiglaDaInstituicao(String siglaDaInstituicao) {
        this.siglaDaInstituicao = siglaDaInstituicao;
    }

    public String getOutorga() {
        return outorga;
    }

    public void setOutorga(String outorga) {
        this.outorga = outorga;
    }


    
}