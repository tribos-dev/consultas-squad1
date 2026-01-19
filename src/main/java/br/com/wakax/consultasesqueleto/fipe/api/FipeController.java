package br.com.wakax.consultasesqueleto.fipe.api;

import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.Modelo;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.com.wakax.consultasesqueleto.fipe.application.service.FipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
public class FipeController implements FipeAPI {

    private final FipeService fipeService;

    @Override
    public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
        log.info("[start] FipeController - listarMarcas");
        List<Marca> marcas = fipeService.listarMarcas(tipoVeiculo);
        log.info("[finish] FipeController - listarMarcas");
        return marcas;
    }

    @Override
    public List<Modelo> listarModelos(String codigoMarca, String tipoVeiculo) {
        log.info("[start] FipeController - listarModelos - codigoMarca: {}, tipoVeiculo: {}",
                codigoMarca, tipoVeiculo);
        List<Modelo> modelos = fipeService.listarModelos(codigoMarca, tipoVeiculo);
        log.info("[finish] FipeController - listarModelos - {} modelos encontrados", modelos.size());
        return modelos;
    }
}

