package br.fynansis.Fynansis.controller;

import br.fynansis.Fynansis.dtos.AporteDTO;
import br.fynansis.Fynansis.entities.Aporte;
import br.fynansis.Fynansis.entities.Investimento;
import br.fynansis.Fynansis.exceptions.InvestimentoException;
import br.fynansis.Fynansis.services.AporteService;
import br.fynansis.Fynansis.services.InvestimentoService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public AporteController(AporteService aporteService, InvestimentoService investimentoService){
        this.aporteService = aporteService;
        this.investimentoService = investimentoService;
    }

}
