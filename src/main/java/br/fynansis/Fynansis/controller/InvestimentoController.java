package br.fynansis.Fynansis.controller;

import br.fynansis.Fynansis.dtos.InvestimentoDTO;
import br.fynansis.Fynansis.entities.Investimento;
import br.fynansis.Fynansis.entities.Usuario;
import br.fynansis.Fynansis.exceptions.InvestimentoException;
import br.fynansis.Fynansis.exceptions.UsuarioException;
import br.fynansis.Fynansis.services.InvestimentoService;
import br.fynansis.Fynansis.services.UsuarioService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/investimento")
public class InvestimentoController {

    private InvestimentoService investimentoService;
    private UsuarioService  usuarioService;

    @PostMapping("/criar/{id}")
    public ResponseEntity<Investimento> criaInvestimento(@RequestBody InvestimentoDTO investimentoDTO, @PathVariable Integer id) throws UsuarioException {
        try {
            Usuario usuario = usuarioService.leUsuario(id);
            Investimento investimento = investimentoService.criaInvestimento(investimentoDTO, usuario);
            return new ResponseEntity<>(investimento, HttpStatusCode.valueOf(200));
        } catch (UsuarioException u) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }

    }

    @GetMapping("/ler/{id}")
    public ResponseEntity<Investimento> leInvestimento(@PathVariable UUID id){
        try {
            Investimento investimento = investimentoService.leInvestimento(id);
            return new ResponseEntity<>(investimento, HttpStatusCode.valueOf(200));
        } catch (InvestimentoException i){
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Investimento> atualizaInvestimento(@RequestBody InvestimentoDTO investimentoDTO, @PathVariable UUID id) throws InvestimentoException {
        try {
            Investimento investimento = investimentoService.atualizaInvestimento(investimentoDTO, id);
            return new ResponseEntity<>(investimento, HttpStatusCode.valueOf(200));
        } catch (InvestimentoException i){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Investimento> deletaInvestimento(@PathVariable UUID id) {
        try {
            investimentoService.deletaInvestimento(id);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (InvestimentoException i){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

    public InvestimentoController(InvestimentoService invest, UsuarioService usuarioService) {
        this.investimentoService = invest;
        this.usuarioService      = usuarioService;
    }
}
