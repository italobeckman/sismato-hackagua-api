package br.unitins.hackathon.sismato.resource;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.service.ControleSemestralAgrotoxicoService;
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

    @GET
    @Path("/{sigla}")
    public List<ControleSemestralAgrotoxico> findByNomeInstituicao(@PathParam("sigla") String sigla) {
        return controleSemestralAgrotoxicoService.findBySiglaInsitituicao(sigla);
    }
}
