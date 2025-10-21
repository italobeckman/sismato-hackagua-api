package br.unitins.hackathon.sismato.dto;

import br.unitins.hackathon.sismato.entity.geo.Municipio;

public record MunicipioDTO(
        Long id,
        String name,
        String description
) {

    public static Municipio toEntity(MunicipioDTO municipioDTO) {
        Municipio municipio = new Municipio();
        municipio.setId(municipioDTO.id);
        municipio.setName(municipioDTO.name);
        municipio.setDescription(municipioDTO.description);

        return municipio;
    }

    public static MunicipioDTO toDTO(Municipio municipio) {
        return new MunicipioDTO(
                municipio.getId(),
                municipio.getName(),
                municipio.getDescription()
        );
    }
}
