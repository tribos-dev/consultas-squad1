package br.com.wakax.consultasesqueleto.fipe.application.service;

import br.com.wakax.consultasesqueleto.fipe.api.VeiculoResponseDTO;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;

public interface FipeService {
    VeiculoResponseDTO consultarValorVeiculo(TipoVeiculo tipoVeiculo, String idMarca, String idModelo, String idAno);
}

