package br.unitins.hackathon.sismato.resource.sisagua;


import br.unitins.hackathon.sismato.service.sisagua.PontoCaptacaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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
}
