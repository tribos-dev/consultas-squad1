package br.com.wakax.consultasesqueleto.fipe.api;

import br.com.wakax.consultasesqueleto.fipe.application.service.FipeService;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FipeController implements FipeAPI {

    private final FipeService fipeService;

    @Override
    public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
        log.info("[start] FipeController - listarMarcas");
        List<Marca> marcas = fipeService.listarMarcas(tipoVeiculo);
        log.info("[finish] FipeController - listarMarcas");
        return marcas;
    }
}
