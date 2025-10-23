package br.unitins.hackathon.sismato.resource.sisagua;
import br.unitins.hackathon.sismato.dto.sisagua.ResumoPontoAmostrasDTO;

import java.util.List;

import br.unitins.hackathon.sismato.dto.sisagua.ComparacaoMunicipiosDTO;
import br.unitins.hackathon.sismato.dto.sisagua.EvolucaoQualidadeMunicipioDTO;
import br.unitins.hackathon.sismato.dto.sisagua.MensalAmostrasResumoPorAnoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.ParametrosCriticosMunicipioDTO;
import br.unitins.hackathon.sismato.dto.sisagua.QualidadeAguaMunicipioDTO;
import br.unitins.hackathon.sismato.dto.sisagua.RankingMunicipioAnoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.RankingMunicipioDTO;
import br.unitins.hackathon.sismato.dto.sisagua.ResumoPontoAmostrasDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TimeSeriesParametroDTO;
import br.unitins.hackathon.sismato.entity.sisagua.MensalAmostras;
import br.unitins.hackathon.sismato.service.sisagua.MensalAmostrasService;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/api/mensal-amostras")
@Produces(MediaType.APPLICATION_JSON)
public class MensalAmostrasResource {

    @Inject
    MensalAmostrasService service;

    @GET
    public List<MensalAmostras> listAll(@QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("50") int pageSize) {
        return service.findAllPaged(page, pageSize);
    }

    // percentual de inconformidade geral por municipio anualmente
    @GET
    @Path("/resumo-ano")
    public List<MensalAmostrasResumoPorAnoDTO> resumoPorAno(
            @QueryParam("uf") @DefaultValue("TO") String uf) {
        return service.resumoPorAnoPorUf(uf);
    }

    // maiores indices de percentualInconformidadeGeral
    @GET
    @Path("/ranking-municipios")
    public List<RankingMunicipioDTO> rankingMunicipios(
            @QueryParam("uf") String uf,
            @QueryParam("minAmostras") @DefaultValue("100") int minAmostras,
            @QueryParam("limit") @DefaultValue("20") int limit) {
        if (uf != null && !uf.isEmpty()) {
            return service.rankingMunicipiosGeralPorUf(uf, minAmostras, limit);
        } else {
            return service.rankingMunicipiosGeralTO(minAmostras, limit);
        }
    }

    // percentual inconformidade anual por municipio
    @GET
    @Path("/ranking-municipios-por-ano")
    public List<RankingMunicipioAnoDTO> rankingMunicipiosPorAno(
            @QueryParam("uf") String uf,
            @QueryParam("minAmostras") @DefaultValue("100") int minAmostras,
            @QueryParam("limit") @DefaultValue("20") int limit) {
        if (uf != null && !uf.isEmpty()) {
            return service.rankingMunicipiosPorAnoPorUf(uf, minAmostras, limit);
        } else {
            return service.rankingMunicipiosPorAnoTO(minAmostras, limit);
        }
    }

    @GET
    @Path("/serie-parametros")
    /**
     * Série temporal de percentual de inconformidade.
     *
     * Query params:
     * - codIbge: código IBGE do município (ex.: 1721000)
     * - parametros: lista de parâmetros (enviar múltiplas vezes na query)
     *
     * Parâmetros permitidos:
     * - Bactérias Heterotróficas (UFC/mL)
     * - Coliformes totais
     * - Cor (uH)
     * - Escherichia coli
     * - Fluoreto (mg/L)
     * - pH
     * - Residual de Desinfetante
     * - Turbidez (uT)
     */
    public List<TimeSeriesParametroDTO> serieTemporalPorMunicipioParametros(
            @QueryParam("codIbge") @DefaultValue("1721000") String codIbge,
            @QueryParam("parametros") List<String> parametros) {
        return service.serieTemporalPorMunicipioParametrosTO(codIbge, parametros);
    }

    /**
     * Qualidade da água por município específico em um ano.
     * GRÁFICO: Pizza/Donut - Distribuição de conformidade/inconformidade
     * INSIGHT: Mostra o status geral da qualidade da água no município
     *
     * Query params:
     * - codIbge: código IBGE do município (ex.: 1721000)
     * - ano: ano de referência (ex.: 2025)
     */
    @GET
    @Path("/qualidade-municipio")
    public QualidadeAguaMunicipioDTO qualidadeAguaPorMunicipio(
            @QueryParam("codIbge") String codIbge,
            @QueryParam("ano") @DefaultValue("2025") Integer ano) {
        return service.qualidadeAguaPorMunicipio(codIbge, ano);
    }

    /**
     * Evolução histórica da qualidade da água por município.
     * GRÁFICO: Linha/Área - Evolução temporal da qualidade
     * INSIGHT: Permite acompanhar tendências de melhoria ou piora na qualidade da água
     *
     * Query params:
     * - codIbge: código IBGE do município (ex.: 1721000)
     */
    @GET
    @Path("/evolucao-qualidade-municipio")
    public List<EvolucaoQualidadeMunicipioDTO> evolucaoQualidadePorMunicipio(
            @QueryParam("codIbge") String codIbge) {
        return service.evolucaoQualidadePorMunicipio(codIbge);
    }

    /**
     * Parâmetros mais críticos por município em um ano.
     * GRÁFICO: Barra/Coluna - Ranking de parâmetros problemáticos
     * INSIGHT: Identifica quais parâmetros específicos estão causando mais inconformidades
     *
     * Query params:
     * - codIbge: código IBGE do município (ex.: 1721000)
     * - ano: ano de referência (ex.: 2025)
     * - limit: número máximo de parâmetros a retornar (padrão: 10)
     */
    @GET
    @Path("/parametros-criticos-municipio")
    public List<ParametrosCriticosMunicipioDTO> parametrosCriticosPorMunicipio(
            @QueryParam("codIbge") String codIbge,
            @QueryParam("ano") @DefaultValue("2025") Integer ano
    ) {
        return service.parametrosCriticosPorMunicipio(codIbge, ano);
    }

    /**
     * Comparação entre municípios por região.
     * GRÁFICO: Barra Horizontal - Ranking comparativo entre municípios
     * INSIGHT: Permite benchmarking entre municípios com características similares
     *
     * Query params:
     * - regiao: região geográfica (ex.: "Norte", "Sul")
     * - ano: ano de referência (ex.: 2025)
     * - minAmostras: mínimo de amostras para considerar (padrão: 100)
     * - limit: número máximo de municípios a retornar (padrão: 20)
     */
    @GET
    @Path("/comparacao-municipios-regiao")
    public List<ComparacaoMunicipiosDTO> comparacaoMunicipiosPorRegiao(
            @QueryParam("regiao") String regiao,
            @QueryParam("ano") @DefaultValue("2025") Integer ano,
            @QueryParam("minAmostras") @DefaultValue("100") int minAmostras,
            @QueryParam("limit") @DefaultValue("20") int limit) {
        return service.comparacaoMunicipiosPorRegiao(regiao, ano, minAmostras, limit);
    }
    
    @GET
    @Path("/resumo-pontos-ano")
    public List<ResumoPontoAmostrasDTO> resumoPontosPorAno(
            @QueryParam("codIbge") String codIbge,
            @QueryParam("ano") @DefaultValue("2025") Integer ano
    ) {
        return service.resumoPorPontoAnoTO(codIbge, ano)
                .stream()
                .map(obj -> (ResumoPontoAmostrasDTO) obj)
                .toList();
    }
}