package br.unitins.hackathon.sismato.resource;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralInorganica;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOrganico;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOrganolepticos;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOutros;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralRadioatividade;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralAgrotoxicoService;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralInorganicaService;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralOrganicoService;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralOrganolepticosService;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralOutrosService;
import br.unitins.hackathon.sismato.service.sisagua.ControleSemestralRadioatividadeService;
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

    @Inject
    ControleSemestralOrganicoService controleSemestralOrganicoService;

    @Inject
    ControleSemestralOrganolepticosService controleSemestralOrganolepticosService;

    @Inject
    ControleSemestralOutrosService controleSemestralOutrosService;

    @Inject
    ControleSemestralRadioatividadeService controleSemestralRadioatividadeService;

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

    @GET
    @Path("/organico/{codMunicipio}")
    public List<ControleSemestralOrganico> findByNomeInstituicaoOrganico(
            @PathParam("codMunicipio") Long codMunicipio, @QueryParam("page")
            @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralOrganicoService.findByCodigoMunicipio(codMunicipio, page, pageSize);
    }

    @GET
    @Path("/organolepticos/{codMunicipio}")
    public List<ControleSemestralOrganolepticos> findByNomeInstituicaoOrganolepticos(
            @PathParam("codMunicipio") Long codMunicipio, @QueryParam("page")
            @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralOrganolepticosService.findByCodigoMunicipio(codMunicipio, page, pageSize);
    }

    @GET
    @Path("/outros/{codMunicipio}")
    public List<ControleSemestralOutros> findByNomeInstituicaoOutros(
            @PathParam("codMunicipio") Long codMunicipio, @QueryParam("page")
            @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralOutrosService.findByCodigoMunicipio(codMunicipio, page, pageSize);
    }

    @GET
    @Path("/radioatividade/{codMunicipio}")
    public List<ControleSemestralRadioatividade> findByNomeInstituicaoRadioatividade(
            @PathParam("codMunicipio") Long codMunicipio, @QueryParam("page")
            @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
        return controleSemestralRadioatividadeService.findByCodigoMunicipio(codMunicipio, page, pageSize);
    }
}
