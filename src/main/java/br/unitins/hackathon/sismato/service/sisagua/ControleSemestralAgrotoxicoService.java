package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralAgrotoxicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ControleSemestralAgrotoxicoService
        extends AbstractControleService<ControleSemestralAgrotoxico, ControleSemestralAgrotoxicoRepository> {
    @Inject
    ControleSemestralAgrotoxicoRepository controleSemestralAgrotoxicoRepository;

    @Override
    protected ControleSemestralAgrotoxicoRepository getRepository() {
        return controleSemestralAgrotoxicoRepository;
    }
}