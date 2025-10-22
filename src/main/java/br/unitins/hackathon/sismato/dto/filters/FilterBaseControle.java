package br.unitins.hackathon.sismato.dto.filters;

import jakarta.ws.rs.QueryParam;

public record FilterBaseControle(
    @QueryParam("codMunicipio")
    Long codMunicipio,
    @QueryParam("anoReferencia")
    Integer anoReferencia,
    @QueryParam("semestreColeta")
    Integer semestreColeta,
    @QueryParam("mesColeta")
    String mesColeta
) {

}
    