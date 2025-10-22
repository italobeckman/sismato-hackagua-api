package br.unitins.hackathon.sismato.service.sisagua;

import java.util.Arrays;
import java.util.List;

import br.unitins.hackathon.sismato.entity.sisagua.MensalAmostras;
import br.unitins.hackathon.sismato.dto.sisagua.MensalAmostrasResumoPorAnoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.RankingMunicipioDTO;
import br.unitins.hackathon.sismato.dto.sisagua.RankingMunicipioAnoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TimeSeriesParametroDTO;
import br.unitins.hackathon.sismato.dto.sisagua.ParametroCriticoDTO;
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

    public List<MensalAmostrasResumoPorAnoDTO> resumoPorAnoPorUf(String uf) {
        return repository.resumoPorAnoPorUf(uf);
    }

    public List<RankingMunicipioDTO> rankingMunicipiosGeralTO(int minAmostras, int limit) {
        return repository.rankingMunicipiosGeralTO(minAmostras, limit);
    }

    public List<RankingMunicipioAnoDTO> rankingMunicipiosPorAnoTO(int minAmostras, int limit) {
        return repository.rankingMunicipiosPorAnoTO(minAmostras, limit);
    }

    public List<TimeSeriesParametroDTO> serieTemporalPorMunicipioParametrosTO(String codIbge, List<String> parametros) {
        // Lista de parâmetros permitidos
        List<String> permitidos = List.of(
            "Bactérias Heterotróficas (UFC/mL)",
            "Coliformes totais",
            "Cor (uH)",
            "Escherichia coli",
            "Fluoreto (mg/L)",
            "pH",
            "Residual de Desinfetante",
            "Turbidez (uT)"
        );
        if (parametros == null || parametros.isEmpty()) {
            return List.of();
        }
        // Filtra para apenas os permitidos
        List<String> filtrados = parametros.stream()
            .filter(permitidos::contains)
            .toList();
        if (filtrados.isEmpty()) {
            return List.of();
        }
        return repository.serieTemporalPorMunicipioParametrosTO(codIbge, filtrados);
    }

    public List<ParametroCriticoDTO> topParametrosAnoAnteriorTO(int limit) {
        return repository.topParametrosAnoAnteriorTO(limit);
    }

}
