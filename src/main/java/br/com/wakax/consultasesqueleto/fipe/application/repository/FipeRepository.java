package br.com.wakax.consultasesqueleto.fipe.application.repository;


import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import br.com.wakax.consultasesqueleto.fipe.domain.Veiculo;
import java.util.List;

public interface FipeRepository {
    Veiculo buscarValorVeiculo(TipoVeiculo tipoVeiculo, String idMarca, String idModelo, String idAno);
    List<Marca> listarMarcas(TipoVeiculo tipoVeiculo);
}

