package br.com.wakax.consultasesqueleto.cep.application.repository;

import br.com.wakax.consultasesqueleto.cep.infra.ViacepResponse;

public interface CepRepository {

    ViacepResponse buscaEnderecoPorCep(String cep);
}

