package br.com.wakax.consultasesqueleto.fipe.infra;

import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.Modelo;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import br.com.wakax.consultasesqueleto.handler.APIException;
import br.com.wakax.consultasesqueleto.handler.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import java.util.List;



@Repository
@RequiredArgsConstructor
@Slf4j
public class FipeRepositoryFeign implements FipeRepository {

  private final FipeFeignClient fipeFeignClient;

  @Override
  public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
    log.info("[start] FipeRepositoryFeign - listarMarcas");
    List<Marca> marcas = fipeFeignClient.listarMarcas(tipoVeiculo.getValor());
    if (marcas == null || marcas.isEmpty()) {
      throw new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_DADOS_NAO_ENCONTRADOS);
    }
    log.info("[finish] FipeRepositoryFeign - listarMarcas");
    return marcas;
  }

  @Override
  public List<Modelo> listarModelos(String codigoMarca, TipoVeiculo tipoVeiculo) {
    log.info("[start] FipeRepositoryFeign - listarModelos");
    ModelosResponse response = fipeFeignClient.listarModelos(tipoVeiculo.getValor(),codigoMarca);
    if (response == null || response.modelos() == null || response.modelos().isEmpty()) {
      throw new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_DADOS_NAO_ENCONTRADOS);
    }
    log.info("[finish] FipeRepositoryFeign - listarModelos");
    return response.modelos();
  }
}

