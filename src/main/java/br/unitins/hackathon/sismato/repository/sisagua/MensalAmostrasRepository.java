package br.unitins.hackathon.sismato.repository.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.MensalAmostras;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

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
}