package br.unitins.hackathon.sismato.service.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralInorganica;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacao;
import br.unitins.hackathon.sismato.repository.sisagua.ControleSemestralInorganicaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ControleSemestralInorganicaService {
    
    @Inject
    ControleSemestralInorganicaRepository controleSemestralInorganicaRepository;

     public List<ControleSemestralInorganica> findByCodigoMunicipio(Long codigoMunicipio, int page, int pageSize) {
        return controleSemestralInorganicaRepository.findByMunicipio(codigoMunicipio).page(page, pageSize).list();
    }
}
