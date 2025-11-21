package br.com.wakax.consultasesqueleto.cep.api;

import br.com.wakax.consultasesqueleto.cep.domain.Endereco;
import org.springframework.web.bind.annotation.RestController;

import br.com.wakax.consultasesqueleto.cep.application.service.CepService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CepController implements CepAPI {

  private final CepService cepService;

    @Override
    public EnderecoDetalhadoResponse buscaEnderecoPorCep(String cep) {
        log.info("[inicia] CepController - EnderecoDetalhadoResponse");
        EnderecoDetalhadoResponse endereco = cepService.buscaEnderecoPorCep(cep);
        log.info("[finaliza] CepController - EnderecoDetalhadoResponse");
        return endereco;
    }
}

