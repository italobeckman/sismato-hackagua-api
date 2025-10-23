package br.unitins.hackathon.sismato.service.sisagua;

import java.util.List;

import br.unitins.hackathon.sismato.dto.sisagua.EvolucaoVazaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.PontoCaptacaoDetalhesDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TipoCaptacaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TotalOutorgaDTO;
import br.unitins.hackathon.sismato.dto.MapaPontosCaptacaoComAmostrasDTO;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacaoV2;
import br.unitins.hackathon.sismato.repository.sisagua.PontoCaptacaoV2Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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

    /**
     * Retorna a evolução histórica das vazões por ano e município (opcional)
     */
    public List<EvolucaoVazaoDTO> evolucaoVazoesPorAno(Integer codigoIbge) {
        return repository.evolucaoVazoesPorAno(codigoIbge);
    }

    /**
     * Retorna o total de pontos com outorga SIM ou NÃO por ano e município (opcional)
     */
    public List<TotalOutorgaDTO> totalPorOutorga(Integer ano, Integer codigoIbge) {
        return repository.totalPorOutorga(ano, codigoIbge);
    }

    /**
     * Retorna a quantidade de pontos por tipo de captação (Subterrâneo/Superficial) por ano e município (opcional)
     */
    public List<TipoCaptacaoDTO> quantidadePorTipoCaptacao(Integer ano, Integer codigoIbge) {
        return repository.quantidadePorTipoCaptacao(ano, codigoIbge);
    }

    /**
     * Retorna dados geoespaciais de pontos de captação com informações de qualidade da água
     * GRÁFICO: Mapa com marcadores - Pontos de captação com tooltips ricos de qualidade da água
     * INSIGHT: Visualização geográfica integrada de infraestrutura e qualidade da água
     */
    public List<MapaPontosCaptacaoComAmostrasDTO> mapaPontosComAmostras(Integer codIbge, Integer ano) {
        return repository.mapaPontosComAmostras(codIbge, ano);
    }
}