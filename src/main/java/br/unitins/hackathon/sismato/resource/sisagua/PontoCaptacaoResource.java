package br.unitins.hackathon.sismato.resource.sisagua;

import java.util.List;

import br.unitins.hackathon.sismato.dto.sisagua.EvolucaoVazaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TipoCaptacaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TotalOutorgaDTO;
import br.unitins.hackathon.sismato.service.sisagua.PontoCaptacaoService;
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
@Path("/api/pontos-captacao")
public class PontoCaptacaoResource {

    @Inject
    PontoCaptacaoService pontoCaptacaoService;

    @GET
    @Path("{codigoMunicipio}")
    public Response getPontosCaptacaoByCodigoMunicipio(
            @PathParam("codigoMunicipio") Long codigoMunicipio,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return Response.ok(pontoCaptacaoService.findByCodigoMunicipio(codigoMunicipio, page, pageSize)).build();
    }

    @GET
    @Path("/all")
    public Response getAllPontosCaptacao() {
        return Response.ok(pontoCaptacaoService.findAll()).build();
    }

    /**
     * Evolução histórica das vazões por ano.
     * Retorna a vazão média e quantidade de pontos por ano.
     * 
     * Ideal para gráfico de linha/área no Highcharts:
     * - Eixo X: ano
     * - Eixo Y: vazaoMedia
     * - Série adicional: quantidadePontos
     */
    @GET
    @Path("/evolucao-vazoes")
    public List<EvolucaoVazaoDTO> evolucaoVazoesPorAno() {
        return pontoCaptacaoService.evolucaoVazoesPorAno();
    }

    /**
     * Total de pontos por status de outorga (Sim, Não, Não informado).
     * 
     * Ideal para gráfico de pizza/donut no Highcharts:
     * - name: outorga (Sim/Não/Não informado)
     * - y: total
     */
    @GET
    @Path("/total-outorga")
    public List<TotalOutorgaDTO> totalPorOutorga() {
        return pontoCaptacaoService.totalPorOutorga();
    }

    /**
     * Quantidade de pontos por tipo de captação (Subterrâneo/Superficial).
     * 
     * Ideal para gráfico de coluna/barra no Highcharts:
     * - categories: tipoCaptacao
     * - data: quantidade
     */
    @GET
    @Path("/tipo-captacao")
    public List<TipoCaptacaoDTO> quantidadePorTipoCaptacao() {
        return pontoCaptacaoService.quantidadePorTipoCaptacao();
    }
}
