package br.unitins.hackathon.sismato.repository.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.MensalDetalhadas;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class MensalDetalhadasRepository implements PanacheRepository<MensalDetalhadas> {

    public PanacheQuery<MensalDetalhadas> findByMunicipio(String municipio) {
        return find("municipio", municipio);
    }

    public PanacheQuery<MensalDetalhadas> findByAno(Integer ano) {
        return find("ano", ano);
    }

    public PanacheQuery<MensalDetalhadas> findByMesReferencia(String mesReferencia) {
        return find("mesReferencia", mesReferencia);
    }

    public PanacheQuery<MensalDetalhadas> findByParametro(String parametro) {
        return find("parametro", parametro);
    }

    public PanacheQuery<MensalDetalhadas> findByFilters(String codMunicipio, Integer ano, String mesReferencia, String parametro) {
        StringBuilder query = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        if (codMunicipio != null && !codMunicipio.isBlank()) {
            query.append("codMunIbge = :codMunIbge");
            params.put("codMunIbge", codMunicipio);
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
}