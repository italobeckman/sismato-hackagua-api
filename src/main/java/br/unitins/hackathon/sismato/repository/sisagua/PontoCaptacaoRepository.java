package br.unitins.hackathon.sismato.repository.sisagua;

import br.unitins.hackathon.sismato.dto.sisagua.EvolucaoVazaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TipoCaptacaoDTO;
import br.unitins.hackathon.sismato.dto.sisagua.TotalOutorgaDTO;
import br.unitins.hackathon.sismato.entity.sisagua.PontoCaptacao;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PontoCaptacaoRepository implements PanacheRepository<PontoCaptacao>{
    
    public PanacheQuery<PontoCaptacao> findByMunicipio(Long codigoMunicipio){
        return find("codigoIbge", codigoMunicipio);
    }

    /**
     * Retorna a evolução histórica das vazões por ano
     */
    public List<EvolucaoVazaoDTO> evolucaoVazoesPorAno() {
        String sql = "SELECT ano_de_referencia, " +
                "AVG(vazao) AS vazao_media, " +
                "COUNT(*) AS quantidade_pontos " +
                "FROM public.pontos_de_captacao_sisagua " +
                "WHERE uf = 'TO' AND ano_de_referencia IS NOT NULL AND vazao IS NOT NULL " +
                "GROUP BY ano_de_referencia " +
                "ORDER BY ano_de_referencia ASC";
        
        var query = getEntityManager().createNativeQuery(sql);
        
        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();
        
        return rows.stream().map(r -> new EvolucaoVazaoDTO(
                ((Number) r[0]).intValue(),
                (java.math.BigDecimal) r[1],
                ((Number) r[2]).longValue()
        )).collect(Collectors.toList());
    }

    /**
     * Retorna o total de pontos com outorga SIM ou NÃO
     */
    public List<TotalOutorgaDTO> totalPorOutorga() {
        String sql = "SELECT " +
                "CASE WHEN outorga = 'S' THEN 'Sim' " +
                "WHEN outorga = 'N' THEN 'Não' " +
                "ELSE 'Não informado' END AS status_outorga, " +
                "COUNT(*) AS total " +
                "FROM public.pontos_de_captacao_sisagua " +
                "WHERE uf = 'TO' " +
                "GROUP BY CASE WHEN outorga = 'S' THEN 'Sim' " +
                "WHEN outorga = 'N' THEN 'Não' " +
                "ELSE 'Não informado' END " +
                "ORDER BY total DESC";
        
        var query = getEntityManager().createNativeQuery(sql);
        
        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();
        
        return rows.stream().map(r -> new TotalOutorgaDTO(
                (String) r[0],
                ((Number) r[1]).longValue()
        )).collect(Collectors.toList());
    }

    /**
     * Retorna a quantidade de pontos por tipo de captação (Subterrâneo/Superficial)
     */
    public List<TipoCaptacaoDTO> quantidadePorTipoCaptacao() {
        String sql = "SELECT tipo_de_captacao, COUNT(*) AS quantidade " +
                "FROM public.pontos_de_captacao_sisagua " +
                "WHERE uf = 'TO' AND tipo_de_captacao IS NOT NULL " +
                "GROUP BY tipo_de_captacao " +
                "ORDER BY quantidade DESC";
        
        var query = getEntityManager().createNativeQuery(sql);
        
        @SuppressWarnings("unchecked")
        List<Object[]> rows = query.getResultList();
        
        return rows.stream().map(r -> new TipoCaptacaoDTO(
                (String) r[0],
                ((Number) r[1]).longValue()
        )).collect(Collectors.toList());
    }
}
