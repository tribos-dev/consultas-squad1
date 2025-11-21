package br.com.wakax.consultasesqueleto.cep.application.repository;

import br.com.wakax.consultasesqueleto.cep.api.EnderecoDetalhadoResponse;
import br.com.wakax.consultasesqueleto.cep.domain.Endereco;

public interface CepRepository {

    EnderecoDetalhadoResponse buscaEnderecoPorCep(String cep);
}

