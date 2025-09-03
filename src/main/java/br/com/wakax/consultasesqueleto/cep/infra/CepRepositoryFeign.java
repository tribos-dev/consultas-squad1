package br.com.wakax.consultasesqueleto.cep.infra;

import org.springframework.stereotype.Repository;

import br.com.wakax.consultasesqueleto.cep.application.repository.CepRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CepRepositoryFeign implements CepRepository {

  private final CepFeignClient cepFeignClient;

}

