package br.com.wakax.consultasesqueleto.fipe.controller;

import br.com.wakax.consultasesqueleto.fipe.application.service.FipeService;
import br.com.wakax.consultasesqueleto.fipe.domain.Ano;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.Modelo;
import br.com.wakax.consultasesqueleto.fipe.domain.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotosController {
    @Autowired
    private FipeService fipeService;
    @GetMapping("/marcas")
    public List<Marca> getMarcas() {
        return fipeService.getList("/motos/marcas.json", Marca[].class);
    }
    @GetMapping("/modelos/{codMarca}")
    public List<Modelo> getModelos(@PathVariable String codMarca) {
        return fipeService.getList("/motos/veiculos/" + codMarca + ".json", Modelo[].class);
    }
    @GetMapping("/anos/{codMarca}/{codModelo}")
    public List<Ano> getAnos(@PathVariable String codMarca, @PathVariable int codModelo) {
        return fipeService.getList("/motos/veiculo/" + codMarca + "/" + codModelo + ".json", Ano[].class);
    }
    @GetMapping("/veiculo/{codMarca}/{codModelo}/{codAno}")
    public Veiculo getVeiculo(@PathVariable String codMarca, @PathVariable int codModelo, @PathVariable String codAno) {
        return fipeService.getObject("/motos/veiculo/" + codMarca + "/" + codModelo + "/" + codAno + ".json", Veiculo.class);
    }
}
