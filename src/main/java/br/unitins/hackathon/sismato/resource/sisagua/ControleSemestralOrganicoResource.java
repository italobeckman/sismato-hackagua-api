package br.unitins.hackathon.sismato.resource.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOrganico;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralOrganicoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/controle/organico")
public class ControleSemestralOrganicoResource {

    @Inject
    ControleSemestralOrganicoService controleSemestralOrganicoService;

    @GET
    @Path("/{codMunicipio}")
    public List<ControleSemestralOrganico> findByCodigoMunicipio(
            @PathParam("codMunicipio") Long codMunicipio,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralOrganicoService.findByCodigoMunicipio(codMunicipio, page, pageSize);
    }

    @GET
    public List<ControleSemestralOrganico> findByFiltros(
            @BeanParam FilterBaseControle filtros,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralOrganicoService.findByFiltros(filtros, page, pageSize);
    }
}
