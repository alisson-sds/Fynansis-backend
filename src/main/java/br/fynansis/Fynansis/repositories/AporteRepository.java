package br.fynansis.Fynansis.repositories;

import br.fynansis.Fynansis.entities.Aporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AporteRepository extends JpaRepository<Aporte, Integer> {
    Aporte findByCodAporte(UUID codAporte);

}
