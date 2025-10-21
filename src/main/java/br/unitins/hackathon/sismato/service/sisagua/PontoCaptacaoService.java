package br.unitins.hackathon.sismato.service.sisagua;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import br.unitins.hackathon.sismato.repository.sisagua.PontoCaptacaoRepository;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacao;

import java.util.List;

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
    
}
