package br.com.wakax.consultasesqueleto.cep.application.service;

import br.com.wakax.consultasesqueleto.cep.api.EnderecoDetalhadoResponse;
import br.com.wakax.consultasesqueleto.cep.domain.Endereco;
import br.com.wakax.consultasesqueleto.handler.APIException;
import br.com.wakax.consultasesqueleto.handler.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.wakax.consultasesqueleto.cep.application.repository.CepRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Slf4j
public class CepApplicationService implements CepService {

    @Override
    public EnderecoDetalhadoResponse buscaEnderecoPorCep(String cep) {
        log.info("[inicia] CepApplicationService - buscaEnderecoPorCep");
        log.info("[finaliza] CepApplicationService - buscaEnderecoPorCep");
        return null;
    }
}

