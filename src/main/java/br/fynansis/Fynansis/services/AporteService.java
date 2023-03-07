package br.fynansis.Fynansis.services;

import br.fynansis.Fynansis.dtos.AporteDTO;
import br.fynansis.Fynansis.entities.Aporte;
import br.fynansis.Fynansis.entities.Investimento;
import br.fynansis.Fynansis.repositories.AporteRepository;
import org.springframework.stereotype.Service;

@Service
public class AporteService {

    private AporteRepository aporteRepository;

    public AporteService(AporteRepository aporteRepository){ this.aporteRepository = aporteRepository;}

    public Aporte criaAporte(AporteDTO aporteDTO, Investimento investimento) {
        Aporte aporte = new Aporte(aporteDTO,investimento);
        return aporteRepository.save(aporte);
    }

}
