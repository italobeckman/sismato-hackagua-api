package br.unitins.hackathon.sismato.dto;

import br.unitins.hackathon.sismato.entity.geo.Municipio;

public record MunicipioDTO(
        String codigo,
        String nome
) {

    public static Municipio toEntity(MunicipioDTO municipioDTO) {
        Municipio municipio = new Municipio();
        municipio.setCodigo(municipioDTO.codigo());
        municipio.setNome(municipioDTO.nome());

        return municipio;
    }

    public static MunicipioDTO toDTO(Municipio municipio) {
        return new MunicipioDTO(
                municipio.getCodigo(),
                municipio.getNome()
        );
    }
}
