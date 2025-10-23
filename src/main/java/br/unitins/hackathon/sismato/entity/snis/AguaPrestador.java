package br.unitins.hackathon.sismato.entity.snis;

import br.unitins.hackathon.sismato.entity.geo.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "esgoto_agua_prestador_snis", schema = "public")
public class AguaPrestador extends DefaultEntity {

    @Column(name = "ano")
    public Long ano;

    @Column(name = "id_municipio")
    public Long idMunicipio;

    @Column(name = "sigla_uf", columnDefinition = "TEXT")
    public String siglaUf;

    @Column(name = "id_prestador")
    public Long idPrestador;

    @Column(name = "prestador", columnDefinition = "TEXT")
    public String prestador;

    @Column(name = "sigla_prestador", columnDefinition = "TEXT")
    public String siglaPrestador;

    @Column(name = "abrangencia", columnDefinition = "TEXT")
    public String abrangencia;

    @Column(name = "tipo_servico", columnDefinition = "TEXT")
    public String tipoServico;

    @Column(name = "natureza_juridica", columnDefinition = "TEXT")
    public String naturezaJuridica;

    @Column(name = "populacao_atendida_agua")
    public Double populacaoAtendidaAgua;

    @Column(name = "populacao_atentida_esgoto")
    public Double populacaoAtentidaEsgoto;

    @Column(name = "populacao_urbana")
    public Double populacaoUrbana;

    @Column(name = "populacao_urbana_atendida_agua")
    public Double populacaoUrbanaAtendidaAgua;

    @Column(name = "populacao_urbana_atendida_esgoto")
    public Double populacaoUrbanaAtendidaEsgoto;

    @Column(name = "extensao_rede_agua")
    public Double extensaoRedeAgua;

    @Column(name = "extensao_rede_esgoto")
    public Double extensaoRedeEsgoto;

    @Column(name = "ano_vencimento_delegacao_agua")
    public Double anoVencimentoDelegacaoAgua;

    @Column(name = "ano_vencimento_delegacao_esgoto")
    public Double anoVencimentoDelegacaoEsgoto;

    @Column(name = "quantidade_municipios_agua_delegacao_vigor")
    public Double quantidadeMunicipiosAguaDelegacaoVigor;

    @Column(name = "quantidade_municipios_esgoto_delegacao_vigor")
    public Double quantidadeMunicipiosEsgotoDelegacaoVigor;

    @Column(name = "quantidade_municipios_agua_delegacao_vencida")
    public Double quantidadeMunicipiosAguaDelegacaoVencida;

    @Column(name = "quantidade_municipios_esgoto_delegacao_vencida")
    public Double quantidadeMunicipiosEsgotoDelegacaoVencida;

    @Column(name = "quantidade_municipios_agua_sem_delegacao")
    public Double quantidadeMunicipiosAguaSemDelegacao;

    @Column(name = "quantidade_municipios_esgoto_sem_delegacao")
    public Double quantidadeMunicipiosEsgotoSemDelegacao;

    @Column(name = "quantidade_municipios_sem_esgoto_sem_delegacao")
    public Double quantidadeMunicipiosSemEsgotoSemDelegacao;

    @Column(name = "quantidade_sede_municipal_agua")
    public Double quantidadeSedeMunicipalAgua;

    @Column(name = "quantidade_sede_municipal_esgoto")
    public Double quantidadeSedeMunicipalEsgoto;

    @Column(name = "quantidade_localidade_agua")
    public Double quantidadeLocalidadeAgua;

    @Column(name = "quantidade_localidade_esgoto")
    public Double quantidadeLocalidadeEsgoto;

    @Column(name = "quantidade_ligacao_total_agua")
    public Double quantidadeLigacaoTotalAgua;

    @Column(name = "quantidade_ligacao_total_esgoto")
    public Double quantidadeLigacaoTotalEsgoto;

    @Column(name = "quantidade_ligacao_ativa_agua")
    public Double quantidadeLigacaoAtivaAgua;

    @Column(name = "quantidade_ligacao_ativa_esgoto")
    public Double quantidadeLigacaoAtivaEsgoto;

    @Column(name = "quantidade_economia_ativa_agua")
    public Double quantidadeEconomiaAtivaAgua;

    @Column(name = "quantidade_economia_ativa_esgoto")
    public Double quantidadeEconomiaAtivaEsgoto;

    @Column(name = "quantidade_ligacao_micromedia_ativa_agua")
    public Double quantidadeLigacaoMicromediaAtivaAgua;

    @Column(name = "quantidade_economia_residencial_ativa_agua")
    public Double quantidadeEconomiaResidencialAtivaAgua;

    @Column(name = "quantidade_economia_micromedida_ativa_agua")
    public Double quantidadeEconomiaMicromedidaAtivaAgua;

    @Column(name = "quantidade_economia_residencial_micromedida_ativa_agua")
    public Double quantidadeEconomiaResidencialMicromedidaAtivaAgua;

    @Column(name = "quantidade_economia_residencial_ativa_esgoto")
    public Double quantidadeEconomiaResidencialAtivaEsgoto;

    @Column(name = "volume_agua_produzido")
    public Double volumeAguaProduzido;

    @Column(name = "volume_agua_tratada_eta")
    public Double volumeAguaTratadaEta;

    @Column(name = "volume_agua_micromedido")
    public Double volumeAguaMicromedido;

    @Column(name = "volume_agua_consumido")
    public Double volumeAguaConsumido;

    @Column(name = "volume_agua_faturado")
    public Double volumeAguaFaturado;

    @Column(name = "volume_agua_macromedido")
    public Double volumeAguaMacromedido;

    @Column(name = "volume_agua_tratada_desinfeccao")
    public Double volumeAguaTratadaDesinfeccao;

    @Column(name = "volume_agua_bruta_exportado")
    public Double volumeAguaBrutaExportado;

    @Column(name = "volume_agua_tratada_importado")
    public Double volumeAguaTratadaImportado;

    @Column(name = "volume_agua_tratada_exportado")
    public Double volumeAguaTratadaExportado;

    @Column(name = "volume_agua_micromedido_economia_ativa")
    public Double volumeAguaMicromedidoEconomiaAtiva;

    @Column(name = "volume_servico_agua")
    public Double volumeServicoAgua;

    @Column(name = "volume_agua_fluoretada")
    public Double volumeAguaFluoretada;

    @Column(name = "consumo_eletrico_sistemas_agua")
    public Double consumoEletricoSistemasAgua;

    @Column(name = "volume_esgoto_coletado")
    public Double volumeEsgotoColetado;

    @Column(name = "volume_esgoto_tratado")
    public Double volumeEsgotoTratado;

    @Column(name = "volume_esgoto_faturado")
    public Double volumeEsgotoFaturado;

    @Column(name = "volume_esgoto_bruto_exportado")
    public Double volumeEsgotoBrutoExportado;

    @Column(name = "volume_esgoto_bruto_importado")
    public Double volumeEsgotoBrutoImportado;

    @Column(name = "volume_esgoto_importado")
    public Double volumeEsgotoImportado;

    @Column(name = "volume_esgoto_bruto_exportado_tratamento_importador")
    public Double volumeEsgotoBrutoExportadoTratamentoImportador;

