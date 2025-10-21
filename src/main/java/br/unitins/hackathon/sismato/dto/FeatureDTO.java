package br.unitins.hackathon.sismato.dto;

import br.unitins.hackathon.sismato.entity.geo.Feature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public record FeatureDTO(
        String type,
        MunicipioDTO properties,
        JsonNode geometry
) {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static Feature toEntity(FeatureDTO featureDTO) {
        try {
            String geoJsonStr = objectMapper.writeValueAsString(featureDTO.geometry);
            Feature feature = new Feature();
            feature.setType(featureDTO.type);
            feature.setProperties(MunicipioDTO.toEntity(featureDTO.properties));
            feature.setGeometry(geoJsonStr);

            return feature;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static FeatureDTO toDTO(Feature feature) {
        JsonNode json = null;
        try {
            json = objectMapper.readTree(feature.getGeometry());
        } catch (Exception e) {

        }

        return new FeatureDTO(
                feature.getType(),
                MunicipioDTO.toDTO(feature.getProperties()),
                json
        );
    }

}
