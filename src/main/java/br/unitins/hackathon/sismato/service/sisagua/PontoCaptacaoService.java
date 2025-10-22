package br.unitins.hackathon.sismato.service.sisagua;

import java.util.List;

import br.unitins.hackathon.sismato.dto.sisagua.EvolucaoVazaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TipoCaptacaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TotalOutorgaDTO;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacao;
import br.unitins.hackathon.sismato.repository.sisagua.PontoCaptacaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PontoCaptacaoService {

    @Inject
    PontoCaptacaoRepository pontoCaptacaoRepository;

    public List<PontoCaptacao> findByCodigoMunicipio(Long codigoMunicipio, int page, int pageSize) {
        return pontoCaptacaoRepository.findByMunicipio(codigoMunicipio).page(page, pageSize).list();
    }

    public List<PontoCaptacao> findAll() {
        return pontoCaptacaoRepository.listAll();
    }

    public List<PontoCaptacao> findAllPaged(int page, int pageSize) {
        var q = pontoCaptacaoRepository.findAll();
        q.page(page, pageSize);
        q.withHint("org.hibernate.fetchSize", Math.min(pageSize, 1000));
        return q.list();
    }

    public long count() {
        return pontoCaptacaoRepository.count();
    }

    public PontoCaptacao findById(Long id) {
        return pontoCaptacaoRepository.findById(id);
    }

    /**
     * Retorna a evolução histórica das vazões por ano
     */
    public List<EvolucaoVazaoDTO> evolucaoVazoesPorAno() {
        return pontoCaptacaoRepository.evolucaoVazoesPorAno();
    }

    /**
     * Retorna o total de pontos com outorga SIM ou NÃO
     */
    public List<TotalOutorgaDTO> totalPorOutorga() {
        return pontoCaptacaoRepository.totalPorOutorga();
    }

    /**
     * Retorna a quantidade de pontos por tipo de captação (Subterrâneo/Superficial)
     */
    public List<TipoCaptacaoDTO> quantidadePorTipoCaptacao() {
        return pontoCaptacaoRepository.quantidadePorTipoCaptacao();
    }
    
}
