package br.com.wakax.consultasesqueleto.fipe.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.wakax.consultasesqueleto.fipe.application.service.FipeService;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FipeController implements FipeAPI {

  private final FipeService fipeService;

  @Override
  public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
    return fipeService.listarMarcas(tipoVeiculo);
  }
}


