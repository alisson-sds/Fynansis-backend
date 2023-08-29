package br.fynansis.Fynansis.repositories;

import br.fynansis.Fynansis.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsuario(Integer usuario);

    Usuario findByEmailUsuarioOrLoginUsuarioOrCpfUsuario(String emailUsuario, String loginUsuario, String cpfUsuario);

    Usuario findByLoginUsuarioAndSenhaUsuario(String loginUsuario, String senhaUsuario);


}