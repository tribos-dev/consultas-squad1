package br.com.wakax.consultasesqueleto.cep.domain;

import java.util.Map;

public final class UfInfo {
    private static final Map<String, String> ESTADO =
            Map.ofEntries(
                    Map.entry("AC", "Acre"),
                    Map.entry("AL", "Alagoas"),
                    Map.entry("AP", "Amapá"),
                    Map.entry("AM", "Amazonas"),
                    Map.entry("BA", "Bahia"),
                    Map.entry("CE", "Ceará"),
                    Map.entry("DF", "Distrito Federal"),
                    Map.entry("ES", "Espírito Santo"),
                    Map.entry("GO", "Goiás"),
                    Map.entry("MA", "Maranhão"),
                    Map.entry("MT", "Mato Grosso"),
                    Map.entry("MS", "Mato Grosso do Sul"),
                    Map.entry("MG", "Minas Gerais"),
                    Map.entry("PA", "Pará"),
                    Map.entry("PB", "Paraíba"),
                    Map.entry("PR", "Paraná"),
                    Map.entry("PE", "Pernambuco"),
                    Map.entry("PI", "Piauí"),
                    Map.entry("RJ", "Rio de Janeiro"),
                    Map.entry("RN", "Rio Grande do Norte"),
                    Map.entry("RS", "Rio Grande do Sul"),
                    Map.entry("RO", "Rondônia"),
                    Map.entry("RR", "Roraima"),
                    Map.entry("SC", "Santa Catarina"),
                    Map.entry("SP", "São Paulo"),
                    Map.entry("SE", "Sergipe"),
                    Map.entry("TO", "Tocantins"));

    private static final Map<String, String> REGIAO =
            Map.ofEntries(
                    Map.entry("AC", "Norte"),
                    Map.entry("AL", "Nordeste"),
                    Map.entry("AP", "Norte"),
                    Map.entry("AM", "Norte"),
                    Map.entry("BA", "Nordeste"),
                    Map.entry("CE", "Nordeste"),
                    Map.entry("DF", "Centro-Oeste"),
                    Map.entry("ES", "Sudeste"),
                    Map.entry("GO", "Centro-Oeste"),
                    Map.entry("MA", "Nordeste"),
                    Map.entry("MT", "Centro-Oeste"),
                    Map.entry("MS", "Centro-Oeste"),
                    Map.entry("MG", "Sudeste"),
                    Map.entry("PA", "Norte"),
                    Map.entry("PB", "Nordeste"),
                    Map.entry("PR", "Sul"),
                    Map.entry("PE", "Nordeste"),
                    Map.entry("PI", "Nordeste"),
                    Map.entry("RJ", "Sudeste"),
                    Map.entry("RN", "Nordeste"),
                    Map.entry("RS", "Sul"),
                    Map.entry("RO", "Norte"),
                    Map.entry("RR", "Norte"),
                    Map.entry("SC", "Sul"),
                    Map.entry("SP", "Sudeste"),
                    Map.entry("SE", "Nordeste"),
                    Map.entry("TO", "Norte"));

    private UfInfo() {}

    public static String estadoPorUf(String uf) {
        if (uf == null) return null;
        return ESTADO.getOrDefault(uf.toUpperCase(), null);
    }

    public static String regiaoPorUf(String uf) {
        if (uf == null) return null;
        return REGIAO.getOrDefault(uf.toUpperCase(), null);
    }
}
