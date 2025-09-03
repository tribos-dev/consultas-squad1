package br.com.wakax.consultasesqueleto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
@RequestMapping("/")
public class ConsultaEsqueletoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsultaEsqueletoApplication.class, args);
  }
}

