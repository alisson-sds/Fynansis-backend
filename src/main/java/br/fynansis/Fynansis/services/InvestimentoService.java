package br.fynansis.Fynansis.services;

import br.fynansis.Fynansis.dtos.InvestimentoDTO;
import br.fynansis.Fynansis.entities.Aporte;
import br.fynansis.Fynansis.entities.Investimento;
import br.fynansis.Fynansis.entities.Usuario;
import br.fynansis.Fynansis.exceptions.InvestimentoException;
import br.fynansis.Fynansis.repositories.AporteRepository;
import br.fynansis.Fynansis.repositories.InvestimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvestimentoService {

    private final InvestimentoRepository investimentoRepository;

    private final AporteRepository aporteRepository;

    public InvestimentoService(InvestimentoRepository investimentoRepository, AporteRepository aporteRepository){
        this.investimentoRepository = investimentoRepository;
        this.aporteRepository = aporteRepository;
    }

    public Investimento criaInvestimento(InvestimentoDTO investimentoDTO, Usuario codUsuario){
        Investimento invest = new Investimento(investimentoDTO, codUsuario);
        return investimentoRepository.save(invest);
    }

    public Investimento leInvestimento(UUID codInvestimento) throws InvestimentoException {
        Investimento invest = investimentoRepository.findByCodInvestimento(codInvestimento);
        if(invest == null){
            throw new InvestimentoException("Investimento não encontrado!");
        }
        return invest;
    }

    public Investimento atualizaInvestimento(InvestimentoDTO investimentoDTO, UUID codInvestimento) throws InvestimentoException {
        Investimento invest = leInvestimento(codInvestimento);
        invest.atualizaInvestimento(investimentoDTO);
        return investimentoRepository.save(invest);
    }

    public void deletaInvestimento(UUID codInvestimento) throws InvestimentoException{
        Investimento invest = leInvestimento(codInvestimento);
        //List<Aporte> aporteList = aporteRepository.findByCodInvestimento_CodInvestimento(codInvestimento);
        //aporteRepository.deleteAll(aporteList);
        investimentoRepository.delete(invest);
    }

}
