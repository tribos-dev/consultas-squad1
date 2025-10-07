package br.com.wakax.consultasesqueleto.cep.application.service;

import br.com.wakax.consultasesqueleto.cep.application.repository.CepRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CepApplicationService implements CepService {

    private final CepRepository cepRepository;

}
