package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralInorganica;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOrganolepticos;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralInorganicaRepository;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralOrganolepticosRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ControleSemestralOrganolepticosService
        extends AbstractControleService<ControleSemestralOrganolepticos, ControleSemestralOrganolepticosRepository> {
    
    @Inject
    ControleSemestralOrganolepticosRepository controleSemestralOrganolepticosRepository;

    @Override
    protected ControleSemestralOrganolepticosRepository getRepository() {
        return controleSemestralOrganolepticosRepository;
    }
}
