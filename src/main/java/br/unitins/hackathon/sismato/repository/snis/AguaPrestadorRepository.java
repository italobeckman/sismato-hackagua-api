package br.unitins.hackathon.sismato.repository.snis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import br.unitins.hackathon.sismato.dto.snis.AtendimentoUrbanoMunicipioDTO;
import br.unitins.hackathon.sismato.dto.snis.DespesasPrestadorDTO;
import br.unitins.hackathon.sismato.dto.snis.EvolucaoAtendimentoMunicipioDTO;
import br.unitins.hackathon.sismato.dto.snis.EvolucaoEsgotoMunicipioDTO;
import br.unitins.hackathon.sismato.dto.snis.ExtensaoRedeUfDTO;
import br.unitins.hackathon.sismato.dto.snis.InvestimentoNaturezaDTO;
import br.unitins.hackathon.sismato.dto.snis.MediasIndicesAnoDTO;
import br.unitins.hackathon.sismato.dto.snis.MunicipioAnoOverviewDTO;
import br.unitins.hackathon.sismato.dto.snis.MunicipioAnoPrestadorDTO;
import br.unitins.hackathon.sismato.dto.snis.PerdasDistribuicaoPrestadorDTO;
import br.unitins.hackathon.sismato.dto.snis.RankingPopulacaoMunicipioDTO;
import br.unitins.hackathon.sismato.dto.snis.ReceitaOperacionalAnoDTO;
import br.unitins.hackathon.sismato.dto.snis.VolumeMedioPrestadorDTO;
import br.unitins.hackathon.sismato.entity.snis.AguaPrestador;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AguaPrestadorRepository implements PanacheRepository<AguaPrestador> {

    public List<AtendimentoUrbanoMunicipioDTO> atendimentoUrbanoMunicipio(int ano, Long idMunicipio) {
        String jpql = "select new br.unitins.hackathon.sismato.dto.snis.AtendimentoUrbanoMunicipioDTO(" +
                "a.siglaUf, a.idMunicipio, " +
                "(case when sum(a.populacaoUrbana) = 0 or sum(a.populacaoUrbana) is null then 0 else (sum(a.populacaoUrbanaAtendidaAgua) * 100.0 / sum(a.populacaoUrbana)) end), " +
                "(case when sum(a.populacaoUrbana) = 0 or sum(a.populacaoUrbana) is null then 0 else (sum(a.populacaoUrbanaAtendidaEsgoto) * 100.0 / sum(a.populacaoUrbana)) end)" +
                ") from AguaPrestador a where a.ano = :ano and a.idMunicipio = :idMunicipio " +
                "group by a.siglaUf, a.idMunicipio";
        return getEntityManager().createQuery(jpql, AtendimentoUrbanoMunicipioDTO.class)
                .setParameter("ano", (long) ano)
                .setParameter("idMunicipio", idMunicipio)
                .getResultList();
    }

    public List<EvolucaoAtendimentoMunicipioDTO> evolucaoAtendimentoMunicipios(Optional<Long> idMunicipioOpt) {
        String base = "select new br.unitins.hackathon.sismato.dto.snis.EvolucaoAtendimentoMunicipioDTO(" +
                "cast(a.ano as integer), a.siglaUf, a.idMunicipio, " +
                "(case when sum(a.populacaoUrbana) = 0 or sum(a.populacaoUrbana) is null then 0 else (sum(a.populacaoUrbanaAtendidaAgua) * 100.0 / sum(a.populacaoUrbana)) end), " +
                "(case when sum(a.populacaoUrbana) = 0 or sum(a.populacaoUrbana) is null then 0 else (sum(a.populacaoUrbanaAtendidaEsgoto) * 100.0 / sum(a.populacaoUrbana)) end)" +
                ") from AguaPrestador a ";
        String where = idMunicipioOpt.isPresent() ? " where a.idMunicipio = :idMunicipio " : "";
        String group = " group by a.ano, a.siglaUf, a.idMunicipio order by a.idMunicipio, a.ano";
        var q = getEntityManager().createQuery(base + where + group, EvolucaoAtendimentoMunicipioDTO.class);
        idMunicipioOpt.ifPresent(id -> q.setParameter("idMunicipio", id));
        return q.getResultList();
    }

    public List<ExtensaoRedeUfDTO> extensaoRedePorUf() {
        String jpql = "select new br.unitins.hackathon.sismato.dto.snis.ExtensaoRedeUfDTO(" +
                "a.siglaUf, sum(a.extensaoRedeAgua), sum(a.extensaoRedeEsgoto)" +
                ") from AguaPrestador a group by a.siglaUf";
        return getEntityManager().createQuery(jpql, ExtensaoRedeUfDTO.class).getResultList();
    }

    public List<RankingPopulacaoMunicipioDTO> rankingPopulacaoAtendidaPorAno(int ano, int limit) {
        String jpql = "select new br.unitins.hackathon.sismato.dto.snis.RankingPopulacaoMunicipioDTO(" +
                "a.idMunicipio, a.prestador, a.populacaoAtendidaAgua" +
                ") from AguaPrestador a where a.ano = :ano order by a.populacaoAtendidaAgua desc";
        var q = getEntityManager().createQuery(jpql, RankingPopulacaoMunicipioDTO.class)
                .setParameter("ano", (long) ano)
                .setMaxResults(limit);
        return q.getResultList();
    }

    public List<VolumeMedioPrestadorDTO> volumeMedioAguaPorPrestador(int ano) {
        String jpql = "select new br.unitins.hackathon.sismato.dto.snis.VolumeMedioPrestadorDTO(" +
                "a.prestador, avg(a.volumeAguaProduzido), avg(a.volumeAguaTratadaEta), avg(a.volumeAguaFaturado)" +
                ") from AguaPrestador a where a.ano = :ano group by a.prestador";
        return getEntityManager().createQuery(jpql, VolumeMedioPrestadorDTO.class)
                .setParameter("ano", (long) ano)
                .getResultList();
    }

    public List<EvolucaoEsgotoMunicipioDTO> evolucaoRelacaoEsgoto(Optional<Long> idMunicipioOpt) {
        String base = "select new br.unitins.hackathon.sismato.dto.snis.EvolucaoEsgotoMunicipioDTO(" +
                "cast(a.ano as integer), a.idMunicipio, sum(a.volumeEsgotoColetado), sum(a.volumeEsgotoTratado), " +
                "(case when sum(a.volumeEsgotoColetado) = 0 or sum(a.volumeEsgotoColetado) is null then 0 else (sum(a.volumeEsgotoTratado) * 100.0 / sum(a.volumeEsgotoColetado)) end)" +
                ") from AguaPrestador a";
        String whereMore = idMunicipioOpt.isPresent() ? " where a.idMunicipio = :idMunicipio " : "";
        String group = " group by a.ano, a.idMunicipio order by a.idMunicipio, a.ano";
        var q = getEntityManager().createQuery(base + whereMore + group, EvolucaoEsgotoMunicipioDTO.class);
        idMunicipioOpt.ifPresent(id -> q.setParameter("idMunicipio", id));
        return q.getResultList();
    }

    public List<MediasIndicesAnoDTO> mediasIndicesPorAno() {
        String jpql = "select new br.unitins.hackathon.sismato.dto.snis.MediasIndicesAnoDTO(" +
                "cast(a.ano as integer), avg(a.indicePerdaFaturamento), avg(a.indiceColetaEsgoto), avg(a.indiceTratamentoEsgoto), avg(a.indiceAtendimentoTotalAgua)" +
                ") from AguaPrestador a group by a.ano order by a.ano";
        return getEntityManager().createQuery(jpql, MediasIndicesAnoDTO.class).getResultList();
    }

    public List<PerdasDistribuicaoPrestadorDTO> perdasDistribuicaoPorPrestador(int ano) {
        String jpql = "select new br.unitins.hackathon.sismato.dto.snis.PerdasDistribuicaoPrestadorDTO(" +
                "a.prestador, avg(a.indicePerdaDistribuicaoAgua)" +
                ") from AguaPrestador a where a.ano = :ano group by a.prestador order by avg(a.indicePerdaDistribuicaoAgua) desc";
        return getEntityManager().createQuery(jpql, PerdasDistribuicaoPrestadorDTO.class)
                .setParameter("ano", (long) ano)
                .getResultList();
    }

    public List<ReceitaOperacionalAnoDTO> receitaOperacionalPorAno() {
        String jpql = "select new br.unitins.hackathon.sismato.dto.snis.ReceitaOperacionalAnoDTO(" +
                "cast(a.ano as integer), sum(a.receitaOperacionalDiretaAgua), sum(a.receitaOperacionalDiretaEsgoto), sum(a.receitaOperacionalDireta)" +
                ") from AguaPrestador a group by a.ano order by a.ano";
        return getEntityManager().createQuery(jpql, ReceitaOperacionalAnoDTO.class).getResultList();
    }

    public List<DespesasPrestadorDTO> despesasPorPrestador(int ano, Optional<String> prestadorOpt) {
        String base = "select new br.unitins.hackathon.sismato.dto.snis.DespesasPrestadorDTO(" +
                "a.prestador, sum(a.despesaPessoal), sum(a.despesaProdutoQuimico), sum(a.despesaEnergia), sum(a.despesaServicoTerceiro)" +
                ") from AguaPrestador a where a.ano = :ano";
        String whereMore = prestadorOpt.isPresent() ? " and a.prestador = :prestador " : "";
        String group = " group by a.prestador";
        var q = getEntityManager().createQuery(base + whereMore + group, DespesasPrestadorDTO.class)
                .setParameter("ano", (long) ano);
        prestadorOpt.ifPresent(p -> q.setParameter("prestador", p));
        return q.getResultList();
    }

    public List<InvestimentoNaturezaDTO> investimentosPorNatureza(int ano) {
        String jpql = "select new br.unitins.hackathon.sismato.dto.snis.InvestimentoNaturezaDTO(" +
                "a.naturezaJuridica, sum(a.investimentoAguaPrestador), sum(a.investimentoEsgotoPrestador)" +
                ") from AguaPrestador a where a.ano = :ano group by a.naturezaJuridica";
        return getEntityManager().createQuery(jpql, InvestimentoNaturezaDTO.class)
                .setParameter("ano", (long) ano)
                .getResultList();
    }

    public List<Integer> anosDisponiveis() {
        String jpql = "select cast(a.ano as integer) from AguaPrestador a group by a.ano order by a.ano";
        return getEntityManager().createQuery(jpql, Integer.class).getResultList();
    }

    public Integer ultimoAnoDisponivel() {
        String jpql = "select cast(max(a.ano) as integer) from AguaPrestador a";
        return getEntityManager().createQuery(jpql, Integer.class).getSingleResult();
    }

    public Long countRegistros() {
        String jpql = "select count(a) from AguaPrestador a";
        return getEntityManager().createQuery(jpql, Long.class).getSingleResult();
    }

    public MunicipioAnoOverviewDTO getOverview(Long idMunicipio, Integer ano) {
        String jpql = "select new br.unitins.hackathon.sismato.dto.snis.MunicipioAnoOverviewDTO(" +
                "a.idMunicipio, a.siglaUf, cast(a.ano as integer), " +
                "sum(a.populacaoUrbana), sum(a.populacaoAtendidaAgua), sum(a.populacaoAtendidaEsgoto), " +
                "sum(a.volumeAguaProduzido), sum(a.volumeEsgotoColetado), " +
                "avg(a.indicePerdaDistribuicaoAgua), sum(a.receitaOperacional), " +
                "sum(a.investimentoAguaPrestador), sum(a.investimentoEsgotoPrestador)" +
                ") from AguaPrestador a where a.idMunicipio = :idMunicipio and a.ano = :ano " +
                "group by a.idMunicipio, a.siglaUf, a.ano";
        return getEntityManager().createQuery(jpql, MunicipioAnoOverviewDTO.class)
                .setParameter("idMunicipio", idMunicipio)
                .setParameter("ano", (long) ano)
                .getSingleResult();
    }

    /**
     * Retorna lista de prestadores com dados para um município e ano específicos
     * GRÁFICO: Barras múltiplas - Comparação de indicadores por prestador
     * INSIGHT: Desempenho individual dos prestadores no município
     */
    public List<MunicipioAnoPrestadorDTO> getPrestadores(Long idMunicipio, Integer ano) {
        String sql = "SELECT a.prestador, a.populacao_atendida_agua, a.volume_agua_produzido, " +
                "a.indice_perda_distribuicao_agua, a.receita_operacional, " +
                "a.investimento_agua_prestador, a.investimento_esgoto_prestador " +
                "FROM esgoto_agua_prestador_snis a " +
                "WHERE a.id_municipio = :idMunicipio AND a.ano = :ano";
        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("idMunicipio", idMunicipio);
        query.setParameter("ano", ano);
        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();
        return rows.stream().map(r -> new MunicipioAnoPrestadorDTO(
                (String) r[0],
                r[1] != null ? ((Number) r[1]).doubleValue() : 0.0,
                r[2] != null ? ((Number) r[2]).doubleValue() : 0.0,
                r[3] != null ? ((Number) r[3]).doubleValue() : 0.0,
                r[4] != null ? ((Number) r[4]).doubleValue() : 0.0,
                r[5] != null ? ((Number) r[5]).doubleValue() : 0.0,
                r[6] != null ? ((Number) r[6]).doubleValue() : 0.0
        )).collect(Collectors.toList());
    }
}