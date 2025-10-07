package br.com.wakax.consultasesqueleto.fipe.application.repository;

import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;

import java.util.List;

public interface FipeRepository {

    List<Marca> listarMarcas(TipoVeiculo tipoVeiculo);
}

