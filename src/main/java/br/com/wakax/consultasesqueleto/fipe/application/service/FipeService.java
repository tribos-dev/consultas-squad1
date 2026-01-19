package br.com.wakax.consultasesqueleto.fipe.application.service;

import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.Modelo;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;

import java.util.List;

public interface FipeService {

    List<Marca> listarMarcas(TipoVeiculo tipoVeiculo);
    List<Modelo> listarModelos(String codigoMarca, String tipoVeiculo);
}

