package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralAgrotoxicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ControleSemestralAgrotoxicoService{
    @Inject
    ControleSemestralAgrotoxicoRepository controleSemestralAgrotoxicoRepository;

    public List<ControleSemestralAgrotoxico> findByCodigoMunicipio(Long codigoMunicipio, int page, int pageSize) {
        return controleSemestralAgrotoxicoRepository.findByMunicipio(codigoMunicipio).page(page, pageSize).list();
    }
}