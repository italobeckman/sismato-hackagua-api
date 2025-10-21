package br.unitins.hackathon.sismato.repository;

import br.unitins.hackathon.sismato.entity.geo.Properties;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PropertiesRepository implements PanacheRepository<Properties> {
}
