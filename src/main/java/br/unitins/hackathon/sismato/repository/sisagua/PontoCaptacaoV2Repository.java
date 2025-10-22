package br.unitins.hackathon.sismato.repository.sisagua;

import br.unitins.hackathon.sismato.dto.sisagua.PontoCaptacaoDetalhesDTO;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacaoV2;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

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
}