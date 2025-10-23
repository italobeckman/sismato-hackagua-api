package br.unitins.hackathon.sismato.resource.sisagua;

import java.util.List;

import br.unitins.hackathon.sismato.dto.sisagua.EvolucaoVazaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.PontoCaptacaoMapaDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TipoCaptacaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TotalOutorgaDTO;
import br.unitins.hackathon.sismato.dto.MapaPontosCaptacaoComAmostrasDTO;
import br.unitins.hackathon.sismato.service.sisagua.PontoCaptacaoV2Service;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/pontos-captacao-v2")
public class PontoCaptacaoV2Resource {

    @Inject
    PontoCaptacaoV2Service service;

    @GET
    public Response getByFilters(
            @QueryParam("codigoIbge") Integer codigoIbge,
            @QueryParam("ano") Integer ano,
            @QueryParam("municipio") String municipio,
            @QueryParam("tpCaptacao") String tpCaptacao,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        var items = service.findByFilters(codigoIbge, ano, municipio, tpCaptacao, page, pageSize);
        return Response.ok(items.stream().map(PontoCaptacaoMapaDTO::toDto).toList()).build();
    }

    @GET
    @Path("{codigoMunicipio}")
    public Response getByCodigoMunicipio(
            @PathParam("codigoMunicipio") Integer codigoMunicipio,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("300") int pageSize,
            @QueryParam("ano") @DefaultValue("2025") Integer ano) {
        return Response.ok(service.findByCodigoMunicipio(codigoMunicipio, ano, page, pageSize).stream()
                .map(PontoCaptacaoMapaDTO::toDto).toList()).build();
    }

    @GET
    @Path("/detalhes/{codigoIbge}")
    public Response getDetalhesPorCodigoIbge(@PathParam("codigoIbge") Integer codigoIbge, @QueryParam("ano") @DefaultValue("2025") Integer ano) {
        var detalhes = service.getDetalhesPorCodigoIbge(codigoIbge, ano);
        return Response.ok(detalhes).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(service.count()).build();
    }

    @GET
    @Path("/all")
    public Response getAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("1000") int pageSize) {
        var items = service.findAllPaged(page, pageSize);
        return Response.ok(items)
                .header("X-Total-Count", service.count())
                .build();
    }

    @GET
    @Path("/{id}/detail")
    public Response getById(@PathParam("id") Long id) {
        var entity = service.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(entity).build();
    }

    /**
     * Evolução histórica das vazões por ano e município (opcional).
     * Retorna a vazão média e quantidade de pontos por ano.
     *
     * Query params:
     * - codIbge: código IBGE do município (opcional, ex.: 1721000)
     *
     * Ideal para gráfico de linha/área no Highcharts:
     * - Eixo X: ano
     * - Eixo Y: vazaoMedia
     * - Série adicional: quantidadePontos
     */
    @GET
    @Path("/evolucao-vazoes")
    public List<EvolucaoVazaoDTO> evolucaoVazoesPorAno(
            @QueryParam("codIbge") Integer codIbge) {
        return service.evolucaoVazoesPorAno(codIbge);
    }

    /**
     * Total de pontos por status de outorga (Sim, Não, Não informado) por ano e município (opcional).
     *
     * Query params:
     * - ano: ano de referência (ex.: 2025)
     * - codIbge: código IBGE do município (opcional, ex.: 1721000)
     *
     * Ideal para gráfico de pizza/donut no Highcharts:
     * - name: outorga (Sim/Não/Não informado)
     * - y: total
     */
    @GET
    @Path("/total-outorga")
    public List<TotalOutorgaDTO> totalPorOutorga(
            @QueryParam("ano") @DefaultValue("2025") Integer ano,
            @QueryParam("codIbge") Integer codIbge) {
        return service.totalPorOutorga(ano, codIbge);
    }

    /**
     * Quantidade de pontos por tipo de captação (Subterrâneo/Superficial) por ano e município (opcional).
     *
     * Query params:
     * - ano: ano de referência (ex.: 2025)
     * - codIbge: código IBGE do município (opcional, ex.: 1721000)
     *
     * Ideal para gráfico de coluna/barra no Highcharts:
     * - categories: tipoCaptacao
     * - data: quantidade
     */
    @GET
    @Path("/tipo-captacao")
    public List<TipoCaptacaoDTO> quantidadePorTipoCaptacao(
            @QueryParam("ano") @DefaultValue("2025") Integer ano,
            @QueryParam("codIbge") Integer codIbge) {
        return service.quantidadePorTipoCaptacao(ano, codIbge);
    }

    /**
     * Dados geoespaciais de pontos de captação com informações de qualidade da água.
     * Faz JOIN entre pontos de captação e amostras mensais para fornecer dados integrados.
     *
     * Query params:
     * - codIbge: código IBGE do município (obrigatório, ex.: 1721000)
     * - ano: ano de referência (obrigatório, ex.: 2025)
     *
     * Ideal para mapa interativo no Highcharts:
     * - latitude/longitude: coordenadas geográficas
     * - tooltips ricos: nome do ponto, tipo de captação, vazão, qualidade da água
     * - marcadores coloridos: baseados no percentual de inconformidade
     *
     * INSIGHT: Visualização geográfica integrada que combina infraestrutura
     * com dados de qualidade da água para análise espacial da situação hídrica
     */
    @GET
    @Path("/mapa-com-amostras")
    public List<MapaPontosCaptacaoComAmostrasDTO> mapaPontosComAmostras(
            @QueryParam("codIbge") Integer codIbge,
            @QueryParam("ano") Integer ano) {
        return service.mapaPontosComAmostras(codIbge, ano);
    }
}