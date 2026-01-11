package br.com.wakax.consultasesqueleto.fipe.api;

import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.Modelo;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fipe")
public interface FipeAPI {

    @GetMapping("/marcas")
    List<Marca> listarMarcas(@RequestParam TipoVeiculo tipoVeiculo);

    @GetMapping("/marcas/{codigoMarca}/modelos")
    List<Modelo> listarModelos(@PathVariable String codigoMarca,
            @RequestParam TipoVeiculo tipoVeiculo);

}

