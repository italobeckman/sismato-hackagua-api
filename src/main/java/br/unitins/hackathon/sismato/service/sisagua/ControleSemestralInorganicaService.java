package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralInorganica;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacao;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralInorganicaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ControleSemestralInorganicaService
        extends AbstractControleService<ControleSemestralInorganica, ControleSemestralInorganicaRepository> {

    @Inject
    ControleSemestralInorganicaRepository controleSemestralInorganicaRepository;

    @Override
    protected ControleSemestralInorganicaRepository getRepository() {
        return controleSemestralInorganicaRepository;
    }
}

