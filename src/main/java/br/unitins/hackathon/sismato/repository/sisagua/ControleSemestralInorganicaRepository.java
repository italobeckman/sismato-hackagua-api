package br.unitins.hackathon.sismato.repository.sisagua;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralInorganica;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacao;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ControleSemestralInorganicaRepository implements BaseControleRepository<ControleSemestralInorganica> {

}
