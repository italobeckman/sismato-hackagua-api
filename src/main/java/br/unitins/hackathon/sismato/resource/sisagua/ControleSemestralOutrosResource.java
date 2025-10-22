package br.unitins.hackathon.sismato.resource.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOutros;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralOutrosService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/controle/outros")
public class ControleSemestralOutrosResource {

    @Inject
    ControleSemestralOutrosService controleSemestralOutrosService;

    @GET
    @Path("/{codMunicipio}")
    public List<ControleSemestralOutros> findByCodigoMunicipio(
            @PathParam("codMunicipio") Long codMunicipio,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralOutrosService.findByCodigoMunicipio(codMunicipio, page, pageSize);
    }

    @GET
    public List<ControleSemestralOutros> findByFiltros(
            @BeanParam FilterBaseControle filtros,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralOutrosService.findByFiltros(filtros, page, pageSize);
    }
}
