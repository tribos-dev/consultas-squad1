package br.com.wakax.consultasesqueleto.common.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignLoggingConfiguration {

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.BASIC;
  }

}

