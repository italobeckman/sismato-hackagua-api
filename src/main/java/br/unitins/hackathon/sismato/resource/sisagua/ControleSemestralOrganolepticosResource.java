package br.unitins.hackathon.sismato.resource.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.dto.sisagua.controlesemestral.ColetaAnualDTO;
import br.unitins.hackathon.sismato.dto.sisagua.controlesemestral.ColetaMensalDTO;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOrganolepticos;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralOrganolepticosService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/controle/organolepticos")
public class ControleSemestralOrganolepticosResource {

    @Inject
    ControleSemestralOrganolepticosService controleSemestralOrganolepticosService;

    @GET
    @Path("/{codMunicipio}")
    public List<ControleSemestralOrganolepticos> findByCodigoMunicipio(
            @PathParam("codMunicipio") Long codMunicipio,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralOrganolepticosService.findByCodigoMunicipio(codMunicipio, page, pageSize);
    }

    @GET
    public List<ControleSemestralOrganolepticos> findByFiltros(
            @BeanParam FilterBaseControle filtros,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralOrganolepticosService.findByFiltros(filtros, page, pageSize);
    }

    @GET
    @Path("/anual")
    public ColetaAnualDTO findColetaAnualWithFilter(
            @BeanParam FilterBaseControle filtros,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize
    ) {
        return controleSemestralOrganolepticosService.findColetaAnualWithFilter(filtros, page, pageSize);
    }

    @GET
    @Path("/mensal")
    public ColetaMensalDTO findColetaMensalWithFilter(
            @BeanParam FilterBaseControle filtros,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize
    ) {
        return controleSemestralOrganolepticosService.findColetaMensalWithFilter(filtros, page, pageSize);
    }
}