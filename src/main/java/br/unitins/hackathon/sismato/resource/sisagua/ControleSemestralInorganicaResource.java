package br.unitins.hackathon.sismato.resource.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.dto.sisagua.controlesemestral.ColetaAnualDTO;
import br.unitins.hackathon.sismato.dto.sisagua.controlesemestral.ColetaMensalDTO;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralInorganica;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralInorganicaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/controle/inorganica")
public class ControleSemestralInorganicaResource {

    @Inject
    ControleSemestralInorganicaService controleSemestralInorganicaService;

    @GET
    @Path("/{codMunicipio}")
    public List<ControleSemestralInorganica> findByCodigoMunicipio(
            @PathParam("codMunicipio") Long codMunicipio,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralInorganicaService.findByCodigoMunicipio(codMunicipio, page, pageSize);
    }

    @GET
    public List<ControleSemestralInorganica> findByFiltros(
            @BeanParam FilterBaseControle filtros,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralInorganicaService.findByFiltros(filtros, page, pageSize);
    }

    @GET
    @Path("/anual")
    public ColetaAnualDTO findColetaAnualWithFilter(
            @BeanParam FilterBaseControle filtros,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize
    ) {
        return controleSemestralInorganicaService.findColetaAnualWithFilter(filtros, page, pageSize);
    }

    @GET
    @Path("/mensal")
    public ColetaMensalDTO findColetaMensalWithFilter(
            @BeanParam FilterBaseControle filtros,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize
    ) {
        return controleSemestralInorganicaService.findColetaMensalWithFilter(filtros, page, pageSize);
    }
}