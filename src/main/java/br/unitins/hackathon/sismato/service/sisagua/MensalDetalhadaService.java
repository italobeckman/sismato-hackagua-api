package br.unitins.hackathon.sismato.service.sisagua;

import java.util.List;

import br.unitins.hackathon.sismato.entity.sisagua.MensalDetalhadas;
import br.unitins.hackathon.sismato.repository.sisagua.MensalDetalhadasRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MensalDetalhadaService {

    @Inject
    MensalDetalhadasRepository repository;

    public List<MensalDetalhadas> findByFilters(String municipio, Integer ano, String mesReferencia, String parametro,
            int page, int pageSize) {
        return repository.findByFilters(municipio, ano, mesReferencia, parametro).page(page, pageSize).list();
    }

    public List<MensalDetalhadas> findAll() {
        return repository.listAll();
    }

    public List<MensalDetalhadas> findAllPaged(int page, int pageSize) {
        var q = repository.findAll();
        q.page(page, pageSize);
        q.withHint("org.hibernate.fetchSize", Math.min(pageSize, 1000));
        return q.list();
    }

    public long count() {
        return repository.count();
    }

    public MensalDetalhadas findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    protected List<MensalDetalhadas> loadPage(int page, int pageSize) {
        var query = repository.findAll();
        query.page(page, pageSize);
        return query.list();

    }

}
