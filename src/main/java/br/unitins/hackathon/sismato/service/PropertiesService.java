package br.unitins.hackathon.sismato.service;

import br.unitins.hackathon.sismato.dto.PropertiesDTO;
import br.unitins.hackathon.sismato.entity.geo.Properties;
import br.unitins.hackathon.sismato.repository.PropertiesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PropertiesService {
    @Inject
    PropertiesRepository propertiesRepository;

    public Properties findById(Long id) {
        return propertiesRepository.findById(id);
    }

    @Transactional
    public Properties save(PropertiesDTO propertiesDTO) {
        Properties properties = PropertiesDTO.toEntity(propertiesDTO);
        propertiesRepository.persist(properties);

        return properties;
    }
}
