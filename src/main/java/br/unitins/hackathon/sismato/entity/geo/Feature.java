package br.unitins.hackathon.sismato.entity.geo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Feature extends DefaultEntity {
    private String type;
    @ManyToOne
    private Municipio municipio;

    @Column(columnDefinition = "TEXT")
    private String geometry;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Municipio getProperties() {
        return municipio;
    }

    public void setProperties(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }
}
