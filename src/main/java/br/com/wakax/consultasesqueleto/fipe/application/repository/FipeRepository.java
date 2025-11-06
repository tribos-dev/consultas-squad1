package br.com.wakax.consultasesqueleto.fipe.application.repository;

import java.util.List;

import br.com.wakax.consultasesqueleto.fipe.domain.Ano;
import br.com.wakax.consultasesqueleto.fipe.domain.ListaModelos;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;

public interface FipeRepository {

  List<Marca> listarMarcas(TipoVeiculo tipoVeiculo);
  
  ListaModelos listarModelos(TipoVeiculo tipoVeiculo, String codigoMarca);

  List<Ano> listarAnos(TipoVeiculo tipoVeiculo, String codigoMarca, String codigoModelo);

}

