package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOutros;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralOutrosRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ControleSemestralOutrosService {
    
    @Inject
    ControleSemestralOutrosRepository controleSemestralOutrosRepository;

     public List<ControleSemestralOutros> findByCodigoMunicipio(Long codigoMunicipio, int page, int pageSize) {
        return controleSemestralOutrosRepository.findByMunicipio(codigoMunicipio).page(page, pageSize).list();
    }

    public List<ControleSemestralOutros> findByFiltros(FilterBaseControle filtros, int page, int pageSize) {
        return controleSemestralOutrosRepository
                .findByDataFiltros(filtros.codMunicipio(), filtros.anoReferencia(), filtros.semestreColeta(), filtros.mesColeta())
                .page(page, pageSize)
                .list();
    }
}
