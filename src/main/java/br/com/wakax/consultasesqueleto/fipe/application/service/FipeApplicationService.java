package br.com.wakax.consultasesqueleto.fipe.application.service;

import org.springframework.stereotype.Service;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FipeApplicationService implements FipeService {

  private final FipeRepository fipeRepository;

  @Override
  public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
    return fipeRepository.listarMarcas(tipoVeiculo);
  }
}