    @Column(name = "consumo_eletrico_sistemas_esgoto")
    public Double consumoEletricoSistemasEsgoto;

    @Column(name = "indice_agua_ligacao")
    public Double indiceAguaLigacao;

    @Column(name = "indice_hidrometracao")
    public Double indiceHidrometracao;

    @Column(name = "indice_macromedicao_volume_disponibilizado")
    public Double indiceMacromedicaoVolumeDisponibilizado;

    @Column(name = "indice_macromedicao")
    public Double indiceMacromedicao;

    @Column(name = "indice_perda_faturamento")
    public Double indicePerdaFaturamento;

    @Column(name = "indice_micromedido_economia")
    public Double indiceMicromedidoEconomia;

    @Column(name = "indice_coleta_esgoto")
    public Double indiceColetaEsgoto;

    @Column(name = "indice_tratamento_esgoto")
    public Double indiceTratamentoEsgoto;

    @Column(name = "indice_consumo_agua_faturado")
    public Double indiceConsumoAguaFaturado;

    @Column(name = "indice_extensao_agua_ligacao")
    public Double indiceExtensaoAguaLigacao;

    @Column(name = "indice_extensao_esgoto_ligacao")
    public Double indiceExtensaoEsgotoLigacao;

    @Column(name = "indice_consumo_agua_per_capita")
    public Double indiceConsumoAguaPerCapita;

    @Column(name = "indice_atendimento_urbano_agua")
    public Double indiceAtendimentoUrbanoAgua;

    @Column(name = "indice_atendimento_agua_esgoto")
    public Double indiceAtendimentoAguaEsgoto;

    @Column(name = "indice_volume_agua_economia")
    public Double indiceVolumeAguaEconomia;

    @Column(name = "indice_faturamento_agua")
    public Double indiceFaturamentoAgua;

    @Column(name = "indice_participacao_economia_agua")
    public Double indiceParticipacaoEconomiaAgua;

    @Column(name = "indice_micromedicao_relativo_agua")
    public Double indiceMicromedicaoRelativoAgua;

    @Column(name = "indice_esgotamento_agua_consumida")
    public Double indiceEsgotamentoAguaConsumida;

    @Column(name = "indice_atendimento_esgoto_esgoto")
    public Double indiceAtendimentoEsgotoEsgoto;

    @Column(name = "indice_perda_distribuicao_agua")
    public Double indicePerdaDistribuicaoAgua;

    @Column(name = "indice_perda_linear_agua")
    public Double indicePerdaLinearAgua;

    @Column(name = "indice_perda_ligacao_agua")
    public Double indicePerdaLigacaoAgua;

    @Column(name = "indice_consumo_agua")
    public Double indiceConsumoAgua;

    @Column(name = "indice_consumo_medio_agua")
    public Double indiceConsumoMedioAgua;

    @Column(name = "indice_atendimento_total_agua")
    public Double indiceAtendimentoTotalAgua;

    @Column(name = "indice_atendimento_esgoto_agua")
    public Double indiceAtendimentoEsgotoAgua;

    @Column(name = "indice_fluoretacao_agua")
    public Double indiceFluoretacaoAgua;

    @Column(name = "indice_consumo_energia_agua")
    public Double indiceConsumoEnergiaAgua;

    @Column(name = "indice_consumo_energia_esgoto")
    public Double indiceConsumoEnergiaEsgoto;

    @Column(name = "receita_operacional_direta")
    public Double receitaOperacionalDireta;

    @Column(name = "receita_operacional_direta_agua")
    public Double receitaOperacionalDiretaAgua;

    @Column(name = "receita_operacional_direta_esgoto")
    public Double receitaOperacionalDiretaEsgoto;

    @Column(name = "receita_operacional_indireta")
    public Double receitaOperacionalIndireta;

    @Column(name = "receita_operacional_direta_agua_exportada")
    public Double receitaOperacionalDiretaAguaExportada;

    @Column(name = "receita_operacional")
    public Double receitaOperacional;

    @Column(name = "receita_operacional_direta_esgoto_importado")
    public Double receitaOperacionalDiretaEsgotoImportado;

    @Column(name = "arrecadacao_total")
    public Double arrecadacaoTotal;

    @Column(name = "credito_areceber")
    public Double creditoAreceber;

    @Column(name = "despesa_pessoal")
    public Double despesaPessoal;

    @Column(name = "quantidade_empregado")
    public Double quantidadeEmpregado;

    @Column(name = "despesa_produto_quimico")
    public Double despesaProdutoQuimico;

    @Column(name = "despesa_energia")
    public Double despesaEnergia;

    @Column(name = "despesa_servico_terceiro")
    public Double despesaServicoTerceiro;

    @Column(name = "despesa_exploracao")
    public Double despesaExploracao;

    @Column(name = "despesas_juros_divida")
    public Double despesasJurosDivida;

    @Column(name = "despesa_total_servico")
    public Double despesaTotalServico;

    @Column(name = "despesa_ativo")
    public Double despesaAtivo;

    @Column(name = "despesa_agua_importada")
    public Double despesaAguaImportada;

    @Column(name = "despesa_fiscal")
    public Double despesaFiscal;

    @Column(name = "despesa_fiscal_nao_computada")
    public Double despesaFiscalNaoComputada;

    @Column(name = "despesa_exploracao_outro")
    public Double despesaExploracaoOutro;

    @Column(name = "despesa_servico_outro")
    public Double despesaServicoOutro;

    @Column(name = "despesa_amortizacao_divida")
    public Double despesaAmortizacaoDivida;

    @Column(name = "despesas_juros_divida_excecao")
    public Double despesasJurosDividaExcecao;

    @Column(name = "despesa_divida_variacao")
    public Double despesaDividaVariacao;

    @Column(name = "despesa_divida_total")
    public Double despesaDividaTotal;

    @Column(name = "despesa_esgoto_exportado")
    public Double despesaEsgotoExportado;

    @Column(name = "despesa_capitalizavel_municipio")
    public Double despesaCapitalizavelMunicipio;

    @Column(name = "despesa_capitalizavel_estado")
    public Double despesaCapitalizavelEstado;

    @Column(name = "despesa_capitalizavel_prestador")
    public Double despesaCapitalizavelPrestador;

    @Column(name = "investimento_agua_prestador")
    public Double investimentoAguaPrestador;

    @Column(name = "investimento_esgoto_prestador")
    public Double investimentoEsgotoPrestador;

    @Column(name = "investimento_outro_prestador")
    public Double investimentoOutroPrestador;

    @Column(name = "investimento_recurso_proprio_prestador")
    public Double investimentoRecursoProprioPrestador;

    @Column(name = "investimento_recurso_oneroso_prestador")
    public Double investimentoRecursoOnerosoPrestador;

    @Column(name = "investimento_recurso_nao_oneroso_prestador")
    public Double investimentoRecursoNaoOnerosoPrestador;

    @Column(name = "investimento_total_prestador")
    public Double investimentoTotalPrestador;

    @Column(name = "investimento_agua_municipio")
    public Double investimentoAguaMunicipio;

