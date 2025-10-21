package br.unitins.hackathon.sismato.resource;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralInorganica;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralAgrotoxicoService;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralInorganicaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/controle")
public class ControleSemestralResource {

    @Inject
    ControleSemestralAgrotoxicoService controleSemestralAgrotoxicoService;

    @Inject
    ControleSemestralInorganicaService controleSemestralInorganicaService;

    @GET
    @Path("/{sigla}")
    public List<ControleSemestralAgrotoxico> findByNomeInstituicao(@PathParam("sigla") String sigla) {
        return controleSemestralAgrotoxicoService.findBySiglaInsitituicao(sigla);
    }

    @GET
    @Path("/inorganica/{codMunicipio}")
    public List<ControleSemestralInorganica> findByNomeInstituicaoInorganica(
            @PathParam("codMunicipio") Long codMunicipio, @QueryParam("page") 
            @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralInorganicaService.findByCodigoMunicipio(codMunicipio, page, pageSize);
    }
}
