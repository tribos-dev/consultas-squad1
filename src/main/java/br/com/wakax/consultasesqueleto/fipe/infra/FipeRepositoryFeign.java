package br.com.wakax.consultasesqueleto.fipe.infra;

import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import br.com.wakax.consultasesqueleto.fipe.domain.Veiculo;
import org.springframework.stereotype.Repository;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FipeRepositoryFeign implements FipeRepository {

  private final FipeFeignClient fipeFeignClient;
  @Override
  public Veiculo buscarValorVeiculo(TipoVeiculo tipoVeiculo, String idMarca, String idModelo, String idAno) {
    return null;
  }
}