    @Column(name = "investimento_esgoto_municipio")
    public Double investimentoEsgotoMunicipio;

    @Column(name = "investimento_outro_municipio")
    public Double investimentoOutroMunicipio;

    @Column(name = "investimento_recurso_proprio_municipio")
    public Double investimentoRecursoProprioMunicipio;

    @Column(name = "investimento_recurso_oneroso_municipio")
    public Double investimentoRecursoOnerosoMunicipio;

    @Column(name = "investimento_recurso_nao_oneroso_municipio")
    public Double investimentoRecursoNaoOnerosoMunicipio;

    @Column(name = "investimento_total_municipio")
    public Double investimentoTotalMunicipio;

    @Column(name = "investimento_agua_estado")
    public Double investimentoAguaEstado;

    @Column(name = "investimento_esgoto_estado")
    public Double investimentoEsgotoEstado;

    @Column(name = "investimento_outro_estado")
    public Double investimentoOutroEstado;

    @Column(name = "investimento_recurso_proprio_estado")
    public Double investimentoRecursoProprioEstado;

    @Column(name = "investimento_recurso_oneroso_estado")
    public Double investimentoRecursoOnerosoEstado;

    @Column(name = "investimento_recurso_nao_oneroso_estado")
    public Double investimentoRecursoNaoOnerosoEstado;

