package br.unitins.hackathon.sismato.repository.sisagua;

import br.unitins.hackathon.sismato.dto.sisagua.controlesemestral.ColetaAnualDTO;
import br.unitins.hackathon.sismato.dto.sisagua.controlesemestral.ColetaMensalDTO;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Table;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractControleRepository<T> implements PanacheRepository<T> {
    @Inject
    EntityManager em;

    protected String getTableName() {
        String tableName = null;

        try {
            ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
            Class<T> entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];

            if (entityClass.isAnnotationPresent(Table.class)) {
                Table tableAnnotation = entityClass.getAnnotation(Table.class);
                tableName = tableAnnotation.name();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter nome da tabela", e);
        }

        return tableName;
    }

    public ColetaAnualDTO findAnualWithFilter(
            String codigoMunicipio,
            Integer ano
    ) {
        String sql = """
                SELECT
                    ano_referencia AS ano,
                    COUNT(*) AS qtdTotal,
                    SUM(CASE WHEN UPPER(TRIM(COALESCE(captacao_superficial, ''))) = 'SIM' THEN 1 ELSE 0 END) AS qtdCaptacaoSuperficial,
                    SUM(CASE WHEN UPPER(TRIM(COALESCE(captacao_subterranea, ''))) = 'SIM' THEN 1 ELSE 0 END) AS qtdCaptcaoSubterranea,
                    SUM(CASE WHEN UPPER(TRIM(COALESCE(captacao_agua_chuva, ''))) = 'SIM' THEN 1 ELSE 0 END) AS qtdCaptacaoAguaChuva,
                    SUM(CASE WHEN UPPER(TRIM(COALESCE(area_urbana, ''))) = 'SIM'
                             AND UPPER(TRIM(COALESCE(area_rural, ''))) != 'SIM' THEN 1 ELSE 0 END) AS qtdAreaUrbana,
                    SUM(CASE WHEN UPPER(TRIM(COALESCE(area_rural, ''))) = 'SIM'
                             AND UPPER(TRIM(COALESCE(area_urbana, ''))) != 'SIM' THEN 1 ELSE 0 END) AS qtdAreaRural
                FROM
                    %s
                WHERE
                    ano_referencia IS NOT NULL
                AND
                    ano_referencia = :ano
                AND
                    ibge_code = :municipio
                GROUP
                    BY ano_referencia
                """;

        String resultSql = String.format(sql, getTableName());

        Query query = em.createNativeQuery(resultSql, ColetaAnualDTO.class)
                .setParameter("ano", ano)
                .setParameter("municipio", codigoMunicipio);

        try {
            ColetaAnualDTO coletAnualDTO = (ColetaAnualDTO) query.getSingleResult();
            coletAnualDTO.setAno(ano);

            return coletAnualDTO;
        } catch (Exception e) {
            return new ColetaAnualDTO(0, 0L, 0L, 0L, 0L, 0L, 0L);
        }
    }

    public ColetaMensalDTO findMensalWithFilter(
            String codigoMunicipio,
            Integer ano,
            String mes
    ) {
        String sql = """
                SELECT
                    mes_coleta AS mes,
                    COUNT(*) AS qtdTotal,
                    SUM(CASE WHEN UPPER(TRIM(COALESCE(captacao_superficial, ''))) = 'SIM' THEN 1 ELSE 0 END) AS qtdCaptacaoSuperficial,
                    SUM(CASE WHEN UPPER(TRIM(COALESCE(captacao_subterranea, ''))) = 'SIM' THEN 1 ELSE 0 END) AS qtdCaptcaoSubterranea,
                    SUM(CASE WHEN UPPER(TRIM(COALESCE(captacao_agua_chuva, ''))) = 'SIM' THEN 1 ELSE 0 END) AS qtdCaptacaoAguaChuva,
                    SUM(CASE WHEN UPPER(TRIM(COALESCE(area_urbana, ''))) = 'SIM'
                             AND UPPER(TRIM(COALESCE(area_rural, ''))) != 'SIM' THEN 1 ELSE 0 END) AS qtdAreaUrbana,
                    SUM(CASE WHEN UPPER(TRIM(COALESCE(area_rural, ''))) = 'SIM'
                             AND UPPER(TRIM(COALESCE(area_urbana, ''))) != 'SIM' THEN 1 ELSE 0 END) AS qtdAreaRural
                FROM
                    %s
                WHERE
                    mes_coleta IS NOT NULL
                    AND ano_referencia IS NOT NULL
                    AND ano_referencia = :ano        -- Filtro por ano
                    AND LOWER(TRIM(mes_coleta)) = LOWER(:mes)       -- Filtro por mês
                    AND ibge_code = :municipio
                    GROUP BY mes_coleta
                """;

        String resultSql = String.format(sql, getTableName());

        Query query = em.createNativeQuery(resultSql, ColetaMensalDTO.class)
                .setParameter("ano", ano)
                .setParameter("mes", mes.trim())
                .setParameter("municipio", codigoMunicipio);

        try {
            ColetaMensalDTO coletaMensalDTO = (ColetaMensalDTO) query.getSingleResult();
            coletaMensalDTO.setAno(ano);

            return coletaMensalDTO;
        } catch (Exception e) {
            return new ColetaMensalDTO("Janeiro", 0L, 0L, 0L, 0L, 0L, 0L);
        }
    }

    public PanacheQuery<T> findByDataFiltros(
            Long codigoMunicipio,
            Integer anoReferencia,
            Integer semestreColeta,
            String mesColeta
    ) {

        StringBuilder queryBuilder = new StringBuilder(" 1 = 1 ");


        Map<String, Object> params = new HashMap<>();

        if (codigoMunicipio != null) {
            queryBuilder.append(" AND municipioCod.codigo = :municipioCod ");
            params.put("municipioCod", codigoMunicipio);
        }


        if (anoReferencia != null) {
            queryBuilder.append(" AND anoReferencia = :anoReferencia ");
            params.put("anoReferencia", anoReferencia);
        }


        if (semestreColeta != null) {
            queryBuilder.append(" AND semestreColeta = :semestreColeta ");
            params.put("semestreColeta", semestreColeta);
        }


        if (mesColeta != null && !mesColeta.isBlank()) {
            queryBuilder.append(" AND mesColeta = :mesColeta ");
            params.put("mesColeta", mesColeta);
        }

        return find(queryBuilder.toString(), params);
    }

    public PanacheQuery<T> findByMunicipio(Long codigoMunicipio) {
        return find("municipioCod.codigo", codigoMunicipio);
    }
}
