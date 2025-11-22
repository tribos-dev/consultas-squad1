package br.com.wakax.consultasesqueleto.cep.application.service;

import br.com.wakax.consultasesqueleto.cep.infra.ViacepResponse;
import org.springframework.stereotype.Service;

import br.com.wakax.consultasesqueleto.cep.application.repository.CepRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CepApplicationService implements CepService {

    private final CepRepository cepRepository;

    @Override
    public ViacepResponse buscaEnderecoPorCep(String cep) {
        log.info("[inicia] CepApplicationService - buscaEnderecoPorCep");
        ViacepResponse endereco = cepRepository.buscaEnderecoPorCep(cep);
        log.info("[finaliza] CepApplicationService - buscaEnderecoPorCep");
        return endereco;
    }
}

