package br.unitins.hackathon.sismato.service.sisagua;

import java.util.List;

import br.unitins.hackathon.sismato.entity.sisagua.MensalAmostras;
import br.unitins.hackathon.sismato.repository.sisagua.MensalAmostrasRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MensalAmostrasService {

    @Inject
    MensalAmostrasRepository repository;

    public List<MensalAmostras> findByFilters(String municipio, Integer ano, String mesReferencia, String parametro,
            int page, int pageSize) {
        var q = repository.findByFilters(municipio, ano, mesReferencia, parametro);
        q.page(page, pageSize);
        q.withHint("org.hibernate.fetchSize", Math.min(pageSize, 1000));
        return q.list();
    }

    public List<MensalAmostras> findAll() {
        return repository.listAll();
    }

    public List<MensalAmostras> findAllPaged(int page, int pageSize) {
        var q = repository.findAll();
        q.page(page, pageSize);
        q.withHint("org.hibernate.fetchSize", Math.min(pageSize, 1000));
        return q.list();
    }

    public long count() {
        return repository.count();
    }

    public MensalAmostras findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    protected List<MensalAmostras> loadPage(int page, int pageSize) {
        var query = repository.findAll();
        query.page(page, pageSize);
        return query.list();

    }

   
}
