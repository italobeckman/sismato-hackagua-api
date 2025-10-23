package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOutros;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralOutrosRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ControleSemestralOutrosService
        extends AbstractControleService<ControleSemestralOutros, ControleSemestralOutrosRepository> {
    @Inject
    ControleSemestralOutrosRepository controleSemestralOutrosRepository;

    @Override
    protected ControleSemestralOutrosRepository getRepository() {
        return controleSemestralOutrosRepository;
    }
}
