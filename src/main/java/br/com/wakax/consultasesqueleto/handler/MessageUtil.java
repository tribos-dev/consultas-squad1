package br.com.wakax.consultasesqueleto.handler;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {
  private final MessageSource messageSource;

  public MessageUtil(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  public String getMessage(ErrorCode errorCode, Object... args) {
    return messageSource.getMessage(errorCode.getCode(), args, Locale.getDefault());
  }

  public String getMessage(ErrorCode errorCode) {
    return getMessage(errorCode, new Object[0]);
  }
}
