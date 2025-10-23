package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.dto.filters.FilterBaseControle;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralOutros;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralRadioatividade;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralOutrosRepository;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralRadioatividadeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ControleSemestralRadioatividadeService
        extends AbstractControleService<ControleSemestralRadioatividade, ControleSemestralRadioatividadeRepository> {
    @Inject
    ControleSemestralRadioatividadeRepository controleSemestralRadioatividadeRepository;

    @Override
    protected ControleSemestralRadioatividadeRepository getRepository() {
        return controleSemestralRadioatividadeRepository;
    }
}
