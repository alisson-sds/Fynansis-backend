package br.fynansis.Fynansis.repositories;

import br.fynansis.Fynansis.entities.Aporte;
import br.fynansis.Fynansis.entities.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AporteRepository extends JpaRepository<Aporte, Integer> {
    Aporte findByCodAporte(UUID codAporte);

    List<Aporte> findByCodInvestimento(Investimento codInvestimento);


}
