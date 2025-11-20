package br.com.wakax.consultasesqueleto.cep.api;

import lombok.Value;

@Value
public class EnderecoDetalhadoResponse {
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String ddd;
}
