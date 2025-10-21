package br.unitins.hackathon.sismato.repository;

import br.unitins.hackathon.sismato.entity.geo.Feature;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FeatureRepository implements PanacheRepository<Feature> {
}
