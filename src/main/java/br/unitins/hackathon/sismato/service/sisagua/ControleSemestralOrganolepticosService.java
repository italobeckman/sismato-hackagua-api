package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOrganolepticos;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralOrganolepticosRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ControleSemestralOrganolepticosService {
    
    @Inject
    ControleSemestralOrganolepticosRepository controleSemestralOrganolepticosRepository;

     public List<ControleSemestralOrganolepticos> findByCodigoMunicipio(Long codigoMunicipio, int page, int pageSize) {
        return controleSemestralOrganolepticosRepository.findByMunicipio(codigoMunicipio).page(page, pageSize).list();
    }

    public List<ControleSemestralOrganolepticos> findByFiltros(FilterBaseControle filtros, int page, int pageSize) {
        return controleSemestralOrganolepticosRepository
                .findByDataFiltros(filtros.codMunicipio(), filtros.anoReferencia(), filtros.semestreColeta(), filtros.mesColeta())
                .page(page, pageSize)
                .list();
    }
}
