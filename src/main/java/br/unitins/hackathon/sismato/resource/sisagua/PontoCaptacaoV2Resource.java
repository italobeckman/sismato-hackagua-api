package br.unitins.hackathon.sismato.resource.sisagua;

import br.unitins.hackathon.sismato.dto.sisagua.PontoCaptacaoMapaDTO;
import br.unitins.hackathon.sismato.service.sisagua.PontoCaptacaoV2Service;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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
            @QueryParam("pageSize") @DefaultValue("300") int pageSize) {
        return Response.ok(service.findByCodigoMunicipio(codigoMunicipio, page, pageSize).stream().map(PontoCaptacaoMapaDTO::toDto).toList()).build();
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
}