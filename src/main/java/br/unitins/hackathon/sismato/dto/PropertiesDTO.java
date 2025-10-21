package br.unitins.hackathon.sismato.dto;

import br.unitins.hackathon.sismato.entity.geo.Properties;

public record PropertiesDTO(
        Long id,
        String name,
        String description
) {

    public static Properties toEntity(PropertiesDTO propertiesDTO) {
        Properties properties = new Properties();
        properties.setId(propertiesDTO.id);
        properties.setName(propertiesDTO.name);
        properties.setDescription(propertiesDTO.description);

        return properties;
    }

    public static PropertiesDTO toDTO(Properties properties) {
        return new PropertiesDTO(
                properties.getId(),
                properties.getName(),
                properties.getDescription()
        );
    }
}
