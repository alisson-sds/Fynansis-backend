package br.fynansis.Fynansis.repositories;

import br.fynansis.Fynansis.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCodUsuario(Integer codUsuario);

    Usuario findByEmailUsuarioOrLoginUsuarioOrCpfUsuario(String emailUsuario, String loginUsuario, String cpfUsuario);


}