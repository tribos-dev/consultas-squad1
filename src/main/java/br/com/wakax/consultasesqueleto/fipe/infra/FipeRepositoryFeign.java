package br.com.wakax.consultasesqueleto.fipe.infra;

import org.springframework.stereotype.Repository;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FipeRepositoryFeign implements FipeRepository {

  private final FipeFeignClient fipeFeignClient;

  @Override
  public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
    return fipeFeignClient.listarMarcas(tipoVeiculo.getValor())
        .stream()
        .sorted(Comparator.comparing(Marca::nome))
        .toList();
  }
}

