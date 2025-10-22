package br.unitins.hackathon.sismato.resource.sisagua;



import br.unitins.hackathon.sismato.service.sisagua.MensalDetalhadaService;
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
@Path("/api/mensal-detalhadas")
public class MensalDetalhadasResource {

    @Inject
    MensalDetalhadaService service;

    // atenção: cod ibge antigo
    @GET
    public Response getByFilters(
            @QueryParam("codIbge") String codIbge,
            @QueryParam("ano") Integer ano,
            @QueryParam("mesReferencia") String mesReferencia,
            @QueryParam("parametro") String parametro,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return Response.ok(service.findByFilters(codIbge, ano, mesReferencia, parametro, page, pageSize)).build();
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
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        var entity = service.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(entity).build();
    }

}