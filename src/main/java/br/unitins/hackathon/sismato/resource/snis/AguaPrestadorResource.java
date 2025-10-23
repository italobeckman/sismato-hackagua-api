package br.unitins.hackathon.sismato.resource.snis;

import br.unitins.hackathon.sismato.dto.snis.*;
import br.unitins.hackathon.sismato.service.snis.AguaPrestadorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/snis/agua-prestador")
@Produces(MediaType.APPLICATION_JSON)
public class AguaPrestadorResource {

    @Inject
    AguaPrestadorService service;

    @GET
    @Path("/anos")
    public List<Integer> anosDisponiveis() {
        return service.anosDisponiveis();
    }

    @GET
    @Path("/count")
    public Long count() {
        return service.countRegistros();
    }

    // Analisando um ano específico para um município
    @GET
    @Path("/atendimento-urbano")
    public List<AtendimentoUrbanoMunicipioDTO> atendimentoUrbano(
            @QueryParam("ano") Integer ano,
            @QueryParam("idMunicipio") Long idMunicipio
    ) {
        if (idMunicipio == null) return List.of();
        return service.atendimentoUrbanoMunicipio(ano != null ? ano : service.anosDisponiveis().stream().mapToInt(Integer::intValue).max().orElse(0), idMunicipio);
    }

    // Evolução do atendimento por município ao longo dos anos (opcional filtrar por município)
    @GET
    @Path("/evolucao-atendimento")
    public List<EvolucaoAtendimentoMunicipioDTO> evolucaoAtendimento(
            @QueryParam("idMunicipio") Long idMunicipio
    ) {
        return service.evolucaoAtendimentoMunicipios(idMunicipio);
    }

    // Extensão de rede por UF
    @GET
    @Path("/extensao-rede-uf")
    public List<ExtensaoRedeUfDTO> extensaoRedeUf() {
        return service.extensaoRedePorUf();
    }

    // Ranking de população atendida por prestador em um ano
    @GET
    @Path("/ranking-populacao")
    public List<RankingPopulacaoMunicipioDTO> rankingPopulacao(
            @QueryParam("ano") Integer ano,
            @QueryParam("limit") Integer limit
    ) {
        int lim = limit != null ? limit : 10;
        return service.rankingPopulacaoAtendidaPorAno(ano, lim);
    }

    // Volume médio de água por prestador em um ano
    @GET
    @Path("/volume-medio-prestador")
    public List<VolumeMedioPrestadorDTO> volumeMedioPrestador(
            @QueryParam("ano") Integer ano
    ) {
        return service.volumeMedioAguaPorPrestador(ano);
    }

    // Evolução da relação de esgoto (coletado vs tratado), opcional município
    @GET
    @Path("/evolucao-esgoto")
    public List<EvolucaoEsgotoMunicipioDTO> evolucaoEsgoto(
            @QueryParam("idMunicipio") Long idMunicipio
    ) {
        return service.evolucaoRelacaoEsgoto(idMunicipio);
    }

    // Médias de índices por ano
    @GET
    @Path("/medias-indices-ano")
    public List<MediasIndicesAnoDTO> mediasIndicesAno() {
        return service.mediasIndicesPorAno();
    }

    // Comparativo de índice de perdas entre prestadores (ano específico)
    @GET
    @Path("/perdas-distribuicao")
    public List<PerdasDistribuicaoPrestadorDTO> perdasDistribuicao(
            @QueryParam("ano") Integer ano
    ) {
        return service.perdasDistribuicaoPorPrestador(ano);
    }

    // Receita operacional por ano
    @GET
    @Path("/receita-operacional-ano")
    public List<ReceitaOperacionalAnoDTO> receitaOperacionalAno() {
        return service.receitaOperacionalPorAno();
    }

    // Despesas por prestador (ano com opcional filtro de prestador)
    @GET
    @Path("/despesas-prestador")
    public List<DespesasPrestadorDTO> despesasPrestador(
            @QueryParam("ano") Integer ano,
            @QueryParam("prestador") String prestador
    ) {
        return service.despesasPorPrestador(ano, prestador);
    }

    // Investimentos por natureza jurídica
    @GET
    @Path("/investimentos-natureza")
    public List<InvestimentoNaturezaDTO> investimentosNatureza(
            @QueryParam("ano") Integer ano
    ) {
        return service.investimentosPorNatureza(ano);
    }

    @GET
    @Path("/municipio-ano/overview")
    public MunicipioAnoOverviewDTO overview(@QueryParam("ano") Integer ano, @QueryParam("idMunicipio") Long idMunicipio) {
        if (idMunicipio == null) throw new BadRequestException("idMunicipio é obrigatório");
        return service.getOverview(idMunicipio, ano);
    }

    @GET
    @Path("/prestadores")
    public List<MunicipioAnoPrestadorDTO> prestadores(@QueryParam("ano") Integer ano, @QueryParam("idMunicipio") Long idMunicipio) {
        if (idMunicipio == null) throw new BadRequestException("idMunicipio é obrigatório");
        return service.getPrestadores(idMunicipio, ano);
    }

    @GET
    @Path("/municipio-ano/grafico")
    public MunicipioAnoGraficoDTO grafico(@QueryParam("ano") Integer ano, @QueryParam("idMunicipio") Long idMunicipio) {
        if (idMunicipio == null) throw new BadRequestException("idMunicipio é obrigatório");
        return service.getGrafico(idMunicipio, ano);
    }
}