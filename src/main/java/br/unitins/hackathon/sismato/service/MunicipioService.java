package br.unitins.hackathon.sismato.service;

import br.unitins.hackathon.sismato.dto.MunicipioDTO;
import br.unitins.hackathon.sismato.entity.geo.Municipio;
import br.unitins.hackathon.sismato.repository.MunicipioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MunicipioService {
    @Inject
    MunicipioRepository municipioRepository;

    public Municipio findById(Long id) {
        return municipioRepository.findById(id);
    }

    @Transactional
    public Municipio save(MunicipioDTO municipioDTO) {
        Municipio municipio = MunicipioDTO.toEntity(municipioDTO);
        municipioRepository.persist(municipio);

        return municipio;
    }
}
