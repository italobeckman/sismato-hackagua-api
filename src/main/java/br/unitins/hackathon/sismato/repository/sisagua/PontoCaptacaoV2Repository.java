package br.unitins.hackathon.sismato.repository.sisagua;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.unitins.hackathon.sismato.dto.sisagua.EvolucaoVazaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.PontoCaptacaoDetalhesDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TipoCaptacaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TotalOutorgaDTO;
import br.unitins.hackathon.sismato.dto.MapaPontosCaptacaoComAmostrasDTO;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacaoV2;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PontoCaptacaoV2Repository implements PanacheRepository<PontoCaptacaoV2> {

    public PanacheQuery<PontoCaptacaoV2> findByMunicipioCodigo(Integer codigoIbge, Integer ano) {
        return find("codigoIbge = :codigoIbge and ano = :ano", Map.of("codigoIbge", codigoIbge, "ano", ano));
    }

    public PanacheQuery<PontoCaptacaoV2> findByMunicipioNome(String municipio) {
        return find("municipio", municipio);
    }

    public PanacheQuery<PontoCaptacaoV2> findByAno(Integer ano) {
        return find("ano", ano);
    }

    public PanacheQuery<PontoCaptacaoV2> findByFilters(Integer codigoIbge, Integer ano, String municipio, String tpCaptacao) {
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        if (codigoIbge != null) {
            query.append("codigoIbge = :codigoIbge");
            params.put("codigoIbge", codigoIbge);
        }
        if (ano != null) {
            if (query.length() > 0) query.append(" and ");
            query.append("ano = :ano");
            params.put("ano", ano);
        }
        if (municipio != null && !municipio.isBlank()) {
            if (query.length() > 0) query.append(" and ");
            query.append("municipio = :municipio");
            params.put("municipio", municipio);
        }
        if (tpCaptacao != null && !tpCaptacao.isBlank()) {
            if (query.length() > 0) query.append(" and ");
            query.append("tipoCaptacao = :tipoCaptacao");
            params.put("tipoCaptacao", tpCaptacao);
        }

        if (query.length() == 0) {
            return findAll();
        }

        return find(query.toString(), params);
    }

    public PontoCaptacaoDetalhesDTO getDetalhesPorCodigoIbge(Integer codigoIbge, Integer ano) {
        return getEntityManager().createQuery(
            "SELECT NEW br.unitins.hackathon.sismato.dto.sisagua.PontoCaptacaoDetalhesDTO(" +
            "    COUNT(p), " +
            "    COALESCE(SUM(p.nuVazaoCaptada), 0), " +
            "    COALESCE(SUM(CASE WHEN p.tipoCaptacao = 'SUPERFICIAL' THEN 1 ELSE 0 END), 0), " +
            "    COALESCE(SUM(CASE WHEN p.tipoCaptacao = 'SUBTERRANEO' THEN 1 ELSE 0 END), 0), " +
            "    COALESCE(SUM(CASE WHEN p.stOutorga = 'S' THEN 1 ELSE 0 END), 0), " +
            "    COALESCE(SUM(CASE WHEN p.stOutorga = 'N' THEN 1 ELSE 0 END), 0), " +
            "    COALESCE(SUM(CASE WHEN p.stOutorga IS NULL OR p.stOutorga NOT IN ('S', 'N') THEN 1 ELSE 0 END), 0) " +
            ") " +
            "FROM PontoCaptacaoV2 p " +
            "WHERE p.codigoIbge = :codigoIbge and p.ano = :ano", PontoCaptacaoDetalhesDTO.class)
        .setParameter("codigoIbge", codigoIbge)
        .setParameter("ano", ano)
        .getSingleResult();
    }

    /**
     * Retorna a evolução histórica das vazões por ano e município (opcional)
     */
    public List<EvolucaoVazaoDTO> evolucaoVazoesPorAno(Integer codigoIbge) {
        StringBuilder sql = new StringBuilder("SELECT nu_ano, " +
                "AVG(nu_vazao_captada) AS vazao_media, " +
                "COUNT(*) AS quantidade_pontos " +
                "FROM public.pontos_de_captacao_sisagua_v2 " +
                "WHERE sg_uf = 'TO' AND nu_ano IS NOT NULL AND nu_vazao_captada IS NOT NULL");

        if (codigoIbge != null) {
            sql.append(" AND co_municipio_ibge = :codigoIbge");
        }

        sql.append(" GROUP BY nu_ano " +
                "ORDER BY nu_ano ASC");

        var query = getEntityManager().createNativeQuery(sql.toString());

        if (codigoIbge != null) {
            query.setParameter("codigoIbge", codigoIbge);
        }

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        return rows.stream().map(r -> new EvolucaoVazaoDTO(
                ((Number) r[0]).intValue(),
                (java.math.BigDecimal) r[1],
                ((Number) r[2]).longValue()
        )).collect(Collectors.toList());
    }

    /**
     * Retorna o total de pontos com outorga SIM ou NÃO por ano e município (opcional)
     */
    public List<TotalOutorgaDTO> totalPorOutorga(Integer ano, Integer codigoIbge) {
        StringBuilder sql = new StringBuilder("SELECT " +
                "CASE WHEN st_outorga = 'S' THEN 'Sim' " +
                "WHEN st_outorga = 'N' THEN 'Não' " +
                "ELSE 'Não informado' END AS status_outorga, " +
                "COUNT(*) AS total " +
                "FROM public.pontos_de_captacao_sisagua_v2 " +
                "WHERE sg_uf = 'TO' AND nu_ano = :ano");

        if (codigoIbge != null) {
            sql.append(" AND co_municipio_ibge = :codigoIbge");
        }

        sql.append(" GROUP BY CASE WHEN st_outorga = 'S' THEN 'Sim' " +
                "WHEN st_outorga = 'N' THEN 'Não' " +
                "ELSE 'Não informado' END " +
                "ORDER BY total DESC");

        var query = getEntityManager().createNativeQuery(sql.toString());
        query.setParameter("ano", ano);

        if (codigoIbge != null) {
            query.setParameter("codigoIbge", codigoIbge);
        }

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        return rows.stream().map(r -> new TotalOutorgaDTO(
                (String) r[0],
                ((Number) r[1]).longValue()
        )).collect(Collectors.toList());
    }

    /**
     * Retorna a quantidade de pontos por tipo de captação (Subterrâneo/Superficial) por ano e município (opcional)
     */
    public List<TipoCaptacaoDTO> quantidadePorTipoCaptacao(Integer ano, Integer codigoIbge) {
        StringBuilder sql = new StringBuilder("SELECT tp_captacao, COUNT(*) AS quantidade " +
                "FROM public.pontos_de_captacao_sisagua_v2 " +
                "WHERE sg_uf = 'TO' AND nu_ano = :ano AND tp_captacao IS NOT NULL");

        if (codigoIbge != null) {
            sql.append(" AND co_municipio_ibge = :codigoIbge");
        }

        sql.append(" GROUP BY tp_captacao " +
                "ORDER BY quantidade DESC");

        var query = getEntityManager().createNativeQuery(sql.toString());
        query.setParameter("ano", ano);

        if (codigoIbge != null) {
            query.setParameter("codigoIbge", codigoIbge);
        }

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        return rows.stream().map(r -> new TipoCaptacaoDTO(
                (String) r[0],
                ((Number) r[1]).longValue()
        )).collect(Collectors.toList());
    }

    /**
     * Retorna dados geoespaciais de pontos de captação com informações de amostras mensais
     * Faz JOIN entre pontos_de_captacao_sisagua_v2 e mensal_amostras_sisagua
     * GRÁFICO: Mapa com marcadores - Pontos de captação com tooltips ricos de qualidade da água
     * INSIGHT: Visualização geográfica integrada de infraestrutura e qualidade da água
     */
    /**
     * Consulta detalhada e filtrada para o mapa de pontos com amostras.
     * Parâmetros opcionais permitem filtrar por tipo de captação, status de outorga,
     * faixa de vazão e faixa de percentual de inconformidade.
     * Otimizado com CTE para permitir filtragem sobre campo calculado.
     */
    public List<MapaPontosCaptacaoComAmostrasDTO> mapaPontosComAmostrasFiltrado(
            Integer codIbge,
            Integer ano,
            String tipoCaptacao,
            String statusOutorga,
            Double minVazao,
            Double maxVazao,
            Double minInconformidade,
            Double maxInconformidade
    ) {
        String sql = """
            WITH amostras_por_ponto AS (
                SELECT
                    ma.cod_mun_ibge::integer AS codigo_ibge,
                    ma.ano,
                    ma.codigo_nome_saa_sac AS codigo_ponto,
                    SUM(ma.num_amostras_analisadas) AS total_amostras,
                    SUM(ma.num_amostras_fora_do_padrao) AS amostras_inconformes
                FROM mensal_amostras_sisagua ma
                GROUP BY ma.cod_mun_ibge, ma.ano, ma.codigo_nome_saa_sac
            ),
            dados AS (
                SELECT
                    COALESCE(pc.nu_solucao_abastecimento, '') as codigo_ponto,
                    COALESCE(pc.no_ponto_captacao, '') as nome_ponto,
                    CAST(NULLIF(pc.nu_latitude, '') AS DECIMAL) as latitude,
                    CAST(NULLIF(pc.nu_longitude, '') AS DECIMAL) as longitude,
                    COALESCE(pc.tp_captacao, '') as tipo_captacao,
                    COALESCE(pc.st_outorga, '') as status_outorga,
                    COALESCE(pc.no_instituicao, '') as nome_instituicao,
                    COALESCE(pc.no_eta, '') as nome_eta,
                    pc.nu_vazao_captada as vazao_captada,
                    COALESCE(ap.total_amostras, 0) as total_amostras,
                    COALESCE(ap.amostras_inconformes, 0) as amostras_inconformes,
                    CASE
                        WHEN COALESCE(ap.total_amostras, 0) > 0
                        THEN ROUND((ap.amostras_inconformes * 100.0 / ap.total_amostras), 2)
                        ELSE NULL
                    END as percentual_inconformidade,
                    COALESCE(pc.no_municipio, '') as municipio,
                    pc.co_municipio_ibge as codigo_ibge,
                    pc.nu_ano as ano
                FROM pontos_de_captacao_sisagua_v2 pc
                LEFT JOIN amostras_por_ponto ap ON TRIM(pc.nu_solucao_abastecimento) = TRIM(ap.codigo_ponto)
                    AND pc.nu_ano = ap.ano
                    AND pc.co_municipio_ibge = ap.codigo_ibge
                WHERE pc.sg_uf = 'TO'
                  AND pc.co_municipio_ibge = :codIbge
                  AND pc.nu_ano = :ano
                  AND NULLIF(pc.nu_latitude, '') IS NOT NULL
                  AND NULLIF(pc.nu_longitude, '') IS NOT NULL
            )
            SELECT * FROM dados
            WHERE 1=1
              """;

        // Construir filtros dinâmicos
        if (tipoCaptacao != null && !tipoCaptacao.isBlank()) {
            sql += " AND UPPER(tipo_captacao) = UPPER(:tipoCaptacao)";
        }
        if (statusOutorga != null && !statusOutorga.isBlank()) {
            sql += " AND UPPER(status_outorga) = UPPER(:statusOutorga)";
        }
        if (minVazao != null) {
            sql += " AND vazao_captada >= :minVazao";
        }
        if (maxVazao != null) {
            sql += " AND vazao_captada <= :maxVazao";
        }
        if (minInconformidade != null) {
            sql += " AND percentual_inconformidade >= :minInconformidade";
        }
        if (maxInconformidade != null) {
            sql += " AND percentual_inconformidade <= :maxInconformidade";
        }

        sql += " ORDER BY codigo_ponto";

        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("codIbge", codIbge);
        query.setParameter("ano", ano);

        if (tipoCaptacao != null && !tipoCaptacao.isBlank()) {
            query.setParameter("tipoCaptacao", tipoCaptacao);
        }
        if (statusOutorga != null && !statusOutorga.isBlank()) {
            query.setParameter("statusOutorga", statusOutorga);
        }
        if (minVazao != null) {
            query.setParameter("minVazao", minVazao);
        }
        if (maxVazao != null) {
            query.setParameter("maxVazao", maxVazao);
        }
        if (minInconformidade != null) {
            query.setParameter("minInconformidade", minInconformidade);
        }
        if (maxInconformidade != null) {
            query.setParameter("maxInconformidade", maxInconformidade);
        }

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        return rows.stream().map(r -> new MapaPontosCaptacaoComAmostrasDTO(
            r[0] != null ? r[0].toString() : "",
            r[1] != null ? r[1].toString() : "",
            (java.math.BigDecimal) r[2],
            (java.math.BigDecimal) r[3],
            r[4] != null ? r[4].toString() : "",
            r[5] != null ? r[5].toString() : "",
            r[6] != null ? r[6].toString() : "",
            r[7] != null ? r[7].toString() : "",
            (java.math.BigDecimal) r[8],
            ((Number) r[9]).longValue(),
            ((Number) r[10]).longValue(),
            r[11] != null ? ((Number) r[11]).doubleValue() : null,
            r[12] != null ? r[12].toString() : "",
            ((Number) r[13]).intValue(),
            ((Number) r[14]).intValue()
        )).collect(java.util.stream.Collectors.toList());
    }

    // Versão não filtrada para compatibilidade com service/resource
    public List<MapaPontosCaptacaoComAmostrasDTO> mapaPontosComAmostras(Integer codIbge, Integer ano) {
        return mapaPontosComAmostrasFiltrado(codIbge, ano, null, null, null, null, null, null);
    }

    // ========== MÉTODOS PARA BUSCA POR ESTADO ==========

    /**
     * Busca pontos de captação por estado (UF)
     */
    public PanacheQuery<PontoCaptacaoV2> findByEstado(String uf, Integer ano) {
        return find("sgUf = :uf and ano = :ano", Map.of("uf", uf, "ano", ano));
    }

    /**
     * Retorna detalhes consolidados por estado
     */
    public PontoCaptacaoDetalhesDTO getDetalhesEstado(String uf, Integer ano) {
        return getEntityManager().createQuery(
            "SELECT NEW br.unitins.hackathon.sismato.dto.sisagua.PontoCaptacaoDetalhesDTO(" +
            "    COUNT(p), " +
            "    COALESCE(SUM(p.nuVazaoCaptada), 0), " +
            "    COALESCE(SUM(CASE WHEN p.tipoCaptacao = 'SUPERFICIAL' THEN 1 ELSE 0 END), 0), " +
            "    COALESCE(SUM(CASE WHEN p.tipoCaptacao = 'SUBTERRANEO' THEN 1 ELSE 0 END), 0), " +
            "    COALESCE(SUM(CASE WHEN p.stOutorga = 'S' THEN 1 ELSE 0 END), 0), " +
            "    COALESCE(SUM(CASE WHEN p.stOutorga = 'N' THEN 1 ELSE 0 END), 0), " +
            "    COALESCE(SUM(CASE WHEN p.stOutorga IS NULL OR p.stOutorga NOT IN ('S', 'N') THEN 1 ELSE 0 END), 0) " +
            ") " +
            "FROM PontoCaptacaoV2 p " +
            "WHERE p.sgUf = :uf and p.ano = :ano", PontoCaptacaoDetalhesDTO.class)
        .setParameter("uf", uf)
        .setParameter("ano", ano)
        .getSingleResult();
    }

    /**
     * Retorna a evolução histórica das vazões por estado
     */
    public List<EvolucaoVazaoDTO> evolucaoVazoesPorEstado(String uf) {
        String sql = "SELECT nu_ano, " +
                "AVG(nu_vazao_captada) AS vazao_media, " +
                "COUNT(*) AS quantidade_pontos " +
                "FROM public.pontos_de_captacao_sisagua_v2 " +
                "WHERE sg_uf = :uf AND nu_ano IS NOT NULL AND nu_vazao_captada IS NOT NULL " +
                "GROUP BY nu_ano " +
                "ORDER BY nu_ano ASC";

        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("uf", uf);

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        return rows.stream().map(r -> new EvolucaoVazaoDTO(
                ((Number) r[0]).intValue(),
                (java.math.BigDecimal) r[1],
                ((Number) r[2]).longValue()
        )).collect(Collectors.toList());
    }

    /**
     * Retorna o total de pontos com outorga por estado
     */
    public List<TotalOutorgaDTO> totalPorOutorgaEstado(String uf, Integer ano) {
        String sql = "SELECT " +
                "CASE WHEN st_outorga = 'S' THEN 'Sim' " +
                "WHEN st_outorga = 'N' THEN 'Não' " +
                "ELSE 'Não informado' END AS status_outorga, " +
                "COUNT(*) AS total " +
                "FROM public.pontos_de_captacao_sisagua_v2 " +
                "WHERE sg_uf = :uf AND nu_ano = :ano " +
                "GROUP BY CASE WHEN st_outorga = 'S' THEN 'Sim' " +
                "WHEN st_outorga = 'N' THEN 'Não' " +
                "ELSE 'Não informado' END " +
                "ORDER BY total DESC";

        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("uf", uf);
        query.setParameter("ano", ano);

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        return rows.stream().map(r -> new TotalOutorgaDTO(
                (String) r[0],
                ((Number) r[1]).longValue()
        )).collect(Collectors.toList());
    }

    /**
     * Retorna a quantidade de pontos por tipo de captação por estado
     */
    public List<TipoCaptacaoDTO> quantidadePorTipoCaptacaoEstado(String uf, Integer ano) {
        String sql = "SELECT tp_captacao, COUNT(*) AS quantidade " +
                "FROM public.pontos_de_captacao_sisagua_v2 " +
                "WHERE sg_uf = :uf AND nu_ano = :ano AND tp_captacao IS NOT NULL " +
                "GROUP BY tp_captacao " +
                "ORDER BY quantidade DESC";

        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("uf", uf);
        query.setParameter("ano", ano);

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        return rows.stream().map(r -> new TipoCaptacaoDTO(
                (String) r[0],
                ((Number) r[1]).longValue()
        )).collect(Collectors.toList());
    }
}