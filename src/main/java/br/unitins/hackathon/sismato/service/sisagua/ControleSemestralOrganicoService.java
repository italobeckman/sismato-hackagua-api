package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOrganico;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralOrganicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ControleSemestralOrganicoService {
    
    @Inject
    ControleSemestralOrganicoRepository controleSemestralOrganicoRepository;

     public List<ControleSemestralOrganico> findByCodigoMunicipio(Long codigoMunicipio, int page, int pageSize) {
        return controleSemestralOrganicoRepository.findByMunicipio(codigoMunicipio).page(page, pageSize).list();
    }

        public List<ControleSemestralOrganico> findByFiltros(FilterBaseControle filtros, int page, int pageSize) {
            return controleSemestralOrganicoRepository
                    .findByDataFiltros(filtros.codMunicipio(), filtros.anoReferencia(), filtros.semestreColeta(), filtros.mesColeta())
                    .page(page, pageSize)
                    .list();
        }
}
