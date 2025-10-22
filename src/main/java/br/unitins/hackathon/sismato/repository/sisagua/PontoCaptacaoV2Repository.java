package br.unitins.hackathon.sismato.repository.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacaoV2;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class PontoCaptacaoV2Repository implements PanacheRepository<PontoCaptacaoV2> {

    public PanacheQuery<PontoCaptacaoV2> findByMunicipioCodigo(Integer codigoIbge) {
        return find("codigoIbge", codigoIbge);
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
}