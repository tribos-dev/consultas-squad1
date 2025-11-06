package br.com.wakax.consultasesqueleto.fipe.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wakax.consultasesqueleto.fipe.domain.Ano;
import br.com.wakax.consultasesqueleto.fipe.domain.ListaModelos;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;

@RestController
@RequestMapping("/fipe")
public interface FipeAPI {

  @GetMapping("/marcas")
  ResponseEntity<List<Marca>> listarMarcas(@RequestParam TipoVeiculo tipoVeiculo);

  @GetMapping("/marcas/{codigoMarca}/modelos")
  ResponseEntity<ListaModelos> listarModelos(@PathVariable String codigoMarca, 
                                             @RequestParam TipoVeiculo tipoVeiculo);

  @GetMapping("/marcas/{codigoMarca}/modelos/{codigoModelo}/anos")
  ResponseEntity<List<Ano>> listarAnos(@PathVariable String codigoMarca, 
                                       @PathVariable String codigoModelo, 
                                       @RequestParam TipoVeiculo tipoVeiculo);

}

