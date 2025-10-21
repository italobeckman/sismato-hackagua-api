package br.unitins.hackathon.sismato.repository;

import br.unitins.hackathon.sismato.entity.sisagua.ControleSemestralAgrotoxico;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ControleSemestralAgrotoxicoRepository {
    @Inject
    EntityManager em;

    public List<ControleSemestralAgrotoxico> findBySiglaInstituicao(String sigla) {
        return em.createQuery("SELECT c FROM ControleSemestralAgrotoxico c WHERE siglaInstituicao like :sigla", ControleSemestralAgrotoxico.class)
                .setParameter("sigla", "%" + sigla + "%")
                .getResultList();
    }
}
