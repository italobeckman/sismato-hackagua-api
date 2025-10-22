package br.unitins.hackathon.sismato.resource.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralAgrotoxicoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/controle/agrotoxico")
public class ControleSemestralAgrotoxicoResource {

    @Inject
    ControleSemestralAgrotoxicoService controleSemestralAgrotoxicoService;

    @GET
    @Path("/{codMunicipio}")
    public List<ControleSemestralAgrotoxico> findByCodigoMunicipio(
            @PathParam("codMunicipio") Long codMunicipio,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralAgrotoxicoService.findByCodigoMunicipio(codMunicipio, page, pageSize);
    }

    @GET
    public List<ControleSemestralAgrotoxico> findByFiltros(
            @BeanParam FilterBaseControle filtros,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralAgrotoxicoService.findByFiltros(filtros, page, pageSize);
    }
}
