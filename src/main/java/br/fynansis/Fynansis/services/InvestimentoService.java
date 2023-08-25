package br.fynansis.Fynansis.services;

import br.fynansis.Fynansis.dtos.InvestimentoDTO;
import br.fynansis.Fynansis.entities.Investimento;
import br.fynansis.Fynansis.entities.Usuario;
import br.fynansis.Fynansis.exceptions.InvestimentoException;
import br.fynansis.Fynansis.repositories.InvestimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvestimentoService {

    private final InvestimentoRepository investimentoRepository;

    public InvestimentoService(InvestimentoRepository investimentoRepository) {
        this.investimentoRepository = investimentoRepository;
    }

    public Investimento criaInvestimento(InvestimentoDTO investimentoDTO, Usuario codUsuario){
        Investimento invest = new Investimento(investimentoDTO, codUsuario);
        return investimentoRepository.save(invest);
    }

    public Investimento leInvestimento(UUID codInvestimento) throws InvestimentoException {
        Investimento invest = investimentoRepository.findByCodInvestimento(codInvestimento);
        if (invest == null) {
            throw new InvestimentoException("Investimento não encontrado!");
        }
        return invest;
    }

    public List<Investimento> retornaTodosInvestimentos(Usuario idUsuario) throws InvestimentoException {
        List<Investimento> investimentos = investimentoRepository.findInvestimentListByCodUsuario(idUsuario);
        if (investimentos.isEmpty()) {
            throw new InvestimentoException("Investimento não encontrado!");
        }
        return investimentos;
    }

    public Investimento atualizaInvestimento(InvestimentoDTO investimentoDTO, UUID codInvestimento) throws InvestimentoException {
        Investimento invest = leInvestimento(codInvestimento);
        invest.atualizaInvestimento(investimentoDTO);
        return investimentoRepository.save(invest);
    }

    public void deletaInvestimento(UUID codInvestimento) throws InvestimentoException {
        Investimento invest = leInvestimento(codInvestimento);
        investimentoRepository.delete(invest);
    }

}
