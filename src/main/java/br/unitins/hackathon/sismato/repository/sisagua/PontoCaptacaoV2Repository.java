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
    public List<MapaPontosCaptacaoComAmostrasDTO> mapaPontosComAmostras(Integer codIbge, Integer ano) {
        String sql = """
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
                COALESCE(SUM(ma.num_amostras_analisadas), 0) as total_amostras,
                COALESCE(SUM(ma.num_amostras_fora_do_padrao), 0) as amostras_inconformes,
                CASE
                    WHEN SUM(ma.num_amostras_analisadas) > 0
                    THEN ROUND((SUM(ma.num_amostras_fora_do_padrao) * 100.0 / SUM(ma.num_amostras_analisadas)), 2)
                    ELSE 0.0
                END as percentual_inconformidade,
                COALESCE(pc.no_municipio, '') as municipio,
                pc.co_municipio_ibge as codigo_ibge,
                pc.nu_ano as ano
            FROM pontos_de_captacao_sisagua_v2 pc
            LEFT JOIN mensal_amostras_sisagua ma ON pc.nu_solucao_abastecimento = ma.codigo_nome_saa_sac
                AND pc.nu_ano = ma.ano
                AND pc.co_municipio_ibge = ma.cod_mun_ibge::integer
            WHERE pc.sg_uf = 'TO'
                AND pc.co_municipio_ibge = :codIbge
                AND pc.nu_ano = :ano
                AND NULLIF(pc.nu_latitude, '') IS NOT NULL
                AND NULLIF(pc.nu_longitude, '') IS NOT NULL
            GROUP BY pc.nu_solucao_abastecimento, pc.no_ponto_captacao, pc.nu_latitude,
                     pc.nu_longitude, pc.tp_captacao, pc.st_outorga, pc.no_instituicao,
                     pc.no_eta, pc.nu_vazao_captada, pc.no_municipio, pc.co_municipio_ibge, pc.nu_ano
            ORDER BY pc.nu_solucao_abastecimento
            """;

        var query = getEntityManager().createNativeQuery(sql);
        query.setParameter("codIbge", codIbge);
        query.setParameter("ano", ano);

        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();

        return rows.stream().map(r -> new MapaPontosCaptacaoComAmostrasDTO(
            r[0] != null ? r[0].toString() : "",                    // codigoPontoCaptacao
            r[1] != null ? r[1].toString() : "",                    // nomePontoCaptacao
            (java.math.BigDecimal) r[2],                           // latitude
            (java.math.BigDecimal) r[3],                           // longitude
            r[4] != null ? r[4].toString() : "",                    // tipoCaptacao
            r[5] != null ? r[5].toString() : "",                    // statusOutorga
            r[6] != null ? r[6].toString() : "",                    // nomeInstituicao
            r[7] != null ? r[7].toString() : "",                    // nomeEta
            (java.math.BigDecimal) r[8],                           // vazaoCaptada
            ((Number) r[9]).longValue(),                           // totalAmostras
            ((Number) r[10]).longValue(),                          // amostrasInconformes
            ((Number) r[11]).doubleValue(),                        // percentualInconformidade
            r[12] != null ? r[12].toString() : "",                 // municipio
            ((Number) r[13]).intValue(),                           // codigoIbge
            ((Number) r[14]).intValue()                            // ano
        )).collect(Collectors.toList());
    }
}