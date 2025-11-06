package br.com.wakax.consultasesqueleto.fipe.api;

import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fipe")
public interface FipeAPI {

    @GetMapping("/marcas/{idMarca}/modelos/{idModelo}/anos/{idAno}")
    @ResponseStatus(code = HttpStatus.OK)
    VeiculoResponseDTO consultarValorVeiculo (
            @PathVariable("idMarca") String idMarca,
            @PathVariable("idModelo") String idModelo,
            @PathVariable("idAno") String idAno,
            @RequestParam("tipoVeiculo") TipoVeiculo tipoVeiculo);

    @GetMapping("/marcas")
    List<Marca>listarMarcas(@RequestParam TipoVeiculo tipoVeiculo);

}

