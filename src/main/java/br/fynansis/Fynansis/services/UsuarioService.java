package br.fynansis.Fynansis.services;

import br.fynansis.Fynansis.dtos.UsuarioDTO;
import br.fynansis.Fynansis.entities.Usuario;
import br.fynansis.Fynansis.exceptions.UsuarioException;
import br.fynansis.Fynansis.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criaUsuario(UsuarioDTO usuarioDTO) throws UsuarioException {
        String email = usuarioDTO.getEmail();
        String login = usuarioDTO.getLogin();
        String cpf   = usuarioDTO.getCpf();

        Usuario usuario1 = usuarioRepository.findByEmailUsuarioOrLoginUsuarioOrCpfUsuario(email, login, cpf);
        if(usuario1 != null){
            if(email.equals(usuario1.getEmailUsuario())){
                throw new UsuarioException("Email já cadastrado!");
            } else if(login.equals(usuario1.getLoginUsuario())){
                throw new UsuarioException("Login já cadastrado!");
            }
            else{
                throw new UsuarioException("Cpf já cadastrado!");
            }
        }
        Usuario usuario = new Usuario(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizaUsuario(UsuarioDTO usuarioDTO, Integer codUsuario) throws UsuarioException{
        Usuario usuario = usuarioRepository.findByUsuario(codUsuario);
        if(usuario == null){
            throw new UsuarioException("Usuário não encontrado!");
        }
        usuario.atualizaUsuario(usuarioDTO);
        return usuarioRepository.save(usuario);
    }

    public Usuario leUsuario(Integer codUsuario) throws UsuarioException {

        Usuario usuario = usuarioRepository.findByUsuario(codUsuario);
        if (usuario == null) {
            throw new UsuarioException("Usuário não encontrado!");
        }
        return usuario;

    }

    public Usuario loginUsuario(String login, String senha) throws UsuarioException {

        Usuario usuario = usuarioRepository.findByLoginUsuarioAndSenhaUsuario(login, senha);
        if (usuario == null) {
            throw new UsuarioException("Login e/ou senha incorreto(s)!");
        }
        return usuario;

    }


}
