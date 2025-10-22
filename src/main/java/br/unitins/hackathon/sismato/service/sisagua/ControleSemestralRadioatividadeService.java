package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralRadioatividade;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralRadioatividadeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ControleSemestralRadioatividadeService {
    
    @Inject
    ControleSemestralRadioatividadeRepository controleSemestralRadioatividadeRepository;

     public List<ControleSemestralRadioatividade> findByCodigoMunicipio(Long codigoMunicipio, int page, int pageSize) {
        return controleSemestralRadioatividadeRepository.findByMunicipio(codigoMunicipio).page(page, pageSize).list();
    }

    public List<ControleSemestralRadioatividade> findByFiltros(FilterBaseControle filtros, int page, int pageSize) {
        return controleSemestralRadioatividadeRepository
                .findByDataFiltros(filtros.codMunicipio(), filtros.anoReferencia(), filtros.semestreColeta(), filtros.mesColeta())
                .page(page, pageSize)
                .list();
    }
}
