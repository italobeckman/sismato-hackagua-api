package br.unitins.hackathon.sismato.service;

import br.unitins.hackathon.sismato.dto.FeatureDTO;
import br.unitins.hackathon.sismato.entity.geo.Feature;
import br.unitins.hackathon.sismato.entity.geo.Properties;
import br.unitins.hackathon.sismato.repository.FeatureRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class FeatureService {
    @Inject
    FeatureRepository featureRepository;

    @Inject
    PropertiesService propertiesService;

    @Transactional
    public Feature save(FeatureDTO featureDTO) {
        Feature feature = FeatureDTO.toEntity(featureDTO);

        Properties properties = propertiesService.findById(featureDTO.properties().id());

        if(properties == null) {
            properties = propertiesService.save(featureDTO.properties());
        }

        feature.setProperties(properties);

        featureRepository.persist(feature);

        return feature;
    }

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll().list();
    }
}
