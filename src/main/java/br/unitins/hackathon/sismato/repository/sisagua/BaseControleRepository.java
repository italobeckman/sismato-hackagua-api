package br.unitins.hackathon.sismato.repository.sisagua;

import java.util.HashMap;
import java.util.Map;

import br.unitins.hackathon.sismato.entity.sisagua.BaseControle;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public interface BaseControleRepository<T extends BaseControle> extends PanacheRepository<T> {

    default PanacheQuery<T> findByMunicipio(Long codigoMunicipio) {
        return find("municipioCod.codigo", codigoMunicipio);
    }

    default PanacheQuery<T> findByDataFiltros(
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

}
