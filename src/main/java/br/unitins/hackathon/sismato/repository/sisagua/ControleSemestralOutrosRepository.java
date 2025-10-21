package br.unitins.hackathon.sismato.repository.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOutros;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ControleSemestralOutrosRepository implements PanacheRepository<ControleSemestralOutros> {

    public PanacheQuery<ControleSemestralOutros> findByMunicipio(Long codigoMunicipio){
        return find("municipioCod.codigo", codigoMunicipio);
    }
}
