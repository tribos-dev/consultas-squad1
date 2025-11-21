package br.com.wakax.consultasesqueleto.cep.infra;

import br.com.wakax.consultasesqueleto.cep.api.EnderecoDetalhadoResponse;
import br.com.wakax.consultasesqueleto.cep.domain.Endereco;
import org.springframework.stereotype.Repository;

import br.com.wakax.consultasesqueleto.cep.application.repository.CepRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CepRepositoryFeign implements CepRepository {

  private final CepFeignClient cepFeignClient;

    @Override
    public EnderecoDetalhadoResponse buscaEnderecoPorCep(String cep) {
        log.info("[inicia] CepRepositoryFeign - buscaEnderecoPorCep");

        log.info("[finaliza] CepRepositoryFeign - buscaEnderecoPorCep");
        return null;
    }
}

