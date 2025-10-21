package br.unitins.hackathon.sismato.dto;

import br.unitins.hackathon.sismato.entity.geo.Feature;

import java.util.List;

public record FeatureCollectionDTO(
        String type,
        List<FeatureDTO> features
) {
    public static FeatureCollectionDTO toDTO(List<Feature> features) {
        return new FeatureCollectionDTO(
                "Feature",
                features.stream().map(FeatureDTO::toDTO).toList()
        );
    }
}
