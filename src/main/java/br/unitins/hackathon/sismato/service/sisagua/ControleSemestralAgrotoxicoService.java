package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralAgrotoxicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.nio.file.DirectoryStream.Filter;
import java.util.List;

@ApplicationScoped
public class ControleSemestralAgrotoxicoService{
    @Inject
    ControleSemestralAgrotoxicoRepository controleSemestralAgrotoxicoRepository;

    public List<ControleSemestralAgrotoxico> findByCodigoMunicipio(Long codigoMunicipio, int page, int pageSize) {
        return controleSemestralAgrotoxicoRepository.findByMunicipio(codigoMunicipio).page(page, pageSize).list();
    }

    public List<ControleSemestralAgrotoxico> findByFiltros(FilterBaseControle filtros, int page, int pageSize) {
        return controleSemestralAgrotoxicoRepository
                .findByDataFiltros(filtros.codMunicipio(), filtros.anoReferencia(), filtros.semestreColeta(), filtros.mesColeta())
                .page(page, pageSize)
                .list();
    }
}