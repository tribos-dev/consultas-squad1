package br.com.wakax.consultasesqueleto.cep.domain;

import lombok.Builder;

@Builder

public record Endereco(
        String cep,
        String logradouro,
        String complemento,
        String unidade,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String regiao,
        String ibge,
        String gia,
        String ddd,
        String siafi) {}
