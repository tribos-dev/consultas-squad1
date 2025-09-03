package br.com.wakax.consultasesqueleto.common.domain;

public record ErrorResponse(
        String code, String message, String traceId, String timestamp) {

}

