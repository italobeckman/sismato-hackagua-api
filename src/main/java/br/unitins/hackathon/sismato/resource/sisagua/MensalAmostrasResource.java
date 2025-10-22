package br.unitins.hackathon.sismato.resource.sisagua;

import java.util.List;

import br.unitins.hackathon.sismato.dto.sisagua.MensalAmostrasResumoPorAnoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.ParametroCriticoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.RankingMunicipioAnoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.RankingMunicipioDTO;
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
    public List<MensalAmostrasResumoPorAnoDTO> resumoPorAno() {
        return service.resumoPorAnoPorUf("TO");
    }

    // maiores indices de percentualInconformidadeGeral
    @GET
    @Path("/ranking-municipios")
    public List<RankingMunicipioDTO> rankingMunicipios(
            @QueryParam("minAmostras") @DefaultValue("100") int minAmostras,
            @QueryParam("limit") @DefaultValue("20") int limit) {
        return service.rankingMunicipiosGeralTO(minAmostras, limit);
    }

    // percentual inconformidade anual por municipio
    @GET
    @Path("/ranking-municipios-por-ano")
    public List<RankingMunicipioAnoDTO> rankingMunicipiosPorAno(
            @QueryParam("minAmostras") @DefaultValue("100") int minAmostras,
            @QueryParam("limit") @DefaultValue("20") int limit) {
        return service.rankingMunicipiosPorAnoTO(minAmostras, limit);
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

    @GET
    @Path("/top-parametros-ano-anterior")
    public List<ParametroCriticoDTO> topParametrosAnoAnterior(
            @QueryParam("limit") @DefaultValue("10") int limit) {
        return service.topParametrosAnoAnteriorTO(limit);
    }
}