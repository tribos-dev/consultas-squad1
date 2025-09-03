package br.com.wakax.consultasesqueleto.fipe.infra;

import org.springframework.stereotype.Repository;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class FipeRepositoryFeign implements FipeRepository {

  private final FipeFeignClient fipeFeignClient;

}

