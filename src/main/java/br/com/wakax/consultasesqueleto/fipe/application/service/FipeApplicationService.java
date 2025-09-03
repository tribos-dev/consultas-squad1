package br.com.wakax.consultasesqueleto.fipe.application.service;

import org.springframework.stereotype.Service;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FipeApplicationService implements FipeService {

  private final FipeRepository fipeRepository;

}

