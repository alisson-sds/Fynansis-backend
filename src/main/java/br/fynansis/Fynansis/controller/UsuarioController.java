package br.fynansis.Fynansis.controller;

import br.fynansis.Fynansis.dtos.LoginDTO;
import br.fynansis.Fynansis.dtos.UsuarioDTO;
import br.fynansis.Fynansis.entities.Usuario;
import br.fynansis.Fynansis.exceptions.UsuarioException;
import br.fynansis.Fynansis.services.UsuarioService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping ("/criar")
    public ResponseEntity<String> criaUsuario(@RequestBody UsuarioDTO usuarioDTO){
        try {
            Usuario usuRetorno = usuarioService.criaUsuario(usuarioDTO);
        } catch (UsuarioException u){
            u.printStackTrace();
            return new ResponseEntity<>("Cadastro inválido!", HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>("Usuário criado com sucesso!", HttpStatusCode.valueOf(200));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> atualizaUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Integer id){
        try{
            Usuario usuRetorno = usuarioService.atualizaUsuario(usuarioDTO, id);
            return new ResponseEntity<>(usuRetorno, HttpStatusCode.valueOf(200));
        } catch (UsuarioException u ){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

    @GetMapping("/ler/{id}")
    public ResponseEntity<Usuario> leUsuario(@PathVariable Integer id) {
        try {
            Usuario usuario = usuarioService.leUsuario(id);
            return new ResponseEntity<>(usuario, HttpStatusCode.valueOf(200));
        } catch (UsuarioException u) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUsuario(@RequestBody LoginDTO loginDTO) {
        try {
            Usuario usuario = usuarioService.loginUsuario(loginDTO.getLogin(), loginDTO.getSenha());
            return new ResponseEntity<>(usuario, HttpStatusCode.valueOf(200));
        } catch (UsuarioException u) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

}
