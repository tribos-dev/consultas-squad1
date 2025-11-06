package br.com.wakax.consultasesqueleto.fipe.infra;

import br.com.wakax.consultasesqueleto.fipe.api.FipeApiResponseDTO;
import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import br.com.wakax.consultasesqueleto.fipe.domain.Veiculo;
import br.com.wakax.consultasesqueleto.handler.APIException;
import br.com.wakax.consultasesqueleto.handler.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FipeRepositoryFeign implements FipeRepository {

  private final FipeFeignClient fipeFeignClient;

  @Override
  public Veiculo buscarValorVeiculo(TipoVeiculo tipoVeiculo, String idMarca, String idModelo, String idAno) {
    log.info("Buscando valor do veículo na Fipe para Tipo: {}, Marca: {}, Modelo: {}, Ano: {}",
            tipoVeiculo.getValor(), idMarca, idModelo, idAno);
    FipeApiResponseDTO apiResponse = fipeFeignClient.buscarValorVeiculo(
            idMarca,
            idModelo,
            idAno,
            tipoVeiculo.getValor()
    );
    Veiculo veiculoDominio = new Veiculo(
            apiResponse.tipoVeiculo(),
            apiResponse.valor(),
            apiResponse.marca(),
            apiResponse.modelo(),
            apiResponse.anoModelo(),
            apiResponse.combustivel(),
            apiResponse.codigoFipe(),
            apiResponse.mesReferencia(),
            apiResponse.siglaCombustivel()
    );
    return veiculoDominio;
  }

  public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
    log.info("[start] FipeRepositoryFeign - listarMarcas");
    List<Marca> marcas = fipeFeignClient.listarMarcas(tipoVeiculo.getValor());
    if (marcas == null || marcas.isEmpty()) {
      throw new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_DADOS_NAO_ENCONTRADOS);
    }
    log.info("[finish] FipeRepositoryFeign - listarMarcas");
    return marcas;
  }
}
