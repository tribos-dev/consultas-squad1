package br.com.wakax.consultasesqueleto.fipe.application.service;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FipeApplicationService implements FipeService {

    private final FipeRepository fipeRepository;

    @Override
    public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
        log.info("[start] FipeApplicationService - listarMarcas");
        List<Marca> marcas = fipeRepository.listarMarcas(tipoVeiculo);
        log.info("[finish] FipeApplicationService - listarMarcas");
        return marcas;
    }
}
