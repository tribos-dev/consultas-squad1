package br.com.wakax.consultasesqueleto.fipe.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Modelo {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("codigo")
    private int codigo;

    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    
    public int getCodigo() { 
        return codigo; 
    }
    
    public void setCodigo(int codigo) { 
        this.codigo = codigo; 
    }
}
