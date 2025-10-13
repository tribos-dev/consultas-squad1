package br.com.wakax.consultasesqueleto.fipe.application.service;

import br.com.wakax.consultasesqueleto.fipe.api.VeiculoResponseDTO;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import br.com.wakax.consultasesqueleto.fipe.domain.Veiculo;
import org.springframework.stereotype.Service;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FipeApplicationService implements FipeService {

  private final FipeRepository fipeRepository;


  @Override
  public VeiculoResponseDTO consultarValorVeiculo(TipoVeiculo tipoVeiculo, String idMarca, String idModelo, String idAno) {
    log.info("Consultando valor do veículo através do serviço. Tipo: {}, Marca: {}, Modelo: {}, Ano: {}",
            tipoVeiculo.getValor(), idMarca, idModelo, idAno);
    Veiculo veiculoDominio = fipeRepository.buscarValorVeiculo(tipoVeiculo, idMarca, idModelo, idAno);
    return new VeiculoResponseDTO(veiculoDominio);
  }
}

