package br.unitins.hackathon.sismato.repository.sisagua;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacao;

@ApplicationScoped
public class PontoCaptacaoRepository implements PanacheRepository<PontoCaptacao>{
    
    public PanacheQuery<PontoCaptacao> findByMunicipio(Long codigoMunicipio){
        return find("codigoIbge", codigoMunicipio);
    }
}
