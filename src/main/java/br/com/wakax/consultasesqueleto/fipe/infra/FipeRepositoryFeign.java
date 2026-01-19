package br.com.wakax.consultasesqueleto.fipe.infra;

import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.Modelo;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import br.com.wakax.consultasesqueleto.handler.APIException;
import br.com.wakax.consultasesqueleto.handler.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Repository
@RequiredArgsConstructor
@Slf4j
public class FipeRepositoryFeign implements FipeRepository {

    private final FipeFeignClient fipeFeignClient;

    @Override
    public List<Marca> listarMarcas(TipoVeiculo tipoVeiculo) {
        log.info("[start] FipeRepositoryFeign - listarMarcas");
        List<Marca> marcas = fipeFeignClient.listarMarcas(tipoVeiculo.getValor());
        if (marcas == null || marcas.isEmpty()) {
            throw new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_DADOS_NAO_ENCONTRADOS);
        }
        log.info("[finish] FipeRepositoryFeign - listarMarcas");
        return marcas;
    }

    @Override
    public List<Modelo> listarModelos(String codigoMarca, String tipoVeiculo) {
        log.info("[start] FipeRepositoryFeign - listarModelos - codigoMarca: {}, tipoVeiculo: {}",
                codigoMarca, tipoVeiculo);
        TipoVeiculo tipo = TipoVeiculo.valueOf(tipoVeiculo.toUpperCase());
        ModelosResponse response = fipeFeignClient.listarModelos(tipo.getValor(), codigoMarca);
        if (response == null || response.modelos() == null) {
            log.info("[finish] FipeRepositoryFeign - listarModelos - 0 modelos encontrados");
            return Collections.emptyList();
        }
        List<Modelo> modelos = response.modelos();
        modelos.sort(Comparator.comparing(Modelo::nome));
        log.info("[finish] FipeRepositoryFeign - listarModelos - {} modelos encontrados", modelos.size());
        return modelos;
    }
}


