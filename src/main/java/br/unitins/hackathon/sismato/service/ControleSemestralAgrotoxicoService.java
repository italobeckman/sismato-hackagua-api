package br.unitins.hackathon.sismato.service;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralAgrotoxicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ControleSemestralAgrotoxicoService {
    @Inject
    ControleSemestralAgrotoxicoRepository controleSemestralAgrotoxicoRepository;

    public List<ControleSemestralAgrotoxico> findBySiglaInsitituicao(String sigla) {
        return controleSemestralAgrotoxicoRepository.findBySiglaInstituicao(sigla);
    }
}
