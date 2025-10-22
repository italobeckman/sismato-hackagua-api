package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.dto.sisagua.PontoCaptacaoDetalhesDTO;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacaoV2;
import br.unitins.hackathon.sismato.repository.sisagua.PontoCaptacaoV2Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PontoCaptacaoV2Service {

    @Inject
    PontoCaptacaoV2Repository repository;

    public List<PontoCaptacaoV2> findByCodigoMunicipio(Integer codigoMunicipio, Integer ano, int page, int pageSize) {
        var q = repository.findByMunicipioCodigo(codigoMunicipio, ano);
        q.page(page, pageSize);
        q.withHint("org.hibernate.fetchSize", Math.min(pageSize, 1000));
        return q.list();
    }

    public List<PontoCaptacaoV2> findByFilters(Integer codigoIbge, Integer ano, String municipio, String tpCaptacao, int page, int pageSize) {
        var q = repository.findByFilters(codigoIbge, ano, municipio, tpCaptacao);
        q.page(page, pageSize);
        q.withHint("org.hibernate.fetchSize", Math.min(pageSize, 1000));
        return q.list();
    }

    public List<PontoCaptacaoV2> findAll() {
        return repository.listAll();
    }

    public List<PontoCaptacaoV2> findAllPaged(int page, int pageSize) {
        var q = repository.findAll();
        q.page(page, pageSize);
        q.withHint("org.hibernate.fetchSize", Math.min(pageSize, 1000));
        return q.list();
    }

    public PontoCaptacaoDetalhesDTO getDetalhesPorCodigoIbge(Integer codigoIbge, Integer ano) {
        PontoCaptacaoDetalhesDTO detalhes = repository.getDetalhesPorCodigoIbge(codigoIbge, ano);
        return detalhes;
    }

    public long count() {
        return repository.count();
    }

    public PontoCaptacaoV2 findById(Long id) {
        return repository.findById(id);
    }
}