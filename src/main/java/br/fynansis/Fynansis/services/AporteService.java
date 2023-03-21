package br.fynansis.Fynansis.services;

import br.fynansis.Fynansis.dtos.AporteDTO;
import br.fynansis.Fynansis.entities.Aporte;
import br.fynansis.Fynansis.entities.Investimento;
import br.fynansis.Fynansis.exceptions.AporteException;
import br.fynansis.Fynansis.exceptions.InvestimentoException;
import br.fynansis.Fynansis.repositories.AporteRepository;
import org.springframework.stereotype.Service;

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
        if(aporte == null){
            throw new AporteException("Aporte não encontrado!");
        }
        return aporte;
    }

}
