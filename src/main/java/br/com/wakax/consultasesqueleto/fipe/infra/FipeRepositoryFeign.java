package br.com.wakax.consultasesqueleto.fipe.infra;

import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import br.com.wakax.consultasesqueleto.handler.APIException;
import br.com.wakax.consultasesqueleto.handler.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
    return fipeFeignClient.listarMarcas(tipoVeiculo.getValor())
            .stream()
            .toList();

  }
}