    @Column(name = "investimento_total_estado")
    public Double investimentoTotalEstado;

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public Long getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(Long idPrestador) {
        this.idPrestador = idPrestador;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public String getSiglaPrestador() {
        return siglaPrestador;
    }

    public void setSiglaPrestador(String siglaPrestador) {
        this.siglaPrestador = siglaPrestador;
    }

    public String getAbrangencia() {
        return abrangencia;
    }

    public void setAbrangencia(String abrangencia) {
        this.abrangencia = abrangencia;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getNaturezaJuridica() {
        return naturezaJuridica;
    }

    public void setNaturezaJuridica(String naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }

    public Double getPopulacaoAtendidaAgua() {
        return populacaoAtendidaAgua;
    }

    public void setPopulacaoAtendidaAgua(Double populacaoAtendidaAgua) {
        this.populacaoAtendidaAgua = populacaoAtendidaAgua;
    }

    public Double getPopulacaoAtentidaEsgoto() {
        return populacaoAtentidaEsgoto;
    }

    public void setPopulacaoAtentidaEsgoto(Double populacaoAtentidaEsgoto) {
        this.populacaoAtentidaEsgoto = populacaoAtentidaEsgoto;
    }

    public Double getPopulacaoUrbana() {
        return populacaoUrbana;
    }

    public void setPopulacaoUrbana(Double populacaoUrbana) {
        this.populacaoUrbana = populacaoUrbana;
    }

    public Double getPopulacaoUrbanaAtendidaAgua() {
        return populacaoUrbanaAtendidaAgua;
    }

    public void setPopulacaoUrbanaAtendidaAgua(Double populacaoUrbanaAtendidaAgua) {
        this.populacaoUrbanaAtendidaAgua = populacaoUrbanaAtendidaAgua;
    }

    public Double getPopulacaoUrbanaAtendidaEsgoto() {
        return populacaoUrbanaAtendidaEsgoto;
    }

    public void setPopulacaoUrbanaAtendidaEsgoto(Double populacaoUrbanaAtendidaEsgoto) {
        this.populacaoUrbanaAtendidaEsgoto = populacaoUrbanaAtendidaEsgoto;
    }

    public Double getExtensaoRedeAgua() {
        return extensaoRedeAgua;
    }

    public void setExtensaoRedeAgua(Double extensaoRedeAgua) {
        this.extensaoRedeAgua = extensaoRedeAgua;
    }

    public Double getExtensaoRedeEsgoto() {
        return extensaoRedeEsgoto;
    }

    public void setExtensaoRedeEsgoto(Double extensaoRedeEsgoto) {
        this.extensaoRedeEsgoto = extensaoRedeEsgoto;
    }

    public Double getAnoVencimentoDelegacaoAgua() {
        return anoVencimentoDelegacaoAgua;
    }

    public void setAnoVencimentoDelegacaoAgua(Double anoVencimentoDelegacaoAgua) {
        this.anoVencimentoDelegacaoAgua = anoVencimentoDelegacaoAgua;
    }

    public Double getAnoVencimentoDelegacaoEsgoto() {
        return anoVencimentoDelegacaoEsgoto;
    }

    public void setAnoVencimentoDelegacaoEsgoto(Double anoVencimentoDelegacaoEsgoto) {
        this.anoVencimentoDelegacaoEsgoto = anoVencimentoDelegacaoEsgoto;
    }

    public Double getQuantidadeMunicipiosAguaDelegacaoVigor() {
        return quantidadeMunicipiosAguaDelegacaoVigor;
    }

    public void setQuantidadeMunicipiosAguaDelegacaoVigor(Double quantidadeMunicipiosAguaDelegacaoVigor) {
        this.quantidadeMunicipiosAguaDelegacaoVigor = quantidadeMunicipiosAguaDelegacaoVigor;
    }

    public Double getQuantidadeMunicipiosEsgotoDelegacaoVigor() {
        return quantidadeMunicipiosEsgotoDelegacaoVigor;
    }

    public void setQuantidadeMunicipiosEsgotoDelegacaoVigor(Double quantidadeMunicipiosEsgotoDelegacaoVigor) {
        this.quantidadeMunicipiosEsgotoDelegacaoVigor = quantidadeMunicipiosEsgotoDelegacaoVigor;
    }

    public Double getQuantidadeMunicipiosAguaDelegacaoVencida() {
        return quantidadeMunicipiosAguaDelegacaoVencida;
    }

    public void setQuantidadeMunicipiosAguaDelegacaoVencida(Double quantidadeMunicipiosAguaDelegacaoVencida) {
        this.quantidadeMunicipiosAguaDelegacaoVencida = quantidadeMunicipiosAguaDelegacaoVencida;
    }

    public Double getQuantidadeMunicipiosEsgotoDelegacaoVencida() {
        return quantidadeMunicipiosEsgotoDelegacaoVencida;
    }

    public void setQuantidadeMunicipiosEsgotoDelegacaoVencida(Double quantidadeMunicipiosEsgotoDelegacaoVencida) {
        this.quantidadeMunicipiosEsgotoDelegacaoVencida = quantidadeMunicipiosEsgotoDelegacaoVencida;
    }

    public Double getQuantidadeMunicipiosAguaSemDelegacao() {
        return quantidadeMunicipiosAguaSemDelegacao;
    }

    public void setQuantidadeMunicipiosAguaSemDelegacao(Double quantidadeMunicipiosAguaSemDelegacao) {
        this.quantidadeMunicipiosAguaSemDelegacao = quantidadeMunicipiosAguaSemDelegacao;
    }

    public Double getQuantidadeMunicipiosEsgotoSemDelegacao() {
        return quantidadeMunicipiosEsgotoSemDelegacao;
    }

    public void setQuantidadeMunicipiosEsgotoSemDelegacao(Double quantidadeMunicipiosEsgotoSemDelegacao) {
        this.quantidadeMunicipiosEsgotoSemDelegacao = quantidadeMunicipiosEsgotoSemDelegacao;
    }

    public Double getQuantidadeMunicipiosSemEsgotoSemDelegacao() {
        return quantidadeMunicipiosSemEsgotoSemDelegacao;
    }

    public void setQuantidadeMunicipiosSemEsgotoSemDelegacao(Double quantidadeMunicipiosSemEsgotoSemDelegacao) {
        this.quantidadeMunicipiosSemEsgotoSemDelegacao = quantidadeMunicipiosSemEsgotoSemDelegacao;
    }

    public Double getQuantidadeSedeMunicipalAgua() {
        return quantidadeSedeMunicipalAgua;
    }

    public void setQuantidadeSedeMunicipalAgua(Double quantidadeSedeMunicipalAgua) {
        this.quantidadeSedeMunicipalAgua = quantidadeSedeMunicipalAgua;
    }

    public Double getQuantidadeSedeMunicipalEsgoto() {
        return quantidadeSedeMunicipalEsgoto;
    }

    public void setQuantidadeSedeMunicipalEsgoto(Double quantidadeSedeMunicipalEsgoto) {
        this.quantidadeSedeMunicipalEsgoto = quantidadeSedeMunicipalEsgoto;
    }

    public Double getQuantidadeLocalidadeAgua() {
        return quantidadeLocalidadeAgua;
    }

    public void setQuantidadeLocalidadeAgua(Double quantidadeLocalidadeAgua) {
        this.quantidadeLocalidadeAgua = quantidadeLocalidadeAgua;
    }

    public Double getQuantidadeLocalidadeEsgoto() {
        return quantidadeLocalidadeEsgoto;
    }

    public void setQuantidadeLocalidadeEsgoto(Double quantidadeLocalidadeEsgoto) {
        this.quantidadeLocalidadeEsgoto = quantidadeLocalidadeEsgoto;
    }

    public Double getQuantidadeLigacaoTotalAgua() {
        return quantidadeLigacaoTotalAgua;
    }

    public void setQuantidadeLigacaoTotalAgua(Double quantidadeLigacaoTotalAgua) {
        this.quantidadeLigacaoTotalAgua = quantidadeLigacaoTotalAgua;
    }

    public Double getQuantidadeLigacaoTotalEsgoto() {
        return quantidadeLigacaoTotalEsgoto;
    }

    public void setQuantidadeLigacaoTotalEsgoto(Double quantidadeLigacaoTotalEsgoto) {
        this.quantidadeLigacaoTotalEsgoto = quantidadeLigacaoTotalEsgoto;
    }

    public Double getQuantidadeLigacaoAtivaAgua() {
        return quantidadeLigacaoAtivaAgua;
    }

    public void setQuantidadeLigacaoAtivaAgua(Double quantidadeLigacaoAtivaAgua) {
        this.quantidadeLigacaoAtivaAgua = quantidadeLigacaoAtivaAgua;
    }

    public Double getQuantidadeLigacaoAtivaEsgoto() {
        return quantidadeLigacaoAtivaEsgoto;
    }

    public void setQuantidadeLigacaoAtivaEsgoto(Double quantidadeLigacaoAtivaEsgoto) {
        this.quantidadeLigacaoAtivaEsgoto = quantidadeLigacaoAtivaEsgoto;
    }

    public Double getQuantidadeEconomiaAtivaAgua() {
        return quantidadeEconomiaAtivaAgua;
    }

    public void setQuantidadeEconomiaAtivaAgua(Double quantidadeEconomiaAtivaAgua) {
        this.quantidadeEconomiaAtivaAgua = quantidadeEconomiaAtivaAgua;
    }

    public Double getQuantidadeEconomiaAtivaEsgoto() {
        return quantidadeEconomiaAtivaEsgoto;
    }

    public void setQuantidadeEconomiaAtivaEsgoto(Double quantidadeEconomiaAtivaEsgoto) {
        this.quantidadeEconomiaAtivaEsgoto = quantidadeEconomiaAtivaEsgoto;
    }

    public Double getQuantidadeLigacaoMicromediaAtivaAgua() {
        return quantidadeLigacaoMicromediaAtivaAgua;
    }

    public void setQuantidadeLigacaoMicromediaAtivaAgua(Double quantidadeLigacaoMicromediaAtivaAgua) {
        this.quantidadeLigacaoMicromediaAtivaAgua = quantidadeLigacaoMicromediaAtivaAgua;
    }

    public Double getQuantidadeEconomiaResidencialAtivaAgua() {
        return quantidadeEconomiaResidencialAtivaAgua;
    }

    public void setQuantidadeEconomiaResidencialAtivaAgua(Double quantidadeEconomiaResidencialAtivaAgua) {
        this.quantidadeEconomiaResidencialAtivaAgua = quantidadeEconomiaResidencialAtivaAgua;
    }

    public Double getQuantidadeEconomiaMicromedidaAtivaAgua() {
        return quantidadeEconomiaMicromedidaAtivaAgua;
    }

    public void setQuantidadeEconomiaMicromedidaAtivaAgua(Double quantidadeEconomiaMicromedidaAtivaAgua) {
        this.quantidadeEconomiaMicromedidaAtivaAgua = quantidadeEconomiaMicromedidaAtivaAgua;
    }

    public Double getQuantidadeEconomiaResidencialMicromedidaAtivaAgua() {
        return quantidadeEconomiaResidencialMicromedidaAtivaAgua;
    }

    public void setQuantidadeEconomiaResidencialMicromedidaAtivaAgua(Double quantidadeEconomiaResidencialMicromedidaAtivaAgua) {
        this.quantidadeEconomiaResidencialMicromedidaAtivaAgua = quantidadeEconomiaResidencialMicromedidaAtivaAgua;
    }

    public Double getQuantidadeEconomiaResidencialAtivaEsgoto() {
        return quantidadeEconomiaResidencialAtivaEsgoto;
    }

    public void setQuantidadeEconomiaResidencialAtivaEsgoto(Double quantidadeEconomiaResidencialAtivaEsgoto) {
        this.quantidadeEconomiaResidencialAtivaEsgoto = quantidadeEconomiaResidencialAtivaEsgoto;
    }

    public Double getVolumeAguaProduzido() {
        return volumeAguaProduzido;
    }

    public void setVolumeAguaProduzido(Double volumeAguaProduzido) {
        this.volumeAguaProduzido = volumeAguaProduzido;
    }

    public Double getVolumeAguaTratadaEta() {
        return volumeAguaTratadaEta;
    }

    public void setVolumeAguaTratadaEta(Double volumeAguaTratadaEta) {
        this.volumeAguaTratadaEta = volumeAguaTratadaEta;
    }

    public Double getVolumeAguaMicromedido() {
        return volumeAguaMicromedido;
    }

    public void setVolumeAguaMicromedido(Double volumeAguaMicromedido) {
        this.volumeAguaMicromedido = volumeAguaMicromedido;
    }

    public Double getVolumeAguaConsumido() {
        return volumeAguaConsumido;
    }

    public void setVolumeAguaConsumido(Double volumeAguaConsumido) {
        this.volumeAguaConsumido = volumeAguaConsumido;
    }

    public Double getVolumeAguaFaturado() {
        return volumeAguaFaturado;
    }

    public void setVolumeAguaFaturado(Double volumeAguaFaturado) {
        this.volumeAguaFaturado = volumeAguaFaturado;
    }

    public Double getVolumeAguaMacromedido() {
        return volumeAguaMacromedido;
    }

    public void setVolumeAguaMacromedido(Double volumeAguaMacromedido) {
        this.volumeAguaMacromedido = volumeAguaMacromedido;
    }

    public Double getVolumeAguaTratadaDesinfeccao() {
        return volumeAguaTratadaDesinfeccao;
    }

    public void setVolumeAguaTratadaDesinfeccao(Double volumeAguaTratadaDesinfeccao) {
        this.volumeAguaTratadaDesinfeccao = volumeAguaTratadaDesinfeccao;
    }

    public Double getVolumeAguaBrutaExportado() {
        return volumeAguaBrutaExportado;
    }

    public void setVolumeAguaBrutaExportado(Double volumeAguaBrutaExportado) {
        this.volumeAguaBrutaExportado = volumeAguaBrutaExportado;
    }

    public Double getVolumeAguaTratadaImportado() {
        return volumeAguaTratadaImportado;
    }

    public void setVolumeAguaTratadaImportado(Double volumeAguaTratadaImportado) {
        this.volumeAguaTratadaImportado = volumeAguaTratadaImportado;
    }

    public Double getVolumeAguaTratadaExportado() {
        return volumeAguaTratadaExportado;
    }

    public void setVolumeAguaTratadaExportado(Double volumeAguaTratadaExportado) {
        this.volumeAguaTratadaExportado = volumeAguaTratadaExportado;
    }

    public Double getVolumeAguaMicromedidoEconomiaAtiva() {
        return volumeAguaMicromedidoEconomiaAtiva;
    }

    public void setVolumeAguaMicromedidoEconomiaAtiva(Double volumeAguaMicromedidoEconomiaAtiva) {
        this.volumeAguaMicromedidoEconomiaAtiva = volumeAguaMicromedidoEconomiaAtiva;
    }

    public Double getVolumeServicoAgua() {
        return volumeServicoAgua;
    }

    public void setVolumeServicoAgua(Double volumeServicoAgua) {
        this.volumeServicoAgua = volumeServicoAgua;
    }

    public Double getVolumeAguaFluoretada() {
        return volumeAguaFluoretada;
    }

    public void setVolumeAguaFluoretada(Double volumeAguaFluoretada) {
        this.volumeAguaFluoretada = volumeAguaFluoretada;
    }

    public Double getConsumoEletricoSistemasAgua() {
        return consumoEletricoSistemasAgua;
    }

    public void setConsumoEletricoSistemasAgua(Double consumoEletricoSistemasAgua) {
        this.consumoEletricoSistemasAgua = consumoEletricoSistemasAgua;
    }

    public Double getVolumeEsgotoColetado() {
        return volumeEsgotoColetado;
    }

    public void setVolumeEsgotoColetado(Double volumeEsgotoColetado) {
        this.volumeEsgotoColetado = volumeEsgotoColetado;
    }

    public Double getVolumeEsgotoTratado() {
        return volumeEsgotoTratado;
    }

    public void setVolumeEsgotoTratado(Double volumeEsgotoTratado) {
        this.volumeEsgotoTratado = volumeEsgotoTratado;
    }

    public Double getVolumeEsgotoFaturado() {
        return volumeEsgotoFaturado;
    }

    public void setVolumeEsgotoFaturado(Double volumeEsgotoFaturado) {
        this.volumeEsgotoFaturado = volumeEsgotoFaturado;
    }

    public Double getVolumeEsgotoBrutoExportado() {
        return volumeEsgotoBrutoExportado;
    }

    public void setVolumeEsgotoBrutoExportado(Double volumeEsgotoBrutoExportado) {
        this.volumeEsgotoBrutoExportado = volumeEsgotoBrutoExportado;
    }

    public Double getVolumeEsgotoBrutoImportado() {
        return volumeEsgotoBrutoImportado;
    }

    public void setVolumeEsgotoBrutoImportado(Double volumeEsgotoBrutoImportado) {
        this.volumeEsgotoBrutoImportado = volumeEsgotoBrutoImportado;
    }

    public Double getVolumeEsgotoImportado() {
        return volumeEsgotoImportado;
    }

    public void setVolumeEsgotoImportado(Double volumeEsgotoImportado) {
        this.volumeEsgotoImportado = volumeEsgotoImportado;
    }

    public Double getVolumeEsgotoBrutoExportadoTratamentoImportador() {
        return volumeEsgotoBrutoExportadoTratamentoImportador;
    }

    public void setVolumeEsgotoBrutoExportadoTratamentoImportador(Double volumeEsgotoBrutoExportadoTratamentoImportador) {
        this.volumeEsgotoBrutoExportadoTratamentoImportador = volumeEsgotoBrutoExportadoTratamentoImportador;
    }

    public Double getConsumoEletricoSistemasEsgoto() {
        return consumoEletricoSistemasEsgoto;
    }

    public void setConsumoEletricoSistemasEsgoto(Double consumoEletricoSistemasEsgoto) {
        this.consumoEletricoSistemasEsgoto = consumoEletricoSistemasEsgoto;
    }

    public Double getIndiceAguaLigacao() {
        return indiceAguaLigacao;
    }

    public void setIndiceAguaLigacao(Double indiceAguaLigacao) {
        this.indiceAguaLigacao = indiceAguaLigacao;
    }

    public Double getIndiceHidrometracao() {
        return indiceHidrometracao;
    }

    public void setIndiceHidrometracao(Double indiceHidrometracao) {
        this.indiceHidrometracao = indiceHidrometracao;
    }

    public Double getIndiceMacromedicaoVolumeDisponibilizado() {
        return indiceMacromedicaoVolumeDisponibilizado;
    }

    public void setIndiceMacromedicaoVolumeDisponibilizado(Double indiceMacromedicaoVolumeDisponibilizado) {
        this.indiceMacromedicaoVolumeDisponibilizado = indiceMacromedicaoVolumeDisponibilizado;
    }

    public Double getIndiceMacromedicao() {
        return indiceMacromedicao;
    }

    public void setIndiceMacromedicao(Double indiceMacromedicao) {
        this.indiceMacromedicao = indiceMacromedicao;
    }

    public Double getIndicePerdaFaturamento() {
        return indicePerdaFaturamento;
    }

    public void setIndicePerdaFaturamento(Double indicePerdaFaturamento) {
        this.indicePerdaFaturamento = indicePerdaFaturamento;
    }

    public Double getIndiceMicromedidoEconomia() {
        return indiceMicromedidoEconomia;
    }

    public void setIndiceMicromedidoEconomia(Double indiceMicromedidoEconomia) {
        this.indiceMicromedidoEconomia = indiceMicromedidoEconomia;
    }

    public Double getIndiceColetaEsgoto() {
        return indiceColetaEsgoto;
    }

    public void setIndiceColetaEsgoto(Double indiceColetaEsgoto) {
        this.indiceColetaEsgoto = indiceColetaEsgoto;
    }

    public Double getIndiceTratamentoEsgoto() {
        return indiceTratamentoEsgoto;
    }

    public void setIndiceTratamentoEsgoto(Double indiceTratamentoEsgoto) {
        this.indiceTratamentoEsgoto = indiceTratamentoEsgoto;
    }

    public Double getIndiceConsumoAguaFaturado() {
        return indiceConsumoAguaFaturado;
    }

    public void setIndiceConsumoAguaFaturado(Double indiceConsumoAguaFaturado) {
        this.indiceConsumoAguaFaturado = indiceConsumoAguaFaturado;
    }

    public Double getIndiceExtensaoAguaLigacao() {
        return indiceExtensaoAguaLigacao;
    }

    public void setIndiceExtensaoAguaLigacao(Double indiceExtensaoAguaLigacao) {
        this.indiceExtensaoAguaLigacao = indiceExtensaoAguaLigacao;
    }

    public Double getIndiceExtensaoEsgotoLigacao() {
        return indiceExtensaoEsgotoLigacao;
    }

    public void setIndiceExtensaoEsgotoLigacao(Double indiceExtensaoEsgotoLigacao) {
        this.indiceExtensaoEsgotoLigacao = indiceExtensaoEsgotoLigacao;
    }

    public Double getIndiceConsumoAguaPerCapita() {
        return indiceConsumoAguaPerCapita;
    }

    public void setIndiceConsumoAguaPerCapita(Double indiceConsumoAguaPerCapita) {
        this.indiceConsumoAguaPerCapita = indiceConsumoAguaPerCapita;
    }

    public Double getIndiceAtendimentoUrbanoAgua() {
        return indiceAtendimentoUrbanoAgua;
    }

    public void setIndiceAtendimentoUrbanoAgua(Double indiceAtendimentoUrbanoAgua) {
        this.indiceAtendimentoUrbanoAgua = indiceAtendimentoUrbanoAgua;
    }

    public Double getIndiceAtendimentoAguaEsgoto() {
        return indiceAtendimentoAguaEsgoto;
    }

    public void setIndiceAtendimentoAguaEsgoto(Double indiceAtendimentoAguaEsgoto) {
        this.indiceAtendimentoAguaEsgoto = indiceAtendimentoAguaEsgoto;
    }

    public Double getIndiceVolumeAguaEconomia() {
        return indiceVolumeAguaEconomia;
    }

    public void setIndiceVolumeAguaEconomia(Double indiceVolumeAguaEconomia) {
        this.indiceVolumeAguaEconomia = indiceVolumeAguaEconomia;
    }

    public Double getIndiceFaturamentoAgua() {
        return indiceFaturamentoAgua;
    }

    public void setIndiceFaturamentoAgua(Double indiceFaturamentoAgua) {
        this.indiceFaturamentoAgua = indiceFaturamentoAgua;
    }

    public Double getIndiceParticipacaoEconomiaAgua() {
        return indiceParticipacaoEconomiaAgua;
    }

    public void setIndiceParticipacaoEconomiaAgua(Double indiceParticipacaoEconomiaAgua) {
        this.indiceParticipacaoEconomiaAgua = indiceParticipacaoEconomiaAgua;
    }

    public Double getIndiceMicromedicaoRelativoAgua() {
        return indiceMicromedicaoRelativoAgua;
    }

    public void setIndiceMicromedicaoRelativoAgua(Double indiceMicromedicaoRelativoAgua) {
        this.indiceMicromedicaoRelativoAgua = indiceMicromedicaoRelativoAgua;
    }

    public Double getIndiceEsgotamentoAguaConsumida() {
        return indiceEsgotamentoAguaConsumida;
    }

    public void setIndiceEsgotamentoAguaConsumida(Double indiceEsgotamentoAguaConsumida) {
        this.indiceEsgotamentoAguaConsumida = indiceEsgotamentoAguaConsumida;
    }

    public Double getIndiceAtendimentoEsgotoEsgoto() {
        return indiceAtendimentoEsgotoEsgoto;
    }

    public void setIndiceAtendimentoEsgotoEsgoto(Double indiceAtendimentoEsgotoEsgoto) {
        this.indiceAtendimentoEsgotoEsgoto = indiceAtendimentoEsgotoEsgoto;
    }

    public Double getIndicePerdaDistribuicaoAgua() {
        return indicePerdaDistribuicaoAgua;
    }

    public void setIndicePerdaDistribuicaoAgua(Double indicePerdaDistribuicaoAgua) {
        this.indicePerdaDistribuicaoAgua = indicePerdaDistribuicaoAgua;
    }

    public Double getIndicePerdaLinearAgua() {
        return indicePerdaLinearAgua;
    }

    public void setIndicePerdaLinearAgua(Double indicePerdaLinearAgua) {
        this.indicePerdaLinearAgua = indicePerdaLinearAgua;
    }

    public Double getIndicePerdaLigacaoAgua() {
        return indicePerdaLigacaoAgua;
    }

    public void setIndicePerdaLigacaoAgua(Double indicePerdaLigacaoAgua) {
        this.indicePerdaLigacaoAgua = indicePerdaLigacaoAgua;
    }

    public Double getIndiceConsumoAgua() {
        return indiceConsumoAgua;
    }

    public void setIndiceConsumoAgua(Double indiceConsumoAgua) {
        this.indiceConsumoAgua = indiceConsumoAgua;
    }

    public Double getIndiceConsumoMedioAgua() {
        return indiceConsumoMedioAgua;
    }

    public void setIndiceConsumoMedioAgua(Double indiceConsumoMedioAgua) {
        this.indiceConsumoMedioAgua = indiceConsumoMedioAgua;
    }

    public Double getIndiceAtendimentoTotalAgua() {
        return indiceAtendimentoTotalAgua;
    }

    public void setIndiceAtendimentoTotalAgua(Double indiceAtendimentoTotalAgua) {
        this.indiceAtendimentoTotalAgua = indiceAtendimentoTotalAgua;
    }

    public Double getIndiceAtendimentoEsgotoAgua() {
        return indiceAtendimentoEsgotoAgua;
    }

    public void setIndiceAtendimentoEsgotoAgua(Double indiceAtendimentoEsgotoAgua) {
        this.indiceAtendimentoEsgotoAgua = indiceAtendimentoEsgotoAgua;
    }

    public Double getIndiceFluoretacaoAgua() {
        return indiceFluoretacaoAgua;
    }

    public void setIndiceFluoretacaoAgua(Double indiceFluoretacaoAgua) {
        this.indiceFluoretacaoAgua = indiceFluoretacaoAgua;
    }

    public Double getIndiceConsumoEnergiaAgua() {
        return indiceConsumoEnergiaAgua;
    }

    public void setIndiceConsumoEnergiaAgua(Double indiceConsumoEnergiaAgua) {
        this.indiceConsumoEnergiaAgua = indiceConsumoEnergiaAgua;
    }

    public Double getIndiceConsumoEnergiaEsgoto() {
        return indiceConsumoEnergiaEsgoto;
    }

    public void setIndiceConsumoEnergiaEsgoto(Double indiceConsumoEnergiaEsgoto) {
        this.indiceConsumoEnergiaEsgoto = indiceConsumoEnergiaEsgoto;
    }

    public Double getReceitaOperacionalDireta() {
        return receitaOperacionalDireta;
    }

    public void setReceitaOperacionalDireta(Double receitaOperacionalDireta) {
        this.receitaOperacionalDireta = receitaOperacionalDireta;
    }

    public Double getReceitaOperacionalDiretaAgua() {
        return receitaOperacionalDiretaAgua;
    }

    public void setReceitaOperacionalDiretaAgua(Double receitaOperacionalDiretaAgua) {
        this.receitaOperacionalDiretaAgua = receitaOperacionalDiretaAgua;
    }

    public Double getReceitaOperacionalDiretaEsgoto() {
        return receitaOperacionalDiretaEsgoto;
    }

    public void setReceitaOperacionalDiretaEsgoto(Double receitaOperacionalDiretaEsgoto) {
        this.receitaOperacionalDiretaEsgoto = receitaOperacionalDiretaEsgoto;
    }

    public Double getReceitaOperacionalIndireta() {
        return receitaOperacionalIndireta;
    }

    public void setReceitaOperacionalIndireta(Double receitaOperacionalIndireta) {
        this.receitaOperacionalIndireta = receitaOperacionalIndireta;
    }

    public Double getReceitaOperacionalDiretaAguaExportada() {
        return receitaOperacionalDiretaAguaExportada;
    }

    public void setReceitaOperacionalDiretaAguaExportada(Double receitaOperacionalDiretaAguaExportada) {
        this.receitaOperacionalDiretaAguaExportada = receitaOperacionalDiretaAguaExportada;
    }

    public Double getReceitaOperacional() {
        return receitaOperacional;
    }

    public void setReceitaOperacional(Double receitaOperacional) {
        this.receitaOperacional = receitaOperacional;
    }

    public Double getReceitaOperacionalDiretaEsgotoImportado() {
        return receitaOperacionalDiretaEsgotoImportado;
    }

    public void setReceitaOperacionalDiretaEsgotoImportado(Double receitaOperacionalDiretaEsgotoImportado) {
        this.receitaOperacionalDiretaEsgotoImportado = receitaOperacionalDiretaEsgotoImportado;
    }

    public Double getArrecadacaoTotal() {
        return arrecadacaoTotal;
    }

    public void setArrecadacaoTotal(Double arrecadacaoTotal) {
        this.arrecadacaoTotal = arrecadacaoTotal;
    }

    public Double getCreditoAreceber() {
        return creditoAreceber;
    }

    public void setCreditoAreceber(Double creditoAreceber) {
        this.creditoAreceber = creditoAreceber;
    }

    public Double getDespesaPessoal() {
        return despesaPessoal;
    }

    public void setDespesaPessoal(Double despesaPessoal) {
        this.despesaPessoal = despesaPessoal;
    }

    public Double getQuantidadeEmpregado() {
        return quantidadeEmpregado;
    }

    public void setQuantidadeEmpregado(Double quantidadeEmpregado) {
        this.quantidadeEmpregado = quantidadeEmpregado;
    }

    public Double getDespesaProdutoQuimico() {
        return despesaProdutoQuimico;
    }

    public void setDespesaProdutoQuimico(Double despesaProdutoQuimico) {
        this.despesaProdutoQuimico = despesaProdutoQuimico;
    }

    public Double getDespesaEnergia() {
        return despesaEnergia;
    }

    public void setDespesaEnergia(Double despesaEnergia) {
        this.despesaEnergia = despesaEnergia;
    }

    public Double getDespesaServicoTerceiro() {
        return despesaServicoTerceiro;
    }

    public void setDespesaServicoTerceiro(Double despesaServicoTerceiro) {
        this.despesaServicoTerceiro = despesaServicoTerceiro;
    }

    public Double getDespesaExploracao() {
        return despesaExploracao;
    }

    public void setDespesaExploracao(Double despesaExploracao) {
        this.despesaExploracao = despesaExploracao;
    }

    public Double getDespesasJurosDivida() {
        return despesasJurosDivida;
    }

    public void setDespesasJurosDivida(Double despesasJurosDivida) {
        this.despesasJurosDivida = despesasJurosDivida;
    }

    public Double getDespesaTotalServico() {
        return despesaTotalServico;
    }

    public void setDespesaTotalServico(Double despesaTotalServico) {
        this.despesaTotalServico = despesaTotalServico;
    }

    public Double getDespesaAtivo() {
        return despesaAtivo;
    }

    public void setDespesaAtivo(Double despesaAtivo) {
        this.despesaAtivo = despesaAtivo;
    }

    public Double getDespesaAguaImportada() {
        return despesaAguaImportada;
    }

    public void setDespesaAguaImportada(Double despesaAguaImportada) {
        this.despesaAguaImportada = despesaAguaImportada;
    }

    public Double getDespesaFiscal() {
        return despesaFiscal;
    }

    public void setDespesaFiscal(Double despesaFiscal) {
        this.despesaFiscal = despesaFiscal;
    }

    public Double getDespesaFiscalNaoComputada() {
        return despesaFiscalNaoComputada;
    }

    public void setDespesaFiscalNaoComputada(Double despesaFiscalNaoComputada) {
        this.despesaFiscalNaoComputada = despesaFiscalNaoComputada;
    }

    public Double getDespesaExploracaoOutro() {
        return despesaExploracaoOutro;
    }

    public void setDespesaExploracaoOutro(Double despesaExploracaoOutro) {
        this.despesaExploracaoOutro = despesaExploracaoOutro;
    }

    public Double getDespesaServicoOutro() {
        return despesaServicoOutro;
    }

    public void setDespesaServicoOutro(Double despesaServicoOutro) {
        this.despesaServicoOutro = despesaServicoOutro;
    }

    public Double getDespesaAmortizacaoDivida() {
        return despesaAmortizacaoDivida;
    }

    public void setDespesaAmortizacaoDivida(Double despesaAmortizacaoDivida) {
        this.despesaAmortizacaoDivida = despesaAmortizacaoDivida;
    }

    public Double getDespesasJurosDividaExcecao() {
        return despesasJurosDividaExcecao;
    }

    public void setDespesasJurosDividaExcecao(Double despesasJurosDividaExcecao) {
        this.despesasJurosDividaExcecao = despesasJurosDividaExcecao;
    }

    public Double getDespesaDividaVariacao() {
        return despesaDividaVariacao;
    }

    public void setDespesaDividaVariacao(Double despesaDividaVariacao) {
        this.despesaDividaVariacao = despesaDividaVariacao;
    }

    public Double getDespesaDividaTotal() {
        return despesaDividaTotal;
    }

    public void setDespesaDividaTotal(Double despesaDividaTotal) {
        this.despesaDividaTotal = despesaDividaTotal;
    }

    public Double getDespesaEsgotoExportado() {
        return despesaEsgotoExportado;
    }

    public void setDespesaEsgotoExportado(Double despesaEsgotoExportado) {
        this.despesaEsgotoExportado = despesaEsgotoExportado;
    }

    public Double getDespesaCapitalizavelMunicipio() {
        return despesaCapitalizavelMunicipio;
    }

    public void setDespesaCapitalizavelMunicipio(Double despesaCapitalizavelMunicipio) {
        this.despesaCapitalizavelMunicipio = despesaCapitalizavelMunicipio;
    }

    public Double getDespesaCapitalizavelEstado() {
        return despesaCapitalizavelEstado;
    }

    public void setDespesaCapitalizavelEstado(Double despesaCapitalizavelEstado) {
        this.despesaCapitalizavelEstado = despesaCapitalizavelEstado;
    }

    public Double getDespesaCapitalizavelPrestador() {
        return despesaCapitalizavelPrestador;
    }

    public void setDespesaCapitalizavelPrestador(Double despesaCapitalizavelPrestador) {
        this.despesaCapitalizavelPrestador = despesaCapitalizavelPrestador;
    }

    public Double getInvestimentoAguaPrestador() {
        return investimentoAguaPrestador;
    }

    public void setInvestimentoAguaPrestador(Double investimentoAguaPrestador) {
        this.investimentoAguaPrestador = investimentoAguaPrestador;
    }

    public Double getInvestimentoEsgotoPrestador() {
        return investimentoEsgotoPrestador;
    }

    public void setInvestimentoEsgotoPrestador(Double investimentoEsgotoPrestador) {
        this.investimentoEsgotoPrestador = investimentoEsgotoPrestador;
    }

    public Double getInvestimentoOutroPrestador() {
        return investimentoOutroPrestador;
    }

    public void setInvestimentoOutroPrestador(Double investimentoOutroPrestador) {
        this.investimentoOutroPrestador = investimentoOutroPrestador;
    }

    public Double getInvestimentoRecursoProprioPrestador() {
        return investimentoRecursoProprioPrestador;
    }

    public void setInvestimentoRecursoProprioPrestador(Double investimentoRecursoProprioPrestador) {
        this.investimentoRecursoProprioPrestador = investimentoRecursoProprioPrestador;
    }

    public Double getInvestimentoRecursoOnerosoPrestador() {
        return investimentoRecursoOnerosoPrestador;
    }

    public void setInvestimentoRecursoOnerosoPrestador(Double investimentoRecursoOnerosoPrestador) {
        this.investimentoRecursoOnerosoPrestador = investimentoRecursoOnerosoPrestador;
    }

    public Double getInvestimentoRecursoNaoOnerosoPrestador() {
        return investimentoRecursoNaoOnerosoPrestador;
    }

    public void setInvestimentoRecursoNaoOnerosoPrestador(Double investimentoRecursoNaoOnerosoPrestador) {
        this.investimentoRecursoNaoOnerosoPrestador = investimentoRecursoNaoOnerosoPrestador;
    }

    public Double getInvestimentoTotalPrestador() {
        return investimentoTotalPrestador;
    }

    public void setInvestimentoTotalPrestador(Double investimentoTotalPrestador) {
        this.investimentoTotalPrestador = investimentoTotalPrestador;
    }

    public Double getInvestimentoAguaMunicipio() {
        return investimentoAguaMunicipio;
    }

    public void setInvestimentoAguaMunicipio(Double investimentoAguaMunicipio) {
        this.investimentoAguaMunicipio = investimentoAguaMunicipio;
    }

    public Double getInvestimentoEsgotoMunicipio() {
        return investimentoEsgotoMunicipio;
    }

    public void setInvestimentoEsgotoMunicipio(Double investimentoEsgotoMunicipio) {
        this.investimentoEsgotoMunicipio = investimentoEsgotoMunicipio;
    }

    public Double getInvestimentoOutroMunicipio() {
        return investimentoOutroMunicipio;
    }

    public void setInvestimentoOutroMunicipio(Double investimentoOutroMunicipio) {
        this.investimentoOutroMunicipio = investimentoOutroMunicipio;
    }

    public Double getInvestimentoRecursoProprioMunicipio() {
        return investimentoRecursoProprioMunicipio;
    }

    public void setInvestimentoRecursoProprioMunicipio(Double investimentoRecursoProprioMunicipio) {
        this.investimentoRecursoProprioMunicipio = investimentoRecursoProprioMunicipio;
    }

    public Double getInvestimentoRecursoOnerosoMunicipio() {
        return investimentoRecursoOnerosoMunicipio;
    }

    public void setInvestimentoRecursoOnerosoMunicipio(Double investimentoRecursoOnerosoMunicipio) {
        this.investimentoRecursoOnerosoMunicipio = investimentoRecursoOnerosoMunicipio;
    }

    public Double getInvestimentoRecursoNaoOnerosoMunicipio() {
        return investimentoRecursoNaoOnerosoMunicipio;
    }

    public void setInvestimentoRecursoNaoOnerosoMunicipio(Double investimentoRecursoNaoOnerosoMunicipio) {
        this.investimentoRecursoNaoOnerosoMunicipio = investimentoRecursoNaoOnerosoMunicipio;
    }

    public Double getInvestimentoTotalMunicipio() {
        return investimentoTotalMunicipio;
    }

    public void setInvestimentoTotalMunicipio(Double investimentoTotalMunicipio) {
        this.investimentoTotalMunicipio = investimentoTotalMunicipio;
    }

    public Double getInvestimentoAguaEstado() {
        return investimentoAguaEstado;
    }

    public void setInvestimentoAguaEstado(Double investimentoAguaEstado) {
        this.investimentoAguaEstado = investimentoAguaEstado;
    }

    public Double getInvestimentoEsgotoEstado() {
        return investimentoEsgotoEstado;
    }

    public void setInvestimentoEsgotoEstado(Double investimentoEsgotoEstado) {
        this.investimentoEsgotoEstado = investimentoEsgotoEstado;
    }

    public Double getInvestimentoOutroEstado() {
        return investimentoOutroEstado;
    }

    public void setInvestimentoOutroEstado(Double investimentoOutroEstado) {
        this.investimentoOutroEstado = investimentoOutroEstado;
    }

    public Double getInvestimentoRecursoProprioEstado() {
        return investimentoRecursoProprioEstado;
    }

    public void setInvestimentoRecursoProprioEstado(Double investimentoRecursoProprioEstado) {
        this.investimentoRecursoProprioEstado = investimentoRecursoProprioEstado;
    }

    public Double getInvestimentoRecursoOnerosoEstado() {
        return investimentoRecursoOnerosoEstado;
    }

    public void setInvestimentoRecursoOnerosoEstado(Double investimentoRecursoOnerosoEstado) {
        this.investimentoRecursoOnerosoEstado = investimentoRecursoOnerosoEstado;
    }

    public Double getInvestimentoRecursoNaoOnerosoEstado() {
        return investimentoRecursoNaoOnerosoEstado;
    }

    public void setInvestimentoRecursoNaoOnerosoEstado(Double investimentoRecursoNaoOnerosoEstado) {
        this.investimentoRecursoNaoOnerosoEstado = investimentoRecursoNaoOnerosoEstado;
    }

    public Double getInvestimentoTotalEstado() {
        return investimentoTotalEstado;
    }

    public void setInvestimentoTotalEstado(Double investimentoTotalEstado) {
        this.investimentoTotalEstado = investimentoTotalEstado;
    }

}
