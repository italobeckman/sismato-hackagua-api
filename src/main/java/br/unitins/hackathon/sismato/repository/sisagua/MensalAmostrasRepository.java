package br.unitins.hackathon.sismato.repository.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.MensalAmostras;
import br.unitins.hackathon.sismato.dto.sisagua.ComparacaoMunicipiosDTO;
import br.unitins.hackathon.sismato.dto.sisagua.EvolucaoQualidadeMunicipioDTO;
import br.unitins.hackathon.sismato.dto.sisagua.MensalAmostrasResumoPorAnoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.ParametrosCriticosMunicipioDTO;
import br.unitins.hackathon.sismato.dto.sisagua.QualidadeAguaMunicipioDTO;
import br.unitins.hackathon.sismato.dto.sisagua.RankingMunicipioAnoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.RankingMunicipioDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TimeSeriesParametroDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class MensalAmostrasRepository implements PanacheRepository<MensalAmostras> {

    public PanacheQuery<MensalAmostras> findByMunicipio(String municipio) {
        return find("municipio", municipio);
    }

    public PanacheQuery<MensalAmostras> findByAno(Integer ano) {
        return find("ano", ano);
    }

    public PanacheQuery<MensalAmostras> findByMesReferencia(String mesReferencia) {
        return find("mesReferencia", mesReferencia);
    }

    public PanacheQuery<MensalAmostras> findByParametro(String parametro) {
        return find("parametro", parametro);
    }

    public PanacheQuery<MensalAmostras> findByFilters(String municipio, Integer ano, String mesReferencia, String parametro) {
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        if (municipio != null && !municipio.isBlank()) {
            query.append("municipio = :municipio");
            params.put("municipio", municipio);
        }
        if (ano != null) {
            if (query.length() > 0) query.append(" and ");
            query.append("ano = :ano");
            params.put("ano", ano);
        }
        if (mesReferencia != null && !mesReferencia.isBlank()) {
            if (query.length() > 0) query.append(" and ");
            query.append("mesReferencia = :mesReferencia");
            params.put("mesReferencia", mesReferencia);
        }
        if (parametro != null && !parametro.isBlank()) {
            if (query.length() > 0) query.append(" and ");
            query.append("parametro = :parametro");
            params.put("parametro", parametro);
        }

        if (query.length() == 0) {
            return findAll();
        }

        return find(query.toString(), params);
    }

    public List<MensalAmostrasResumoPorAnoDTO> resumoPorAnoPorUf(String uf) {
        String jpql = "select new br.unitins.hackathon.sismato.dto.sisagua.MensalAmostrasResumoPorAnoDTO(" +
                "m.ano, sum(m.numAmostrasAnalisadas), sum(m.numAmostrasForaDoPadrao), " +
                "case when sum(m.numAmostrasAnalisadas) > 0 then (sum(m.numAmostrasForaDoPadrao) * 100.0 / sum(m.numAmostrasAnalisadas)) else 0 end" +
                ") from MensalAmostras m " +
                "where m.uf = :uf and m.ano is not null " +
                "group by m.ano " +
                "order by m.ano desc";
        return getEntityManager()
                .createQuery(jpql, MensalAmostrasResumoPorAnoDTO.class)
                .setParameter("uf", uf)
                .getResultList();
    }

    public List<RankingMunicipioDTO> rankingMunicipiosGeralTO(int minAmostras, int limit) {
        String sql = "SELECT municipio, cod_mun_ibge, " +
                "SUM(num_amostras_analisadas) AS total_amostras_analisadas, " +
                "SUM(num_amostras_fora_do_padrao) AS total_amostras_inconformes, " +
                "CASE WHEN SUM(num_amostras_analisadas) > 0 THEN " +
                "(SUM(num_amostras_fora_do_padrao) * 100.0 / SUM(num_amostras_analisadas)) ELSE 0 END AS percentual_inconformidade_geral " +
                "FROM public.mensal_amostras_sisagua " +
                "WHERE uf = 'TO' AND ano IS NOT NULL AND mes_referencia IS NOT NULL " +
                "GROUP BY municipio, cod_mun_ibge " +
                "HAVING SUM(num_amostras_analisadas) > :min " +
                "ORDER BY percentual_inconformidade_geral DESC";
        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("min", minAmostras);
        query.setMaxResults(limit);
        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();
        return rows.stream().map(r -> new RankingMunicipioDTO(
                (String) r[0],
                r[1] != null ? r[1].toString() : null,
                ((Number) r[2]).longValue(),
                ((Number) r[3]).longValue(),
                ((Number) r[4]).doubleValue()
        )).collect(Collectors.toList());
    }

    public List<RankingMunicipioAnoDTO> rankingMunicipiosPorAnoTO(int minAmostras, int limit) {
        String sql = "SELECT ano, municipio, cod_mun_ibge, " +
                "SUM(num_amostras_analisadas) AS total_amostras_analisadas, " +
                "SUM(num_amostras_fora_do_padrao) AS total_amostras_inconformes, " +
                "CASE WHEN SUM(num_amostras_analisadas) > 0 THEN " +
                "(SUM(num_amostras_fora_do_padrao) * 100.0 / SUM(num_amostras_analisadas)) ELSE 0 END AS percentual_inconformidade_anual " +
                "FROM public.mensal_amostras_sisagua " +
                "WHERE uf = 'TO' AND ano IS NOT NULL AND mes_referencia IS NOT NULL " +
                "GROUP BY ano, municipio, cod_mun_ibge " +
                "HAVING SUM(num_amostras_analisadas) > :min " +
                "ORDER BY percentual_inconformidade_anual DESC";
        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("min", minAmostras);
        query.setMaxResults(limit);
        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();
        return rows.stream().map(r -> new RankingMunicipioAnoDTO(
                ((Number) r[0]).intValue(),
                (String) r[1],
                r[2] != null ? r[2].toString() : null,
                ((Number) r[3]).longValue(),
                ((Number) r[4]).longValue(),
                ((Number) r[5]).doubleValue()
        )).collect(Collectors.toList());
    }

    public List<TimeSeriesParametroDTO> serieTemporalPorMunicipioParametrosTO(String codIbge, List<String> parametros) {
        if (parametros == null || parametros.isEmpty()) {
            return List.of();
        }
        StringBuilder inClause = new StringBuilder();
        for (int i = 0; i < parametros.size(); i++) {
            if (i > 0) inClause.append(", ");
            inClause.append(":p" + i);
        }
        String sql = "SELECT " +
                "make_date(ano, CASE " +
                "WHEN lower(mes_referencia) = 'jan' THEN 1 WHEN lower(mes_referencia) = 'fev' THEN 2 " +
                "WHEN lower(mes_referencia) = 'mar' THEN 3 WHEN lower(mes_referencia) = 'abr' THEN 4 " +
                "WHEN lower(mes_referencia) = 'mai' THEN 5 WHEN lower(mes_referencia) = 'jun' THEN 6 " +
                "WHEN lower(mes_referencia) = 'jul' THEN 7 WHEN lower(mes_referencia) = 'ago' THEN 8 " +
                "WHEN lower(mes_referencia) = 'set' THEN 9 WHEN lower(mes_referencia) = 'out' THEN 10 " +
                "WHEN lower(mes_referencia) = 'nov' THEN 11 WHEN lower(mes_referencia) = 'dez' THEN 12 END, 1) AS data_analise, " +
                "parametro, " +
                "CASE WHEN SUM(num_amostras_analisadas) > 0 THEN ROUND((SUM(num_amostras_fora_do_padrao)::numeric * 100) / SUM(num_amostras_analisadas), 2) ELSE 0 END AS percentual_inconformidade " +
                "FROM public.mensal_amostras_sisagua " +
                "WHERE uf = 'TO' AND ano IS NOT NULL AND mes_referencia IS NOT NULL AND cod_mun_ibge = :codIbge AND parametro IN (" + inClause + ") " +
                "GROUP BY data_analise, parametro " +
                "ORDER BY data_analise ASC, parametro";
        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("codIbge", codIbge);
        for (int i = 0; i < parametros.size(); i++) {
            query.setParameter("p" + i, parametros.get(i));
        }
        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();
        return rows.stream().map(r -> {
            Object d0 = r[0];
            LocalDate data;
            if (d0 instanceof LocalDate) {
                data = (LocalDate) d0;
            } else if (d0 instanceof Date) {
                data = ((Date) d0).toLocalDate();
            } else if (d0 instanceof java.sql.Timestamp) {
                data = ((java.sql.Timestamp) d0).toLocalDateTime().toLocalDate();
            } else {
                throw new IllegalStateException("Tipo de data inesperado: " + (d0 != null ? d0.getClass() : "null"));
            }
            String param = (String) r[1];
            Double perc = ((Number) r[2]).doubleValue();
            return new TimeSeriesParametroDTO(data, param, perc);
        }).collect(Collectors.toList());
    }

    /**
     * Retorna a qualidade da água por município específico em um ano
     * GRÁFICO: Pizza/Donut - Distribuição de conformidade/inconformidade
     * INSIGHT: Mostra o status geral da qualidade da água no município
     */
    public QualidadeAguaMunicipioDTO qualidadeAguaPorMunicipio(String codIbge, Integer ano) {
        String sql = "SELECT municipio, cod_mun_ibge, " +
                "SUM(num_amostras_analisadas) AS total_amostras, " +
                "SUM(num_amostras_fora_do_padrao) AS amostras_inconformes, " +
                "CASE WHEN SUM(num_amostras_analisadas) > 0 THEN " +
                "ROUND((SUM(num_amostras_fora_do_padrao) * 100.0 / SUM(num_amostras_analisadas)), 2) ELSE 0 END AS percentual_inconformidade, " +
                "ano " +
                "FROM public.mensal_amostras_sisagua " +
                "WHERE uf = 'TO' AND cod_mun_ibge = :codIbge AND ano = :ano " +
                "GROUP BY municipio, cod_mun_ibge, ano";

        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("codIbge", codIbge);
        query.setParameter("ano", ano);

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        if (rows.isEmpty()) {
            return null;
        }

        Object[] r = rows.get(0);
        return new QualidadeAguaMunicipioDTO(
                (String) r[0],
                r[1] != null ? r[1].toString() : null,
                ((Number) r[2]).longValue(),
                ((Number) r[3]).longValue(),
                ((Number) r[4]).doubleValue(),
                ((Number) r[5]).intValue()
        );
    }

    /**
     * Retorna a evolução histórica da qualidade da água por município
     * GRÁFICO: Linha/Área - Evolução temporal da qualidade
     * INSIGHT: Permite acompanhar tendências de melhoria ou piora na qualidade da água
     */
    public List<EvolucaoQualidadeMunicipioDTO> evolucaoQualidadePorMunicipio(String codIbge) {
        String sql = "SELECT ano, municipio, cod_mun_ibge, " +
                "SUM(num_amostras_analisadas) AS total_amostras, " +
                "SUM(num_amostras_fora_do_padrao) AS amostras_inconformes, " +
                "CASE WHEN SUM(num_amostras_analisadas) > 0 THEN " +
                "ROUND((SUM(num_amostras_fora_do_padrao) * 100.0 / SUM(num_amostras_analisadas)), 2) ELSE 0 END AS percentual_inconformidade " +
                "FROM public.mensal_amostras_sisagua " +
                "WHERE uf = 'TO' AND cod_mun_ibge = :codIbge AND ano IS NOT NULL " +
                "GROUP BY ano, municipio, cod_mun_ibge " +
                "ORDER BY ano ASC";

        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("codIbge", codIbge);

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        return rows.stream().map(r -> new EvolucaoQualidadeMunicipioDTO(
                ((Number) r[0]).intValue(),
                (String) r[1],
                r[2] != null ? r[2].toString() : null,
                ((Number) r[3]).longValue(),
                ((Number) r[4]).longValue(),
                ((Number) r[5]).doubleValue()
        )).collect(Collectors.toList());
    }

  /**
     * Retorna os parâmetros mais críticos por município em um ano
     * GRÁFICO: Barra/Coluna - Ranking de parâmetros problemáticos
     * INSIGHT: Identifica quais parâmetros específicos estão causando mais inconformidades
     */
    public List<ParametrosCriticosMunicipioDTO> parametrosCriticosPorMunicipio(String codIbge, Integer ano) {
        String sql = "SELECT parametro, " +
                "SUM(num_amostras_fora_do_padrao) AS amostras_inconformes, " +
                "SUM(num_amostras_analisadas) AS total_amostras, " +
                "CASE WHEN SUM(num_amostras_analisadas) > 0 THEN " +
                "ROUND((SUM(num_amostras_fora_do_padrao) * 100.0 / SUM(num_amostras_analisadas)), 2) ELSE 0 END AS percentual_inconformidade, " +
                "municipio, cod_mun_ibge " +
                "FROM public.mensal_amostras_sisagua " +
                "WHERE uf = 'TO' AND cod_mun_ibge = :codIbge AND ano = :ano AND num_amostras_analisadas > 0 " +
                "GROUP BY parametro, municipio, cod_mun_ibge " +
                "ORDER BY percentual_inconformidade DESC, amostras_inconformes DESC";

        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("codIbge", codIbge);
        query.setParameter("ano", ano);

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        // ----- CORREÇÃO AQUI -----
        return rows.stream().map(r -> new ParametrosCriticosMunicipioDTO(
                (String) r[0],                     // parametro
                ((Number) r[1]).longValue(),       // amostrasInconformes
                ((Number) r[2]).longValue(),       // totalAmostras
                ((Number) r[3]).doubleValue(),     // percentualInconformidade 
                (String) r[4],                     // municipio
                r[5] != null ? r[5].toString() : null // codIbge
        )).collect(Collectors.toList());
    }

    /**
     * Retorna comparação entre municípios similares (mesma região/população)
     * GRÁFICO: Barra Horizontal - Ranking comparativo entre municípios
     * INSIGHT: Permite benchmarking entre municípios com características similares
     */
    public List<ComparacaoMunicipiosDTO> comparacaoMunicipiosPorRegiao(String regiao, Integer ano, int minAmostras, int limit) {
        String sql = "SELECT municipio, cod_mun_ibge, " +
                "CASE WHEN SUM(num_amostras_analisadas) > 0 THEN " +
                "ROUND((SUM(num_amostras_fora_do_padrao) * 100.0 / SUM(num_amostras_analisadas)), 2) ELSE 0 END AS percentual_inconformidade, " +
                "SUM(num_amostras_analisadas) AS total_amostras, " +
                "ROW_NUMBER() OVER (ORDER BY CASE WHEN SUM(num_amostras_analisadas) > 0 THEN " +
                "(SUM(num_amostras_fora_do_padrao) * 100.0 / SUM(num_amostras_analisadas)) ELSE 0 END DESC) AS ranking " +
                "FROM public.mensal_amostras_sisagua " +
                "WHERE uf = 'TO' AND ano = :ano AND regiao = :regiao " +
                "GROUP BY municipio, cod_mun_ibge " +
                "HAVING SUM(num_amostras_analisadas) >= :minAmostras " +
                "ORDER BY percentual_inconformidade DESC";

        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("regiao", regiao);
        query.setParameter("ano", ano);
        query.setParameter("minAmostras", minAmostras);
        query.setMaxResults(limit);

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        return rows.stream().map(r -> new ComparacaoMunicipiosDTO(
                (String) r[0],
                r[1] != null ? r[1].toString() : null,
                ((Number) r[2]).doubleValue(),
                ((Number) r[3]).longValue(),
                ((Number) r[4]).intValue()
        )).collect(Collectors.toList());
    }
}