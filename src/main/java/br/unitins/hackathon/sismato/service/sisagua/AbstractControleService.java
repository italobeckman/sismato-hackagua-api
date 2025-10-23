package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.dto.sisagua.controlesemestral.ColetaAnualDTO;
import br.unitins.hackathon.sismato.dto.sisagua.controlesemestral.ColetaMensalDTO;
import br.unitins.hackathon.sismato.repository.sisagua.AbstractControleRepository;

import java.util.List;

public abstract class AbstractControleService<T, R extends AbstractControleRepository<T>> {

    protected abstract R getRepository();

    public List<T> findByCodigoMunicipio(Long codigoMunicipio, int page, int pageSize) {
        return getRepository()
                .findByMunicipio(codigoMunicipio)
                .page(page, pageSize)
                .list();
    }

    public List<T> findByFiltros(FilterBaseControle filtros, int page, int pageSize) {
        return getRepository()
                .findByDataFiltros(
                        filtros.codMunicipio(),
                        filtros.anoReferencia(),
                        filtros.semestreColeta(),
                        filtros.mesColeta()
                )
                .page(page, pageSize)
                .list();
    }

    public ColetaAnualDTO findColetaAnualWithFilter(FilterBaseControle filtros, int page, int pageSize) {
        String codigoMunicipio = filtros.codMunicipio() != null
                ? String.valueOf(filtros.codMunicipio())
                : null;

        return getRepository().findAnualWithFilter(
                codigoMunicipio,
                filtros.anoReferencia()
        );
    }

    public ColetaMensalDTO findColetaMensalWithFilter(FilterBaseControle filtros, int page, int pageSize) {
        String codigoMunicipio = filtros.codMunicipio() != null
                ? String.valueOf(filtros.codMunicipio())
                : null;

        return getRepository().findMensalWithFilter(
                codigoMunicipio,
                filtros.anoReferencia(),
                filtros.mesColeta()
        );
    }

    public long count() {
        return getRepository().count();
    }

    public T findById(Long id) {
        return getRepository().findById(id);
    }

    public List<T> listAll(int page, int pageSize) {
        return getRepository()
                .findAll()
                .page(page, pageSize)
                .list();
    }
}