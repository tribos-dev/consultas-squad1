package br.com.wakax.consultasesqueleto.cep.application.service;

import br.com.wakax.consultasesqueleto.cep.api.EnderecoDetalhadoResponse;
import br.com.wakax.consultasesqueleto.cep.domain.Endereco;

public interface CepService {

    EnderecoDetalhadoResponse buscaEnderecoPorCep(String cep);
}

