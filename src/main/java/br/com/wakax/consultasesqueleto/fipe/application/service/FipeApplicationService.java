package br.com.wakax.consultasesqueleto.fipe.application.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import br.com.wakax.consultasesqueleto.fipe.domain.Ano;
import br.com.wakax.consultasesqueleto.fipe.domain.ListaModelos;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import br.com.wakax.consultasesqueleto.handler.APIException;
import br.com.wakax.consultasesqueleto.handler.ErrorCode;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FipeApplicationService extends FipeService {

  private final FipeRepository fipeRepository;

  @Override
  public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
    log.info("Iniciando listagem de marcas para tipoVeiculo={}", tipoVeiculo);

    try {
      List<Marca> marcas = fipeRepository.listarMarcas(tipoVeiculo);
      log.info("Retornando {} marcas", marcas.size());
      return marcas;
    } catch (FeignException e) {
      log.error("Erro Feign ao buscar marcas. Status: {}", e.status());
      
      if (e.status() == 404) {
        throw new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_MARCA_NAO_ENCONTRADA);
      }
      
      throw e;
    }
  }

  @Override
  public ListaModelos listarModelos(TipoVeiculo tipoVeiculo, String codigoMarca) {
    log.info("Iniciando listagem de modelos para tipoVeiculo={}, codigoMarca={}", 
             tipoVeiculo, codigoMarca);

    if (!StringUtils.hasText(codigoMarca)) {
      log.warn("Código da marca não pode ser vazio");
      throw APIException.build(HttpStatus.BAD_REQUEST, "Código da marca é obrigatório");
    }

    try {
      ListaModelos listaModelos = fipeRepository.listarModelos(tipoVeiculo, codigoMarca);
      log.info("Retornando {} modelos", listaModelos.getModelos() != null ? listaModelos.getModelos().size() : 0);
      return listaModelos;
    } catch (FeignException e) {
      log.error("Erro Feign ao buscar modelos. Status: {}", e.status());
      
      if (e.status() == 404) {
        throw new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_MODELO_NAO_ENCONTRADO);
      }
      
      throw e;
    }
  }

  @Override
  public List<Ano> listarAnos(TipoVeiculo tipoVeiculo, String codigoMarca, String codigoModelo) {
    log.info("Iniciando listagem de anos para tipoVeiculo={}, codigoMarca={}, codigoModelo={}", 
             tipoVeiculo, codigoMarca, codigoModelo);

    if (!StringUtils.hasText(codigoMarca)) {
      log.warn("Código da marca não pode ser vazio");
      throw APIException.build(HttpStatus.BAD_REQUEST, "Código da marca é obrigatório");
    }

    if (!StringUtils.hasText(codigoModelo)) {
      log.warn("Código do modelo não pode ser vazio");
      throw APIException.build(HttpStatus.BAD_REQUEST, "Código do modelo é obrigatório");
    }

    try {
      List<Ano> anos = fipeRepository.listarAnos(tipoVeiculo, codigoMarca, codigoModelo);
      
      log.info("Retornando {} anos", anos.size());
      return anos;
      
    } catch (FeignException e) {
      log.error("Erro Feign ao buscar anos. Status: {}", e.status());
      
      if (e.status() == 404) {
        throw new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_MODELO_NAO_ENCONTRADO);
      }

      throw e;
    }
  }

  @Override
  public <T> List<T> getList(String endpoint, Class<T[]> clazz) {
    return super.getList(endpoint, clazz);
  }

  @Override
  public <T> T getObject(String endpoint, Class<T> clazz) {
    return super.getObject(endpoint, clazz);
  }
}

