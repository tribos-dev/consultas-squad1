package br.com.wakax.consultasesqueleto.fipe.infra;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.wakax.consultasesqueleto.fipe.domain.Ano;
import br.com.wakax.consultasesqueleto.fipe.domain.ListaModelos;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;

@FeignClient(name = "fipe-api", url = "${fipe.api.base-url}")
public interface FipeFeignClient {

  @GetMapping("/{tipoVeiculo}/marcas")
  List<Marca> listarMarcas(@PathVariable String tipoVeiculo);

  @GetMapping("/{tipoVeiculo}/marcas/{codigoMarca}/modelos")
  ListaModelos listarModelos(@PathVariable String tipoVeiculo, @PathVariable String codigoMarca);

  @GetMapping("/{tipoVeiculo}/marcas/{codigoMarca}/modelos/{codigoModelo}/anos")
  List<Ano> listarAnos(@PathVariable String tipoVeiculo, @PathVariable String codigoMarca, @PathVariable String codigoModelo);

}

