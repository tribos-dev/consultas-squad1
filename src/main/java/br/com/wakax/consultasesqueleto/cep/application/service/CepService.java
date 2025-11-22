package br.com.wakax.consultasesqueleto.cep.application.service;

import br.com.wakax.consultasesqueleto.cep.infra.ViacepResponse;

public interface CepService {

    ViacepResponse buscaEnderecoPorCep(String cep);
}

