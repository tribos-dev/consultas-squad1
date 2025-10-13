package br.com.wakax.consultasesqueleto.fipe.api;

import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import br.com.wakax.consultasesqueleto.handler.APIException;
import br.com.wakax.consultasesqueleto.handler.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.wakax.consultasesqueleto.fipe.application.service.FipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FipeController implements FipeAPI {

  private final FipeService fipeService;

  @Override
  public VeiculoResponseDTO consultarValorVeiculo(String idMarca, String idModelo, String idAno, TipoVeiculo tipoVeiculo) {
    VeiculoResponseDTO veiculo = fipeService.consultarValorVeiculo(tipoVeiculo, idMarca, idModelo, idAno);
    log.info("VeiculoResponseDTO a ser retornado: {}", veiculo);
    return (veiculo);
  }
}

