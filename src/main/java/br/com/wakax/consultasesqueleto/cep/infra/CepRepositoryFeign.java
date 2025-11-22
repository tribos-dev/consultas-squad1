package br.com.wakax.consultasesqueleto.cep.infra;

import br.com.wakax.consultasesqueleto.handler.APIException;
import br.com.wakax.consultasesqueleto.handler.ErrorCode;
import org.springframework.http.HttpStatus;
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
    public ViacepResponse buscaEnderecoPorCep(String cep) {
        log.info("[inicia] CepRepositoryFeign - buscaEnderecoPorCep");
        ViacepResponse endereco = cepFeignClient.buscarPorCep(cep);
        if (endereco == null){
            throw new APIException(HttpStatus.NOT_FOUND, ErrorCode.CEP_NAO_ENCONTRADO);
        }
        log.info("[finaliza] CepRepositoryFeign - buscaEnderecoPorCep");
        return endereco;
    }
}

