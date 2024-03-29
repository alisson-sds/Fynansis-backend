package br.fynansis.Fynansis.services;

import br.fynansis.Fynansis.dtos.AporteDTO;
import br.fynansis.Fynansis.entities.Aporte;
import br.fynansis.Fynansis.entities.Investimento;
import br.fynansis.Fynansis.exceptions.AporteException;
import br.fynansis.Fynansis.exceptions.InvestimentoException;
import br.fynansis.Fynansis.repositories.AporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AporteService {

    private AporteRepository aporteRepository;

    public AporteService(AporteRepository aporteRepository){ this.aporteRepository = aporteRepository;}

    public Aporte criaAporte(AporteDTO aporteDTO, Investimento investimento) {
        Aporte aporte = new Aporte(aporteDTO,investimento);
        return aporteRepository.save(aporte);
    }

    public Aporte leAporte(UUID codAporte) throws AporteException {
        Aporte aporte = aporteRepository.findByCodAporte(codAporte);
        if (aporte == null) {
            throw new AporteException("Aporte não encontrado!");
        }
        return aporte;
    }

    public List<Aporte> retornaAportes(Investimento codInvestimentos) throws InvestimentoException {
        List<Aporte> aportes = aporteRepository.findByCodInvestimento(codInvestimentos);
        if (aportes.isEmpty()) {
            throw new InvestimentoException("Aporte não encontrado!");
        }
        return aportes;
    }

    public Aporte atualizaAporte(AporteDTO aporteDTO, UUID codAporte) throws AporteException {
        Aporte aporte = leAporte(codAporte);
        aporte.atualizaAporte(aporteDTO);
        return aporteRepository.save(aporte);
    }

    public void deletaAporte(UUID codAporte) throws AporteException {
        Aporte aporte = leAporte(codAporte);
        aporteRepository.delete(aporte);
    }

}
