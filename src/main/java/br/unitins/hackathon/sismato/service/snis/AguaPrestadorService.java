package br.unitins.hackathon.sismato.service.snis;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.unitins.hackathon.sismato.dto.snis.AtendimentoUrbanoMunicipioDTO;
import br.unitins.hackathon.sismato.dto.snis.DespesasPrestadorDTO;
import br.unitins.hackathon.sismato.dto.snis.EvolucaoAtendimentoMunicipioDTO;
import br.unitins.hackathon.sismato.dto.snis.EvolucaoEsgotoMunicipioDTO;
import br.unitins.hackathon.sismato.dto.snis.ExtensaoRedeUfDTO;
import br.unitins.hackathon.sismato.dto.snis.InvestimentoNaturezaDTO;
import br.unitins.hackathon.sismato.dto.snis.MediasIndicesAnoDTO;
import br.unitins.hackathon.sismato.dto.snis.PerdasDistribuicaoPrestadorDTO;
import br.unitins.hackathon.sismato.dto.snis.RankingPopulacaoMunicipioDTO;
import br.unitins.hackathon.sismato.dto.snis.ReceitaOperacionalAnoDTO;
import br.unitins.hackathon.sismato.dto.snis.VolumeMedioPrestadorDTO;
import br.unitins.hackathon.sismato.dto.snis.MunicipioAnoOverviewDTO;
import br.unitins.hackathon.sismato.dto.snis.MunicipioAnoPrestadorDTO;
import br.unitins.hackathon.sismato.dto.snis.MunicipioAnoGraficoDTO;
import br.unitins.hackathon.sismato.repository.snis.AguaPrestadorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AguaPrestadorService {

    @Inject
    AguaPrestadorRepository repository;

    private int resolveAno(Integer ano) {
        if (ano != null) return ano;
        Integer last = repository.ultimoAnoDisponivel();
        return last != null ? last : 0;
    }

    public List<Integer> anosDisponiveis() { return repository.anosDisponiveis(); }

    public List<AtendimentoUrbanoMunicipioDTO> atendimentoUrbanoMunicipio(Integer ano, Long idMunicipio) {
        return repository.atendimentoUrbanoMunicipio(resolveAno(ano), idMunicipio);
    }

    public List<EvolucaoAtendimentoMunicipioDTO> evolucaoAtendimentoMunicipios(Long idMunicipio) {
        return repository.evolucaoAtendimentoMunicipios(Optional.ofNullable(idMunicipio));
    }

    public List<ExtensaoRedeUfDTO> extensaoRedePorUf() {
        return repository.extensaoRedePorUf();
    }

    public List<RankingPopulacaoMunicipioDTO> rankingPopulacaoAtendidaPorAno(Integer ano, int limit) {
        return repository.rankingPopulacaoAtendidaPorAno(resolveAno(ano), limit);
    }

    public List<VolumeMedioPrestadorDTO> volumeMedioAguaPorPrestador(Integer ano) {
        return repository.volumeMedioAguaPorPrestador(resolveAno(ano));
    }

    public List<EvolucaoEsgotoMunicipioDTO> evolucaoRelacaoEsgoto(Long idMunicipio) {
        return repository.evolucaoRelacaoEsgoto(Optional.ofNullable(idMunicipio));
    }

    public List<MediasIndicesAnoDTO> mediasIndicesPorAno() {
        return repository.mediasIndicesPorAno();
    }

    public List<PerdasDistribuicaoPrestadorDTO> perdasDistribuicaoPorPrestador(Integer ano) {
        return repository.perdasDistribuicaoPorPrestador(resolveAno(ano));
    }

    public List<ReceitaOperacionalAnoDTO> receitaOperacionalPorAno() {
        return repository.receitaOperacionalPorAno();
    }

    public List<DespesasPrestadorDTO> despesasPorPrestador(Integer ano, String prestador) {
        return repository.despesasPorPrestador(resolveAno(ano), Optional.ofNullable(prestador));
    }

    public List<InvestimentoNaturezaDTO> investimentosPorNatureza(Integer ano) {
        return repository.investimentosPorNatureza(resolveAno(ano));
    }

    public Long countRegistros() { return repository.countRegistros(); }

    public MunicipioAnoOverviewDTO getOverview(Long idMunicipio, Integer ano) {
        return repository.getOverview(idMunicipio, resolveAno(ano));
    }

    public List<MunicipioAnoPrestadorDTO> getPrestadores(Long idMunicipio, Integer ano) {
        return repository.getPrestadores(idMunicipio, resolveAno(ano));
    }

    public MunicipioAnoGraficoDTO getGrafico(Long idMunicipio, Integer ano) {
        List<MunicipioAnoPrestadorDTO> prestadores = getPrestadores(idMunicipio, ano);
        return new MunicipioAnoGraficoDTO(
            prestadores.stream().map(MunicipioAnoPrestadorDTO::prestador).collect(Collectors.toList()),
            prestadores.stream().map(MunicipioAnoPrestadorDTO::populacaoAtendidaAgua).collect(Collectors.toList()),
            prestadores.stream().map(MunicipioAnoPrestadorDTO::volumeAguaProduzido).collect(Collectors.toList()),
            prestadores.stream().map(MunicipioAnoPrestadorDTO::indicePerdaDistribuicao).collect(Collectors.toList()),
            prestadores.stream().map(MunicipioAnoPrestadorDTO::receitaOperacional).collect(Collectors.toList()),
            prestadores.stream().map(MunicipioAnoPrestadorDTO::investimentoAgua).collect(Collectors.toList()),
            prestadores.stream().map(MunicipioAnoPrestadorDTO::investimentoEsgoto).collect(Collectors.toList())
        );
    }
}
