package br.com.wakax.consultasesqueleto.fipe.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wakax.consultasesqueleto.fipe.application.service.FipeService;
import br.com.wakax.consultasesqueleto.fipe.domain.Ano;
import br.com.wakax.consultasesqueleto.fipe.domain.ListaModelos;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FipeController implements FipeAPI {

  private final FipeService fipeService;

  @Override
  public ResponseEntity<List<Marca>> listarMarcas(@RequestParam TipoVeiculo tipoVeiculo) {
    log.info("Recebida requisição para listar marcas - tipo: {}", tipoVeiculo);
    List<Marca> marcas = fipeService.listarMarcas(tipoVeiculo);
    log.info("Retornando {} marcas", marcas.size());
    return ResponseEntity.ok(marcas);
  }

  @Override
  public ResponseEntity<ListaModelos> listarModelos(@PathVariable String codigoMarca, 
                                                   @RequestParam TipoVeiculo tipoVeiculo) {
    log.info("Recebida requisição para listar modelos - marca: {}, tipo: {}", 
             codigoMarca, tipoVeiculo);
    ListaModelos listaModelos = fipeService.listarModelos(tipoVeiculo, codigoMarca);
    log.info("Retornando {} modelos", listaModelos.getModelos() != null ? listaModelos.getModelos().size() : 0);
    return ResponseEntity.ok(listaModelos);
  }

  @Override
  public ResponseEntity<List<Ano>> listarAnos(@PathVariable String codigoMarca, 
                                              @PathVariable String codigoModelo, 
                                              @RequestParam TipoVeiculo tipoVeiculo) {
    log.info("Recebida requisição para listar anos - marca: {}, modelo: {}, tipo: {}", 
             codigoMarca, codigoModelo, tipoVeiculo);
    
    List<Ano> anos = fipeService.listarAnos(tipoVeiculo, codigoMarca, codigoModelo);
    
    log.info("Retornando {} anos para marca {} e modelo {}", anos.size(), codigoMarca, codigoModelo);
    return ResponseEntity.ok(anos);
  }

}

