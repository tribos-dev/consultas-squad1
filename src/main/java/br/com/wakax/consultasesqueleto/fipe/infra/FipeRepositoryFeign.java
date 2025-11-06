package br.com.wakax.consultasesqueleto.fipe.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import br.com.wakax.consultasesqueleto.fipe.domain.Ano;
import br.com.wakax.consultasesqueleto.fipe.domain.ListaModelos;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FipeRepositoryFeign implements FipeRepository {

  private final FipeFeignClient fipeFeignClient;

  @Override
  public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
    try {
      log.info("Buscando marcas para tipoVeiculo={}", tipoVeiculo);
      List<Marca> marcas = fipeFeignClient.listarMarcas(tipoVeiculo.getValor());
      log.info("Encontradas {} marcas", marcas.size());
      return marcas;
    } catch (FeignException e) {
      log.error("Erro ao buscar marcas via Feign. Status: {}, Message: {}", e.status(), e.getMessage());
      throw e;
    }
  }

  @Override
  public ListaModelos listarModelos(TipoVeiculo tipoVeiculo, String codigoMarca) {
    try {
      log.info("Buscando modelos para tipoVeiculo={}, codigoMarca={}", tipoVeiculo, codigoMarca);
      ListaModelos listaModelos = fipeFeignClient.listarModelos(tipoVeiculo.getValor(), codigoMarca);
      log.info("Encontrados {} modelos", listaModelos.getModelos() != null ? listaModelos.getModelos().size() : 0);
      return listaModelos;
    } catch (FeignException e) {
      log.error("Erro ao buscar modelos via Feign. Status: {}, Message: {}", e.status(), e.getMessage());
      throw e;
    }
  }

  @Override
  public List<Ano> listarAnos(TipoVeiculo tipoVeiculo, String codigoMarca, String codigoModelo) {
    try {
      log.info("Buscando anos para tipoVeiculo={}, codigoMarca={}, codigoModelo={}", 
               tipoVeiculo, codigoMarca, codigoModelo);
      
      List<Ano> anos = fipeFeignClient.listarAnos(tipoVeiculo.getValor(), codigoMarca, codigoModelo);
      
      log.info("Encontrados {} anos para o modelo", anos.size());
      return anos;
      
    } catch (FeignException e) {
      log.error("Erro ao buscar anos via Feign. Status: {}, Message: {}", e.status(), e.getMessage());
      throw e;
    }
  }

}

