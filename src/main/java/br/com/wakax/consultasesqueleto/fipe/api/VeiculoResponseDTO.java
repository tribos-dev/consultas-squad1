package br.com.wakax.consultasesqueleto.fipe.api;

import br.com.wakax.consultasesqueleto.fipe.domain.Veiculo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class VeiculoResponseDTO {
    @JsonProperty("TipoVeiculo")
    Integer tipoVeiculo;
    @JsonProperty("Valor")
    String valor;
    @JsonProperty("Marca")
    String marca;
    @JsonProperty("Modelo")
    String modelo;
    @JsonProperty("AnoModelo")
    Integer anoModelo;
    @JsonProperty("Combustivel")
    String combustivel;
    @JsonProperty("CodigoFipe")
    String codigoFipe;
    @JsonProperty("MesReferencia")
    String mesReferencia;
    @JsonProperty("SiglaCombustivel")
    String siglaCombustivel;

    public VeiculoResponseDTO(Veiculo veiculoDominio) {
        this.tipoVeiculo = veiculoDominio.tipoVeiculo();
        this.valor = veiculoDominio.valor();
        this.marca = veiculoDominio.marca();
        this.modelo = veiculoDominio.modelo();
        this.anoModelo = veiculoDominio.anoModelo();
        this.combustivel = veiculoDominio.combustivel();
        this.codigoFipe = veiculoDominio.codigoFipe();
        this.mesReferencia = veiculoDominio.mesReferencia();
        this.siglaCombustivel = veiculoDominio.siglaCombustivel();
    }
}
