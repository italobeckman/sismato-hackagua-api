package br.unitins.hackathon.sismato.repository.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.BaseControle;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public interface BaseControleRepository<T extends BaseControle> extends PanacheRepository<T> {

    default PanacheQuery<T> findByMunicipio(Long codigoMunicipio) {
        return find("municipioCod.codigo", codigoMunicipio);
    }

}
