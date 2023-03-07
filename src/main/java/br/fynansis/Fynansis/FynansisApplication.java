package br.fynansis.Fynansis;

import br.fynansis.Fynansis.entities.Usuario;
import br.fynansis.Fynansis.repositories.UsuarioRepository;
import br.fynansis.Fynansis.services.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class FynansisApplication {

	public static void main(String[] args) {
		SpringApplication.run(FynansisApplication.class, args);



	}

}
