package br.com.wakax.consultasesqueleto.fipe.application.service;

import br.com.wakax.consultasesqueleto.fipe.domain.Ano;
import br.com.wakax.consultasesqueleto.fipe.domain.ListaModelos;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

public abstract class FipeService {
  @Autowired
  protected RestTemplate restTemplate;
  
  @Value("${fipe.api.base-url}")
  protected String baseUrl;
  
  @Value("${fipe.api.token:}")
  protected String token;

  private HttpEntity<String> createHttpEntity() {
    HttpHeaders headers = new HttpHeaders();
    if (token != null && !token.isEmpty()) {
      headers.set("X-Subscription-Token", token);
    }
    return new HttpEntity<>(headers);
  }

  public abstract List<Marca> listarMarcas(TipoVeiculo tipoVeiculo);
  
  public abstract ListaModelos listarModelos(TipoVeiculo tipoVeiculo, String codigoMarca);
  
  public abstract List<Ano> listarAnos(TipoVeiculo tipoVeiculo, String codigoMarca, String codigoModelo);

  public <T> List<T> getList(String endpoint, Class<T[]> clazz) {
    String url = baseUrl + endpoint;
    ResponseEntity<T[]> response = restTemplate.exchange(url, HttpMethod.GET, createHttpEntity(), clazz);
    return Arrays.asList(response.getBody());
  }

  public <T> T getObject(String endpoint, Class<T> clazz) {
    String url = baseUrl + endpoint;
    ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, createHttpEntity(), clazz);
    return response.getBody();
  }
}
