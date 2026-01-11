package br.com.wakax.consultasesqueleto.fipe.infra;

import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.Modelo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fipe-api", url = "${fipe.api.base-url}")
public interface FipeFeignClient {

    @GetMapping("/{tipoVeiculo}/marcas")
    List<Marca> listarMarcas(@PathVariable("tipoVeiculo") String tipoVeiculo);
    @GetMapping("/{tipoVeiculo}/marcas/{codigoMarca}/modelos")
    ModelosResponse listarModelos(
            @PathVariable("tipoVeiculo") String tipoVeiculo,
            @PathVariable("codigoMarca") String codigoMarca
    );
}


