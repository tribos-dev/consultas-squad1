package br.com.wakax.consultasesqueleto.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@Log4j2
public class RestResponseEntityExceptionHandler {
  @Autowired private MessageUtil messageUtil;

  @ExceptionHandler(APIException.class)
  public ResponseEntity<ErrorApiResponse> handlerGenericException(APIException ex) {
    String message =
            ex.getErrorCode() != null
                    ? messageUtil.getMessage(ex.getErrorCode(), ex.getArgs())
                    : ex.getMessage();
    ErrorApiResponse response =
            ErrorApiResponse.builder().message(message).description(ex.getMessage()).build();
    return ResponseEntity.status(ex.getStatusException()).body(response);
  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorApiResponse> handlerGenericException(Exception ex) {
    log.error("Exception: ", ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                    ErrorApiResponse.builder()
                            .description("INTERNAL SERVER ERROR!")
                            .message("POR FAVOR INFORME AO ADMINISTRADOR DO SISTEMA!")
                            .build());
  }

  @ExceptionHandler(RetryableException.class)
  public ResponseEntity<ErrorApiResponse> handleFeignRetryable(RetryableException ex) {
    log.error("Erro de comunicação (timeout/rede) com serviço externo via Feign", ex);
    ErrorApiResponse body =
            ErrorApiResponse.builder()
                    .message("Serviço externo indisponível ou tempo de resposta esgotado.")
                    .description(ex.getMessage())
                    .build();
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(body);
  }

  @ExceptionHandler(FeignException.class)
  public ResponseEntity<ErrorApiResponse> handleFeignException(FeignException ex) {
    log.error("FeignException não tratada pelo ErrorDecoder. status={} message={}", ex.status(), ex.getMessage());
    HttpStatus status = mapFeignToHttpStatus(ex);
    String description = safeContent(ex);
    if (description == null || description.isBlank()) {
      description = ex.getMessage();
    }
    String message = "Erro ao consultar o serviço externo da Fipe."; // Mensagem mais genérica
    ErrorApiResponse body =
            ErrorApiResponse.builder().message(message).description(description).build();
    return ResponseEntity.status(status).body(body);
  }

  private HttpStatus mapFeignToHttpStatus(FeignException ex) {
    int s = ex.status();
    if (s < 0) {
      return HttpStatus.SERVICE_UNAVAILABLE;
    }
    if (s >= 500) {
      return HttpStatus.BAD_GATEWAY;
    }
    if (s == 429) {
      return HttpStatus.TOO_MANY_REQUESTS;
    }
    if (s == 404) {
      return HttpStatus.NOT_FOUND;
    }
    if (s >= 400) {
      return HttpStatus.BAD_REQUEST;
    }
    HttpStatus resolved = HttpStatus.resolve(s);
    return resolved != null ? resolved : HttpStatus.SERVICE_UNAVAILABLE;
  }

  private String safeContent(FeignException ex) {
    try {
      return ex.contentUTF8();
    } catch (Exception ignore) {
      return null;
    }
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
            .getAllErrors()
            .forEach(
                    (error) -> {
                      String fieldName = ((FieldError) error).getField();
                      String errorMessage = error.getDefaultMessage();
                      errors.put(fieldName, errorMessage);
                    });
    return errors;
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorApiResponse> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
    log.error("Erro de conversão de argumento de método: {}", ex.getMessage());
    String fieldName = ex.getName();
    String requiredType = ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "desconhecido";
    if ("tipoVeiculo".equals(fieldName) && "TipoVeiculo".equals(requiredType)) {
      // Lança sua APIException para que o handler de APIException possa processá-la
      APIException apiException = new APIException(HttpStatus.BAD_REQUEST, ErrorCode.FIPE_TIPO_VEICULO_INVALIDO);
      return handlerGenericException(apiException); // Reutiliza o handler de APIException
    }
    ErrorApiResponse response = ErrorApiResponse.builder()
            .message("Argumento inválido para o campo '" + fieldName + "'.")
            .description(ex.getMessage())
            .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
}