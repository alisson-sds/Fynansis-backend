package br.fynansis.Fynansis.controller;

import br.fynansis.Fynansis.dtos.AporteDTO;
import br.fynansis.Fynansis.entities.Aporte;
import br.fynansis.Fynansis.entities.Investimento;
import br.fynansis.Fynansis.exceptions.AporteException;
import br.fynansis.Fynansis.exceptions.InvestimentoException;
import br.fynansis.Fynansis.services.AporteService;
import br.fynansis.Fynansis.services.InvestimentoService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aporte")
public class AporteController {

    private AporteService aporteService;

    private InvestimentoService investimentoService;

    @PostMapping("/criar/{idInvestimento}")
    public ResponseEntity<String> criaAporte(@RequestBody AporteDTO aporteDTO, @PathVariable UUID idInvestimento) throws InvestimentoException {
        try {
            Investimento investimento = investimentoService.leInvestimento(idInvestimento);
            aporteService.criaAporte(aporteDTO, investimento);
            return new ResponseEntity<>("Aporte criado com sucesso!", HttpStatusCode.valueOf(200));
        }
        catch (InvestimentoException i){
            return new ResponseEntity<>("Investimento não encontrado!",HttpStatusCode.valueOf(404));
        }

    }

    @GetMapping("/ler/{id}")
    public ResponseEntity<Aporte> leAporte(@PathVariable UUID id) {
        try {
            Aporte aporte = aporteService.leAporte(id);
            return new ResponseEntity<>(aporte, HttpStatusCode.valueOf(200));
        } catch (AporteException i) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @GetMapping("retornarAportes/{id}")
    public ResponseEntity<List<Aporte>> retornaTodosAportes(@PathVariable UUID id) {
        try {
            Investimento investimento = investimentoService.leInvestimento(id);
            List<Aporte> aportes = aporteService.retornaAportes(investimento);
            return new ResponseEntity<>(aportes, HttpStatusCode.valueOf(200));
        } catch (InvestimentoException e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Aporte> atualizaAporte(@RequestBody AporteDTO aporteDTO, @PathVariable UUID id) throws InvestimentoException {
        try {
            Aporte aporte = aporteService.atualizaAporte(aporteDTO, id);
            return new ResponseEntity<>(aporte, HttpStatusCode.valueOf(200));
        } catch (AporteException i) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Aporte> deletaAporte(@PathVariable UUID id) {
        try {
            aporteService.deletaAporte(id);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } catch (AporteException i){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

    public AporteController(AporteService aporteService, InvestimentoService investimentoService){
        this.aporteService = aporteService;
        this.investimentoService = investimentoService;
    }

}
