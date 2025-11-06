package br.com.wakax.consultasesqueleto.fipe.controller;


import br.com.wakax.consultasesqueleto.fipe.application.service.FipeService;
import br.com.wakax.consultasesqueleto.fipe.domain.Ano;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.Modelo;
import br.com.wakax.consultasesqueleto.fipe.domain.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/caminhoes")
public class CaminhoesController {
    @Autowired
    private FipeService fipeService;
    @GetMapping("/marcas")
    public List<Marca> getMarcas() {
        return fipeService.getList("/caminhoes/marcas.json", Marca[].class);
    }
    @GetMapping("/modelos/{codMarca}")
    public List<Modelo> getModelos(@PathVariable String codMarca) {
        return fipeService.getList("/caminhoes/veiculos/" + codMarca + ".json", Modelo[].class);
    }
    @GetMapping("/anos/{codMarca}/{codModelo}")
    public List<Ano> getAnos(@PathVariable String codMarca, @PathVariable int codModelo) {
        return fipeService.getList("/caminhoes/veiculo/" + codMarca + "/" + codModelo + ".json", Ano[].class);
    }
    @GetMapping("/veiculo/{codMarca}/{codModelo}/{codAno}")
    public Veiculo getVeiculo(@PathVariable String codMarca, @PathVariable int codModelo, @PathVariable String codAno) {
        return fipeService.getObject("/caminhoes/veiculo/" + codMarca + "/" + codModelo + "/" + codAno + ".json", Veiculo.class);
    }
}