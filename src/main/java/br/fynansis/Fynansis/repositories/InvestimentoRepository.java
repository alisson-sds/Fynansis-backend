package br.fynansis.Fynansis.repositories;

import br.fynansis.Fynansis.entities.Investimento;
import br.fynansis.Fynansis.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InvestimentoRepository extends JpaRepository<Investimento, Integer> {
    Investimento findByCodInvestimento(UUID codInvestimento);

    List<Investimento> findInvestimentListByCodUsuario(Usuario codUsuario);


}
