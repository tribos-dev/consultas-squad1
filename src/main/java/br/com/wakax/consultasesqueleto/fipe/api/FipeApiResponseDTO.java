package br.com.wakax.consultasesqueleto.fipe.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FipeApiResponseDTO(
    @JsonProperty("TipoVeiculo") Integer tipoVeiculo,
    @JsonProperty("Valor") String valor,
    @JsonProperty("Marca") String marca,
    @JsonProperty("Modelo") String modelo,
    @JsonProperty("AnoModelo") Integer anoModelo,
    @JsonProperty("Combustivel") String combustivel,
    @JsonProperty("CodigoFipe") String codigoFipe,
    @JsonProperty("MesReferencia") String mesReferencia,
    @JsonProperty("SiglaCombustivel") String siglaCombustivel) {
    }