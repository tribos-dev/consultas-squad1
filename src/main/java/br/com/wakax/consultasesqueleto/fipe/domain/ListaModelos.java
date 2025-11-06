package br.com.wakax.consultasesqueleto.fipe.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListaModelos {
    @JsonProperty("modelos")
    private List<Modelo> modelos;

    public ListaModelos() {}

    public ListaModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
}

