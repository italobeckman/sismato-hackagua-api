package br.unitins.hackathon.sismato.dto.snis;

public class ExtensaoRedeUfDTO {
    private String siglaUf;
    private Double totalExtensaoAgua;
    private Double totalExtensaoEsgoto;

    public ExtensaoRedeUfDTO(String siglaUf, Double totalExtensaoAgua, Double totalExtensaoEsgoto) {
        this.siglaUf = siglaUf;
        this.totalExtensaoAgua = totalExtensaoAgua;
        this.totalExtensaoEsgoto = totalExtensaoEsgoto;
    }

    public String getSiglaUf() { return siglaUf; }
    public Double getTotalExtensaoAgua() { return totalExtensaoAgua; }
    public Double getTotalExtensaoEsgoto() { return totalExtensaoEsgoto; }
}