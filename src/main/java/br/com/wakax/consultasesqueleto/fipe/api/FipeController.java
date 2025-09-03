package br.com.wakax.consultasesqueleto.fipe.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.wakax.consultasesqueleto.fipe.application.service.FipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FipeController implements FipeAPI {

  private final FipeService fipeService;

}

