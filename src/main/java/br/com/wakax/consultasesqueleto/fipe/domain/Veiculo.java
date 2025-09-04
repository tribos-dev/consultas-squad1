package br.com.wakax.consultasesqueleto.fipe.domain;

public record Veiculo(
        Integer tipoVeiculo,
        String valor,
        String marca,
        String modelo,
        Integer anoModelo,
        String combustivel,
        String codigoFipe,
        String mesReferencia,
        String siglaCombustivel) {}
