package br.com.wakax.consultasesqueleto.fipe.infra;

import br.com.wakax.consultasesqueleto.fipe.api.FipeApiErrorDTO;
import br.com.wakax.consultasesqueleto.handler.APIException;
import br.com.wakax.consultasesqueleto.handler.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Configuration
@Log4j2
@RequiredArgsConstructor
public class FeignConfig {

    private final ObjectMapper objectMapper;
    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            String requestUrl = response.request().url(); // Captura a URL da requisição
            String method = response.request().method();
            log.error("Erro na requisição Feign. URL: {}, Método: {}, Status: {}, Razão: {}",
                    requestUrl, method, response.status(), response.reason());
            String body = null;
            if (response.body() != null) {
                try (InputStream is = response.body().asInputStream()) {
                    body = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                    log.error("Corpo do erro da Fipe: {}", body);
                } catch (IOException e) {
                    log.error("Erro ao ler o corpo da resposta de erro da FIPE", e);
                }
            }
            HttpStatus httpStatus = HttpStatus.resolve(response.status());
            if (httpStatus == null) {
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            if (body != null) {
                try {
                    FipeApiErrorDTO fipeError = objectMapper.readValue(body, FipeApiErrorDTO.class);
                    if (response.status() == 500 && fipeError.error() != null && fipeError.error().contains("failed to locate the information on fipe.org")) {
                        log.warn("Erro da Fipe: Dados não encontrados (status 500 com mensagem específica). Analisando URL: {}", requestUrl);
                        if (requestUrl.contains("/anos/")) {
                            return new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_ANO_NAO_ENCONTRADO);
                        } else if (requestUrl.contains("/modelos/")) {
                            return new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_MODELO_NAO_ENCONTRADO);
                        } else if (requestUrl.contains("/marcas/")) {
                            return new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_MARCA_NAO_ENCONTRADA);
                        }
                        return new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_DADOS_NAO_ENCONTRADOS);
                    }
                    if (fipeError.error() != null && fipeError.error().contains("bad request for year. Expected format:")) {
                        log.warn("Erro da Fipe: Formato de ano inválido. Status: {}, Body: {}", response.status(), body);
                        return new APIException(HttpStatus.BAD_REQUEST, ErrorCode.FIPE_ANO_REQUISICAO_INVALIDA);
                    }
                    if (response.status() == 404 && (fipeError.error() == null || fipeError.error().isBlank())) {
                        log.warn("Erro da Fipe: Campo de modelo vazio ou inválido (status 404 com erro nulo/vazio).");
                        return new APIException(HttpStatus.BAD_REQUEST, ErrorCode.FIPE_MODELO_INVALIDO_VAZIO);
                    }
                } catch (IOException e) {
                    log.error("Erro ao parsear o corpo do erro da FIPE: {}", body, e);
                    return new APIException(httpStatus, ErrorCode.FIPE_API_ERRO, body);
                }
            }
            if (response.status() == 429) {
                return new APIException(HttpStatus.TOO_MANY_REQUESTS, ErrorCode.FIPE_LIMITE_EXCEDIDO);
            }
            if (response.status() >= 500) {
                return new APIException(httpStatus, ErrorCode.FIPE_SERVICO_INDISPONIVEL);
            }
            log.error("Erro genérico da Fipe não mapeado. Status: {}, Body: {}", response.status(), body);
            return new APIException(httpStatus, ErrorCode.FIPE_API_ERRO, body != null ? body : response.reason());
        };
    }
}