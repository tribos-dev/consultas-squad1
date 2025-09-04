package br.com.wakax.consultasesqueleto.fipe.domain;

public enum TipoVeiculo {
    CARROS("carros"),
    MOTOS("motos"),
    CAMINHOES("caminhoes");

    private final String valor;

    TipoVeiculo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}